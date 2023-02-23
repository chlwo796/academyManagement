package student.Management;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	// 전체 관리 메뉴 실행 메소드
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
				LectureManagement.main(null);
				break;
			}
			case 3: {
				System.out.println("성적관리 메뉴를 선택했습니다.");
				new ScoreManager();
				break;
			}
			case 4: {
				System.out.println("출결관리 메뉴를 선택했습니다.");
				new Attendance();
				break;
			}
			case 5: {
				System.out.println("프로그램 종료!");
				flag = false;
				break;
			}
			default: {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			}
		}
	} // studentRun end

	// 학생관리 메뉴의 메소드
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
			String input; // 추가검색용 변수
			boolean isThere; // 등록되지 않은 학생 검사용

			while (run) {

				switch (menuSelect) {
				case 1: // 학생 검색
					isThere = false;
					System.out.print("학생 이름을 입력해주세요. > ");
					searchName = sc.nextLine();

					// searchName이 리스트에 있다면 정보 출력
					for (int i = 0; i < studentList.size(); i++) {

						if (searchName.equals(studentList.get(i).getStudentName())) {
							System.out.println("이름: " + studentList.get(i).getStudentName());
							System.out.println("전화번호: " + studentList.get(i).getPhoneNum());
							System.out.println("수강과목: " + studentList.get(i).getSubjectName());
							System.out.println("반: " + studentList.get(i).getClassName());
							isThere = true;

						}

					}

					if (!isThere) {
						System.out.println("등록되지 않은 학생입니다.\n다시 입력해주세요.");
						break;
					}

					System.out.println("추가 검색 하시겠습니까? (Y/N)");
					input = (sc.nextLine()).toUpperCase();
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
					run = false;
					break;

				case 3: // 학생 수정

					Scanner ms = new Scanner(System.in); // 변경할 전화번호를 입력받을 스캐너
					isThere = false;
					
					System.out.print("학생 이름을 입력하세요. > ");
					searchName = sc.nextLine();

					for (int i = 0; i < studentList.size(); i++) {
						String privNum;// 수정 전 전화번호
						privNum = studentList.get(i).getPhoneNum(); // 기존 전화번호를 저장할 변수 선언

						if (searchName.equals(studentList.get(i).getStudentName())) {
							System.out.print("변경할 전화번호를 입력하세요. > ");
							studentList.get(i).setPhoneNum(ms.nextLine());
							System.out.println(
									"전화번호가 " + privNum + "에서 " + studentList.get(i).getPhoneNum() + "으로 변경되었습니다.");
							isThere = true;
						}

					}
					if (!isThere) {
						System.out.println("등록되지 않은 학생입니다.\n다시 입력해주세요.");
						break;
					}

					System.out.println("더 수정 하시겠습니까? (Y/N)");
					input = (sc.nextLine()).toUpperCase();
					if (input.equals("Y")) {
						run = true;
					}
					if (input.equals("N")) {
						run = false;
						break;
					}
					break;

				case 4: // 학생 삭제

					System.out.print("삭제할 학생의 이름을 입력해주세요. > ");
					String delStudent = sc.nextLine();
					isThere = false;
					
					for (int i = 0; i < studentList.size(); i++) {

						if (studentList.get(i).studentName.equals(delStudent)) {

							System.out.println("정말 삭제하시겠습니까? (Y/N)");
							input = (sc.nextLine()).toUpperCase();

							if (input.equals("Y")) {
								studentList.remove(i); //학생 삭제
								System.out.println(delStudent + " 학생의 정보가 삭제되었습니다.");
								isThere = true;
								run = false;
								break;
							} else if (input.equals("N")) {
								System.out.println("메뉴 선택으로 돌아갑니다.");
								isThere = true;
								run = false;
								break;
							}

							break;
						}

					}
					if (!isThere) {
						System.out.println("등록되지 않은 학생입니다.\n다시 입력해주세요.");
						break;
					}

					break;

				case 5: // 이전 화면으로
					System.out.println("이전 화면으로 돌아갑니다.");
					run = false;
					break;

				default:
					System.out.println("잘못된 입력입니다.");
					break;
				} // switch 끝
			}
		}
	}// studentManage() end


}
