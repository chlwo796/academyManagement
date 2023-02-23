package student.Management;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Attendance {

	Scanner sc = new Scanner(System.in);
	String choice; // 메뉴선택 변수
	boolean run = true; // 메뉴 while 변수
	Data data = new Data(); // 데이터클래스 객체생성
	List<Lecture> lectureList = data.getLectureList(); // 선생님목록, 이름 꺼내올려고 가져온다.
	TreeMap<Student, AttendanceData> attendanceMap = data.getAttendanceMap(); // 출결표 가져온다.
	TreeMap<Student, AttendanceData> blackList = new TreeMap<Student, AttendanceData>(new StudentComporator()); // 결석리스트

	Set<Student> set = attendanceMap.keySet(); // 메소드마다 쓰여서 뺴놨다,반복문용

	public Attendance() {
		while (run) {
			System.out.println("---------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s\n", "1. 출결검색", "2. 출석현황", "3. 반별출석", "4. 이전화면");
			System.out.println("---------------------------------------");
			System.out.println("메뉴선택>");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {
				search();
				break;
			}
			case "2": {
				printAll();
				break;
			}
			case "3": {
				print();
				break;
			}
			case "4": {
				System.out.println("이전 화면으로 돌아갑니다.");
				run = false;
				break;
			}
			default: {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
			}
		}
	}

	private void printAll() {
		String teacher = null; // 반복문 안에서 선생님이름 담아준다.
		String status = null; // 출석상태를 표시할 문자열 변수
		System.out.printf("%-5s%-6s%-7s%-8s%-5s\n", "반명", "수업명", "학생이름", "담당선생님", "출석상태");
		if (set.isEmpty()) {
			System.out.println("출결데이터가 없습니다.");
			return;
		}
		for (Student st : set) {
			for (int i = 0; i < lectureList.size(); i++) {
				if (st.getSubjectName().equals(lectureList.get(i).getLecture())) {
					teacher = lectureList.get(i).getTeacherName(); // 선생님이름 뽑아옴
				}
				if (attendanceMap.get(st).getStatus() == 0) {
					status = "결석"; // 출석정보 0 이면 문자열변수에 직접적으로 "출석안함"를 넣어줌.
					blackList.put(st, attendanceMap.get(st)); // 이때 오늘출석안한사람 데이터 리스트 만든다.

				} else {
					status = "출석";
				}
			}
			System.out.printf("%-6s%-6s%-9s%-7s%-5s\n", st.getClassName(), st.getSubjectName(), st.getStudentName(),
					teacher, status);
		}

		if (!blackList.isEmpty()) {
			System.out.println("-------------------------------------------");
			System.out.println("상담필요 학생 : (금일미출석)"); // 출석누적자료 구현이 어려워서 그냥 오늘 출석했냐안했냐로만..
			Set<Student> blackSet = blackList.keySet();
			for (Student st : blackSet) {
				System.out.printf("%-7s%-15s\n", st.getStudentName(), st.getPhoneNum());
			}
			System.out.println("-------------------------------------------");
		}
	}

	private void search() {
		if (set.isEmpty()) {
			System.out.println("출결데이터가 없습니다.");
			return;
		}
		while (!set.isEmpty()) {
			int count = 0;
			String status = null;
			System.out.print("학생 이름 입력>");
			String searchName = sc.nextLine();
			for (Student st : set) {
				if (st.getStudentName().equals(searchName)) {
					count++;
					if (attendanceMap.get(st).getStatus() == 0) {
						status = "결석";
					} else {
						status = "출석";
					}

					System.out.println(searchName + " 학생, 금일 " + status + " 하였습니다.");
				}
			}
			if (count == 0) {
				System.out.println("출석정보에 없습니다.");
			}
			System.out.println("계속 검색하시려면 \"y(Y)\"를 입력하세요.");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				continue;
			} else
				break;
		}

	}

	private void print() {
		int sum1 = 0; // 1반의 출석인원수
		double rate1 = 0;// 1반의 출석률
		int sum2 = 0; // 2반의 출석인원수
		double rate2 = 0; // 2반의 출석률
		// 1반맵 분류
		TreeMap<Student, AttendanceData> tempMap1 = new TreeMap<Student, AttendanceData>(new StudentComporator());
		// 2반맵 분류
		TreeMap<Student, AttendanceData> tempMap2 = new TreeMap<Student, AttendanceData>(new StudentComporator());
		System.out.println("반별 출석 현황");
		System.out.printf("%-5s%-6s%-7s\n", "반명", "수강인원", "출석률");
		for (Student st : set) { // 1반, 2반 분리하겠다
			if (st.getClassName().equals("1반")) {
				tempMap1.put(st, attendanceMap.get(st)); // 1반데이터 몰아줌
				sum1 += attendanceMap.get(st).getStatus(); // 한 반의 출석한 인원수의 누적총합 나타낸다.

			} else if (st.getClassName().equals("2반")) {
				tempMap2.put(st, attendanceMap.get(st)); // 2반데이터 몰아줌
				sum2 += attendanceMap.get(st).getStatus();
			}
		}
		if (!tempMap1.isEmpty()) { // 1반의 인원이 없으면 인원 0명, 출석률 0% -> 이 if조건문을 넣어야 0으로 바로 안나눈다. 에러방지
			// 출석변수 = 출석하면 1 아니면 0 이므로
			// 1반 전체 인원 = tempMap1.size(), 총 합계 = 출석한인원수
			// 따라서 출석률 = (출석한인원수의 합)/(반전체인원) *100
			rate1 = ((double) sum1 / (double) tempMap1.size()) * 100;
		}
		if (!tempMap2.isEmpty()) { // 2반의 인원이 없으면 인원 0명, 출석률 0%
			rate2 = ((double) sum2 / (double) tempMap2.size()) * 100; // 이게 바로 출석률

		}
		// (%-7s)첫번째 오는 문자열에 왼쪽기준 7칸
		// 주고,(%d명)두번째정수옆에"명",(\s=공백),(%.2f%%\n)소수점두자리실수옆에"%"하고줄바꿈(%출력은%%입력해야함)
		System.out.printf("%-7s%d명\s\s\s%.2f%%\n", "1반", tempMap1.size(), rate1);
		System.out.printf("%-7s%d명\s\s\s%.2f%%\n", "2반", tempMap2.size(), rate2);

	}

}
