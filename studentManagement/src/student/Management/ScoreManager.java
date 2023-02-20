package student.Management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ScoreManager {
	// 성적 검색, 전체 성적, 반별 성적
	// 검색 -> 이름
	// 이름 -> 과목 > 점수
	// Map -> <Student,value = 점수
	Scanner sc = new Scanner(System.in);
	String choice;
	boolean run = true;
	Data data = new Data();

	List<Student> studentList = data.getStudentList();
	List<Lecture> lectureList = data.getLectureList();
	List<Score> scoreList = data.getScoreList();
	Map<Object, Integer> map = new HashMap<Object, Integer>();

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
		System.out.println("---------------------------------------");
		System.out.printf("%-8s%-8s%-8s%-8s\n", "수업명", "학생이름", "담당선생님", "성적");
		System.out.println("---------------------------------------");
		String teacherName = null;
		for (int i = 0; i < studentList.size(); i++) {
			for (int j = 0; j < lectureList.size(); j++) {
				if (studentList.get(i).getSubjectName().equals(lectureList.get(j).getLecture())) {
					teacherName = lectureList.get(j).getTeacherName();
				}
			}
			if (i < scoreList.size()) {
				System.out.printf("%-8s%-8s%-8s%-8d\n", studentList.get(i).getSubjectName(),
						studentList.get(i).getStudentName(), teacherName, scoreList.get(i).getScore());
			} else
				System.out.printf("%-8s%-8s%-8s%-8s\n", studentList.get(i).getSubjectName(),
						studentList.get(i).getStudentName(), teacherName, "성적이없습니다.");
		}
	}

	private void search() {
		while (true) {
			int count = 0;
			System.out.print("학생 이름 입력>");
			String searchName = sc.nextLine();
			System.out.println("\n" + searchName + " 학생의 성적");
			for (int i = 0; i < studentList.size(); i++) {
				if (searchName.equals(studentList.get(i).getStudentName())) {
					System.out.println(studentList.get(i).subjectName + ": " + scoreList.get(i).getScore() + " 점");
					count++;
				}
			}
			if (count == 0) {
				System.out.println("성적데이터가 없습니다.");
			}
			System.out.println("계속 검색하시려면 \"y(Y)\"를 입력하세요.");
			String choice = sc.nextLine();
			if (choice.equals("y".toUpperCase())) {
				continue;
			} else
				break;
		}
	}

	private void print() {
		System.out.println("반별점수");
		List<Student> classList;

	}

}
