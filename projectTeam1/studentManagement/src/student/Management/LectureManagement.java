package student.Management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LectureManagement {

	Scanner sc;

	LectureManagement() {
		sc = new Scanner(System.in);
	}

	// 객체 생성 - 추가한 부분
		Data data = new Data();
		List<Lecture> lectureList = data.getLectureList();
		List<Student> studentList = data.getStudentList();

		// 강의 검색
		void serch() {

			String find; // 강의 과목 받는 곳

			System.out.print("검색할 강의 과목을 입력하세요 : ");
			find = sc.next(); // 강의 과목 입력
			String num = null;
			int count = 0;
			for (int i = 0; i < lectureList.size(); i++) { // list 크기만큼 for문 실행

				// 강의 검색
				if (find.equals(lectureList.get(i).getLecture())) {
					count++;
					System.out.println("=================================");
					System.out.println("강의 : " + lectureList.get(i).getLecture());
					System.out.println("선생님 : " + lectureList.get(i).getTeacherName());
					System.out.println("강의료 : " + lectureList.get(i).getTuition());
					System.out.print("수강 학생 수를 구하기 위해서 1.(국어) 2.(수학) 3.(영어) 1~3 숫자를 입력하세요. : ");
					
					num = sc.nextLine(); // 1~3 숫자 입력
					studentsEnrolled(); // 수강 학생 수 구하는 메소드 호출
					System.out.println("=================================");
					break;
				}  

			} if(count==0) {
				System.out.println("검색에 실패했습니다.");
			}
		}

		// 전체 강의 목록
		void serchAll() {
			System.out.println("===== 전체 강의 목록 =====");
			System.out.printf("%3s\t%3s\t%3s \n", " 수업명", "담당선생님", "수강료");
			System.out.println("=======================");
			for (int i = 0; i < lectureList.size(); i++) {
				System.out.printf("%3s\t%3s\t%3s \n", lectureList.get(i).getLecture(), lectureList.get(i).getTeacherName(),
						lectureList.get(i).getTuition());
			}
			System.out.println("=======================");
		}

		// 선생님 검색
		void thserch() {

			String find; // 선생님 이름 받는 곳
			String num = null;
			
			boolean flag = true;
			while (flag) {
			System.out.print("검색할 선생님을 입력하세요 : ");
			find = sc.next();
			int count = 0;

			for (int i = 0; i < lectureList.size(); i++) { // 선생님 검색
				if (find.equals(lectureList.get(i).getTeacherName())) {
					count++;
					System.out.println("담당 과목 : " + lectureList.get(i).getLecture());
				//	System.out.print("수강 학생 수를 구하기 위해서 1.(국어) 2.(수학) 3.(영어) 1~3 숫자를 입력하세요. : ");
				}  
			} if(count==0) {
				System.out.println("검색에 실패했습니다."); break;
			}
			System.out.print("수강 학생 수를 구하기 위해서 1.(국어) 2.(수학) 3.(영어) 1~3 숫자를 입력하세요. : ");
			num = sc.nextLine(); // 1~3 숫자 입력
			studentsEnrolled(); // 수강 학생 수 구하는 메소드 호출
			System.out.print("담당 학생 이름을 구하기 위해서 1.(국어) 2.(수학) 3.(영어) 1~3 숫자를 입력하세요. : ");
			studentsEnrolled2(); // 수강 학생 이름 구하는 메소드 호출
			break;
		}
		}

		void studentsEnrolled() { // 수강 학생 수 구하는 메소드
			String num = null;
			num = sc.nextLine();
			switch (num) {
			case "1": {

				int cnt1 = 0;
				for (int i = 0; i < studentList.size(); i++) { // 학생 리스트에서 그 학생이 국어를 가지고 있으면 그때그때 카운트를 올림
					if (studentList.get(i).subjectName.equals("국어")) {
						cnt1++;
					} else {
						continue;
					}
				}
				System.out.println("국어 수강 학생수는 : " + cnt1); // 카운트 올라간 수를 출력해줌
				break;
			}
			case "2": {

				int cnt1 = 0;
				for (int i = 0; i < studentList.size(); i++) { // 학생 리스트에서 그 학생이 수학을 가지고 있으면 그때그때 카운트를 올림
					if (studentList.get(i).subjectName.equals("수학")) {
						cnt1++;
					} else {
						continue;
					}
				}
				System.out.println("수학 수강 학생수는 : " + cnt1); // 카운트 올라간 수를 출력해줌
				break;
			}
			case "3": {

				int cnt1 = 0;
				for (int i = 0; i < studentList.size(); i++) { // 학생 리스트에서 그 학생이 영어를 가지고 있으면 그때그때 카운트를 올림
					if (studentList.get(i).subjectName.equals("영어")) {
						cnt1++;
					} else {
						continue;
					}
				}
				System.out.println("영어 수강 학생수는 : " + cnt1); // 카운트 올라간 수를 출력해줌
				break;
			}
			default:
				System.out.println("잘못 입력 하셨습니다. [1 ~ 3] 숫자를 입력하세요.");
			}
		}

		void studentsEnrolled2() { // 수강 학생 이름 구하는 메소드
			String num = null;
			num = sc.nextLine();
			switch (num) {
			case "1": {

				for (int i = 0; i < studentList.size(); i++) {
					if (studentList.get(i).subjectName.equals("국어")) { // 학생 리스트에서 그 학생이 국어를 가지고 있으면 그때그때 출력을 함
						System.out.print(studentList.get(i).studentName + ",");
					} else {
						continue;
					}
				}
				System.out.println("을/를 담당중입니다.");
				break;
			}
			case "2": {

				for (int i = 0; i < studentList.size(); i++) {
					if (studentList.get(i).subjectName.equals("수학")) { // 학생 리스트에서 그 학생이 수학를 가지고 있으면 그때그때 출력을 함
						System.out.print(studentList.get(i).studentName + ",");
					} else {
						continue;
					}
				}
				System.out.println("을/를 담당중입니다.");
				break;
			}
			case "3": {

				for (int i = 0; i < studentList.size(); i++) { // 학생 리스트에서 그 학생이 영어를 가지고 있으면 그때그때 출력을 함
					if (studentList.get(i).subjectName.equals("영어")) {
						System.out.print(studentList.get(i).studentName + ",");
					} else {
						continue;
					}
				}
				System.out.println("을/를 담당중입니다.");
				break;
			}
			default:
				System.out.println("잘못 입력 하셨습니다. [1 ~ 3] 숫자를 입력하세요.");
			}
		}

	}