package student.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		//학생 관련 기능
		
		//리스트 생성
		List<Student> studentArray = new ArrayList<Student>();
		
		//객체 추가
		studentArray.add(new Student("홍길동", "010-1111-1111", "1반", "국어"));
		studentArray.add(new Student("이순신", "010-2222-2222", "2반", "수학"));
		studentArray.add(new Student("유관순", "010-3333-3333", "1반", "국어"));
		
		Scanner sc = new Scanner(System.in);
		int menuSelect = 0;
		boolean flag = true;
		String searchName;
		
		
		
		
		
		while(flag) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.학생검색 2.학생등록 3.학생 정보수정 4.학생삭제 5.이전화면으로");
			System.out.println("------------------------------------------------------");
			System.out.print("메뉴 선택 > ");
			menuSelect = sc.nextInt();
			sc.nextLine();
			
			switch(menuSelect) {
				case 1: //학생 검색
					boolean searchOk = false;
					System.out.print("학생 이름을 입력해주세요. > ");
					searchName = sc.nextLine();
					
					for(int i = 0; i<studentArray.size(); i++) {
						
						if(searchName.equals(studentArray.get(i).getStudentName())) {
							System.out.println("이름: " + studentArray.get(i).getStudentName());
							System.out.println("전화번호: " + studentArray.get(i).getPhoneNum());
							System.out.println("수강과목: " + studentArray.get(i).getSubjectName());
							System.out.println("반: " + studentArray.get(i).getClassName());
							searchOk = true;
			
						} 
						
//						if(!(studentArray.get(i).studentName.equals(searchName))) {
//							System.out.println("등록되지 않은 학생입니다.");
//							break;
//						}
					}
					if (!searchOk) {
						System.out.println("등록되지 않은 학생입니다.\n다시 입력해주세요.");
					}
					System.out.println("추가 검색 하시겠습니까? (Y/N)");
					String input = (sc.nextLine()).toUpperCase();
					if(input.equals("Y")) {
						flag = true;
					}
					if (input.equals("N")) {
						break;
					}
					
					
					break;
				case 2: //학생 등록
					System.out.print("등록할 학생 이름 > ");
					String inputName = sc.nextLine();
					System.out.print("전화번호 등록 > ");
					String inputPhone = sc.nextLine();
					System.out.print("수강과목 등록 > ");
					String inputSub = sc.nextLine();
					System.out.print("등록할 반 > ");
					String inputClass = sc.nextLine();
					
					studentArray.add(new Student(inputName, inputPhone, inputClass, inputSub));
					
					System.out.println("학생 정보가 등록되었습니다.");
					break;
					
				case 3: //학생 수정
					Scanner ms = new Scanner(System.in);
					System.out.print("학생 이름을 입력하세요. > ");
					searchName = sc.nextLine();
					
					for(Student s : studentArray) {
						if(s.studentName.equals(searchName)) {
							System.out.print("수정할 전화번호를 입력하세요. > ");
							s.phoneNum = ms.nextLine();
							
							if(s.phoneNum.length()<=13) {
								System.out.println("정보가 수정되었습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}
							
						} else {
							System.out.println("등록되지 않은 학생입니다.");
						}
						
					}
					
					break;
					
				case 4: //학생 삭제
					
				case 5: //이전 화면으로
					
				default: System.out.println("잘못된 입력입니다."); break;
			}
			
		}
		
		

	}

}
