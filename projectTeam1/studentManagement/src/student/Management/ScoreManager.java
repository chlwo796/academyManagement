package student.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ScoreManager {

	Scanner sc = new Scanner(System.in);
	String choice;	// 메뉴선택 변수
	boolean run = true;	// 메뉴 while 반복문 변수
	Data data = new Data();	// 데이터클래스 객체생성
	List<Lecture> lectureList = data.getLectureList(); // 선생님 이름 꺼내올려고 가져온다.
	TreeMap<Student, Score> scoreMap = data.getScoreMap(); // 성적표 가져온다.
	TreeMap<Student, Score> blackList = new TreeMap<Student, Score>(new StudentComporator()); // 상담필요학생 모아놓은맵
	Set<Student> set = scoreMap.keySet(); // 메소드마다 쓰여서 뺴놨다 scoreMap의 키값에 해당하는 Set<Student>자료

	public ScoreManager() {
		while (run) {
			System.out.println("---------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s\n", "1. 성적검색", "2. 전체성적", "3. 반별성적", "4. 이전화면");
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
		System.out.printf("%-5s%-6s%-7s%-8s%-5s\n", "반명", "수업명", "학생이름", "담당선생님", "성적");
		if (set.isEmpty()) {
			System.out.println("성적데이터가 없습니다.");
			return;
		}
		for (Student st : set) {	//성적표 반복문
			for (int i = 0; i < lectureList.size(); i++) {
				if (st.getSubjectName().equals(lectureList.get(i).getLecture())) {
					//성적표에 있는 과목명과 강의정보리스트에있는 과목명이 같은 경우 선생님이름을 변수 teacher에 넣어준다 
					teacher = lectureList.get(i).getTeacherName();
				}
				if (scoreMap.get(st).getScore() < 70) {	// 70점보다 낮은 학생 맵에 풋
					blackList.put(st, scoreMap.get(st));

				}
			}
			System.out.printf("%-6s%-6s%-9s%-7s%-2d\n", st.getClassName(), st.getSubjectName(), st.getStudentName(),
					teacher, scoreMap.get(st).getScore());
		}

		if (!blackList.isEmpty()) {
			System.out.println("-------------------------------------------");
			System.out.println("상담필요 학생 : (70점미만)");
			Set<Student> blackSet = blackList.keySet();
			for (Student st : blackSet) {
				System.out.printf("%-7s%-15s\n", st.getStudentName(), st.getPhoneNum());
			}
			System.out.println("-------------------------------------------");
		}
	}

	private void search() {
		if (set.isEmpty()) {
			System.out.println("성적데이터가 없습니다.");
			return;
		}
		while (!set.isEmpty()) {
			int count = 0;
			System.out.print("학생 이름 입력>");
			String searchName = sc.nextLine();
			System.out.println("\n" + searchName + " 학생의 성적");
			for (Student st : set) {
				if (st.getStudentName().equals(searchName)) {
					count++;
					System.out.println(st.getSubjectName() + ": " + scoreMap.get(st).getScore() + " 점");
				}
			}
			if (count == 0) {
				System.out.println("성적정보에 없습니다.");
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
		int sum1 = 0; // 1반의 총점
		int sum2 = 0; // 2반의 총점
		double average1 = 0; // 1반의 평균
		double average2 = 0; // 2반의 평균
		double disSum1 = 0; // 1반의 분산합
		double disSum2 = 0; // 2반의 분산합
		double sd1 = 0; // 1반의 표준편차
		double sd2 = 0; // 1반의 표준편차
		// 1반의 맵
		TreeMap<Student, Score> tempMap1 = new TreeMap<Student, Score>(new StudentComporator());
		// 2반의 맵
		TreeMap<Student, Score> tempMap2 = new TreeMap<Student, Score>(new StudentComporator());
		System.out.println("반별점수");
		System.out.printf("%-5s%-6s%-7s%-8s\n", "반명", "수강인원", "평균점수", "표준편차");
		for (Student st : set) { // 1반, 2반 분리하겠다
			if (st.className.equals("1반")) {
				tempMap1.put(st, scoreMap.get(st));
				sum1 += scoreMap.get(st).getScore();

			} else if (st.className.equals("2반")) {
				tempMap2.put(st, scoreMap.get(st));
				sum2 += scoreMap.get(st).getScore();
			}
		}
		Set<Student> tempSet1 = tempMap1.keySet(); // 1반 셋(반복문 따로돌리려고..)
		Set<Student> tempSet2 = tempMap2.keySet(); // 2반 셋
		if (!tempMap1.isEmpty()) {	// 에러방지 1반데이터가 없으면(size = 0) 연산을 안하고 초기값 0으로 출력이된다.
			average1 = (double) sum1 / tempMap1.size();
			for (Student st : tempSet1) {
				disSum1 += Math.pow(tempMap1.get(st).getScore() - average1, 2); // 1반 분산 합
			}
			sd1 = Math.sqrt((double) (disSum1 / tempSet1.size())); // 분산의 평균의 제곱근(표준편차)
		}
		if (!tempMap2.isEmpty()) {// 에러방지 2반데이터가 없으면(size = 0) 연산을 안하고 초기값 0으로 출력이된다.
			average2 = (double) sum2 / tempMap2.size();
			for (Student st : tempSet2) {
				disSum2 += Math.pow(tempMap2.get(st).getScore() - average2, 2); // 2반 분산의 합
			}
			sd2 = Math.sqrt((double) (disSum2 / tempSet2.size()));	// 2반 표준편차
		}
		// 포맷형식에서 소수점 두번째자리까지 출력하라고 추가해서 따로 Math클래스 쓰던 변수는 삭제하였습니다.
		// (%-7s)첫번째 오는 문자열에 왼쪽기준 7칸
		// 주고,(%d명)두번째정수옆에"명",(\s=공백),(%.2f점)소수점두번째자리실수
//		System.out.printf("%-7s%d명\s\s\s%.2f점\s\s\s%.2f\n", "1반", tempMap1.size(), average1, sd1);
		System.out.println("1반     " + tempMap1.size() + "명    " + Math.round(average1*100.0)/100.0 + "점  " + Math.round(sd1*100.0)/100.0);
//		System.out.printf("%-7s%d명\s\s\s%.2f점\s\s\s%.2f\n", "2반", tempMap2.size(), average2, sd2);
		System.out.println("2반     " + tempMap2.size() + "명    " + Math.round(average2*100.0)/100.0 + "점  " + Math.round(sd2*100.0)/100.0);
	}

}
