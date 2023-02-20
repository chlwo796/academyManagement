package student.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

	// 객체 생성
	Data data = new Data();

	// 메소드 호출
	List<Student> studentList = data.getStudentList();
	List<Lecture> lectureList = data.getLectureList();

	// 리스트 생성
	// List<Student> studentArray = new ArrayList<Student>();

	Scanner sc = new Scanner(System.in);
	int menuSelect = 0;
	boolean flag = true;
	String searchName;

	void studentRun() {

		while (flag) {

			System.out.println("-----------------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s%-8s\n", "1. 학생관리", "2. 강의관리", "3. 성적관리", "4. 출결관리", "5. 종료");
			System.out.println("-----------------------------------------------");
			System.out.print("메뉴 선택 > ");
			menuSelect = sc.nextInt();
			sc.nextLine();

			switch (menuSelect) {
				case 1: {
					System.out.println("학생관리 메뉴를 선택했습니다.");
					studentManage();
					break;
				}
				case 2: {
					System.out.println("강의관리 메뉴를 선택했습니다.");
					// classManage();
					break;
				}
				case 3: {
					System.out.println("성적관리 메뉴를 선택했습니다.");
					new Score();
					// gradesManage();
					break;
				}
				case 4: {
					System.out.println("출결관리 메뉴를 선택했습니다.");
					// attendanceManage();
					break;
				}
				case 5: {
					System.out.println("프로그램 종료!");
					flag = false;
					break;
				}
				default: {
					System.out.println("잘못입력하셨습니다.");
					continue;
				}
			}
		}
	} // studentRun end
	
	

	void studentManage() {
		Boolean flag = true;
		
		while (flag) {

			System.out.println("------------------------------------------------------");
			System.out.println("1.학생검색 2.학생등록 3.학생 정보수정 4.학생삭제 5.이전화면으로");
			System.out.println("------------------------------------------------------");
			System.out.print("메뉴 선택 > ");
			menuSelect = sc.nextInt();
			sc.nextLine();

			boolean run = true;

			while (run) {

				switch (menuSelect) {
				case 1: // 학생 검색
					boolean searchOk = false;
					System.out.print("학생 이름을 입력해주세요. > ");
					searchName = sc.nextLine();

					for (int i = 0; i < studentList.size(); i++) {

						if (searchName.equals(studentList.get(i).getStudentName())) {
							System.out.println("이름: " + studentList.get(i).getStudentName());
							System.out.println("전화번호: " + studentList.get(i).getPhoneNum());
							System.out.println("수강과목: " + studentList.get(i).getSubjectName());
							System.out.println("반: " + studentList.get(i).getClassName());
							searchOk = true;

						}

//								if(!(studentArray.get(i).studentName.equals(searchName))) {
//									System.out.println("등록되지 않은 학생입니다.");
//									break;
//								}
					}

					if (!searchOk) {
						System.out.println("등록되지 않은 학생입니다.\n다시 입력해주세요.");
					}
					System.out.println("추가 검색 하시겠습니까? (Y/N)");
					String input = (sc.nextLine()).toUpperCase();
					if (input.equals("Y")) {
						run = true;
					}
					if (input.equals("N")) {
						// searchOk = false;
						run = false;
						break;
					}

					break;

				case 2: // 학생 등록
					System.out.print("등록할 학생 이름 > ");
					String inputName = sc.nextLine();
					System.out.print("전화번호 등록 > ");
					String inputPhone = sc.nextLine();
					System.out.print("수강과목 등록 > ");
					String inputSub = sc.nextLine();
					System.out.print("등록할 반 > ");
					String inputClass = sc.nextLine();

					studentList.add(new Student(inputName, inputPhone, inputClass, inputSub));

					System.out.println("학생 정보가 등록되었습니다.");
					break;

				case 3: // 학생 수정
					Scanner ms = new Scanner(System.in);
					System.out.print("학생 이름을 입력하세요. > ");
					searchName = sc.nextLine();

					for (Student s : studentList) {
						if (s.studentName.equals(searchName)) {
							System.out.print("수정할 전화번호를 입력하세요. > ");
							s.phoneNum = ms.nextLine();

							if (s.phoneNum.length() <= 13) {
								System.out.println("정보가 수정되었습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}

						} else {
							System.out.println("등록되지 않은 학생입니다.");
						}

					}

					break;

				case 4: // 학생 삭제

				case 5: // 이전 화면으로

				default:
					System.out.println("잘못된 입력입니다.");
					break;
				} // switch 끝
			}
		}
	}// studentManage end

}
