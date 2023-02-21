package student.Management;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ScoreManager {

	Scanner sc = new Scanner(System.in);
	String choice;
	boolean run = true;
	Data data = new Data();
	List<Lecture> lectureList = data.getLectureList();	// 선생님 이름 꺼내올려고 가져온다.
	TreeMap<Student, Score> scoreMap = data.getScoreMap();	// 성적표 가져온다.
	TreeMap<Student, Score> blackList = new TreeMap<Student, Score>(new StudentComporator());	// 상담필요학생 모아놓은맵
	Set<Student> set = scoreMap.keySet();	// 메소드마다 쓰여서 뺴놨다

	public ScoreManager() {
		test();
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

	private void test() {

	}

	private void printAll() {
		String teacher = null;	// 반복문 안에서 선생님이름 담아준다.
		System.out.printf("%-5s%-6s%-7s%-8s%-5s\n", "반명", "수업명", "학생이름", "담당선생님", "성적");
		if (set.isEmpty()) {
			System.out.println("성적데이터가 없습니다.");
			return;
		}
		for (Student st : set) {
			for (int i = 0; i < lectureList.size(); i++) {
				if (st.getSubjectName().equals(lectureList.get(i).getLecture())) {
					teacher = lectureList.get(i).getTeacherName();
				}
				if (scoreMap.get(st).getScore() < 70) {
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
		} else {	// 이거는 나중에 없애도될거같다.
			System.out.println("성적이 대체로 좋습니다.");
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
					System.out.println(st.getSubjectName() + ": " + scoreMap.get(st).getScore() + " 점");
				}
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
		int sum1 = 0;
		double average1 = 0;
		int sum2 = 0;
		double average2 = 0;
		double result1 = 0;
		double result2 = 0;
		String className = null;	// 반명을 변수에 대입해볼라고 했는데,,일단 보류
		TreeMap<Student, Score> tempMap1 = new TreeMap<Student, Score>(new StudentComporator());
		TreeMap<Student, Score> tempMap2 = new TreeMap<Student, Score>(new StudentComporator());
		System.out.println("반별점수");
		System.out.printf("%-5s%-6s%-7s%-8s\n", "반명", "수강인원", "평균점수", "표준편차");
		for (Student st : set) {	// 1반, 2반 분리하겠다 -> 아니면 배열을 뽑아서 Math클래스를 써볼까 싶기도 하다..
			if (st.className.equals("1반")) {
				tempMap1.put(st, scoreMap.get(st));
				sum1 += scoreMap.get(st).getScore();

			} else if (st.className.equals("2반")) {
				tempMap2.put(st, scoreMap.get(st));
				sum2 += scoreMap.get(st).getScore();
			}
		}
		Set<Student> tempSet1 = tempMap1.keySet();	// 1반 셋(반복문 따로돌리려고..)
		Set<Student> tempSet2 = tempMap2.keySet();	// 2반 셋
		average1 = (double) (sum1 / tempMap1.size());
		average2 = (double) (sum2 / tempMap2.size());

		double disSum1 = 0; // 분산의 합
		double disSum2 = 0;
		for (Student st : tempSet1) {
			disSum1 += Math.pow(tempMap1.get(st).getScore() - average1, 2);	// 1반 분산 합
		}
		for (Student st : tempSet2) {
			disSum2 += Math.pow(tempMap2.get(st).getScore() - average2, 2);	// 2반 분산의 합
		}
		result1 = Math.sqrt((double) (disSum1 / tempSet1.size()));	// 분산의 평균의 제곱근(표준편차)
		result2 = Math.sqrt((double) (disSum2 / tempSet2.size()));	// 근데 소수점이 너무 김

		double sd1 = Math.round(result1 * 100) / 100.0;	//표준편차 소수점 둘째자리까지만 계산(최종변수)
		double sd2 = Math.round(result2 * 100) / 100.0;

		System.out.printf("%-7s%-6s%-9s%-6s\n", "1반", tempMap1.size() + "명", average1, sd1);
		System.out.printf("%-7s%-6s%-9s%-6s\n", "2반", tempMap2.size() + "명", average2, sd2);
		// 반명 입력으로해서 출력해주면 다 계산이 되어야 한다..
	}

}
