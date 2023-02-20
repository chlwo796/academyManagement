package student.Management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//메인 화면 및 로그인 메소드
		
		Scanner sc = new Scanner(System.in);
		boolean run = true; // 로그인 성공시 boolean 값변동없이 메인화면ㄱㄱ
		int count = 0; // 3번틀리면 강종
		
		System.out.println("-----------------");
		System.out.println("이젠학원 관리 프로그램");
		System.out.println("-----------------");
		
		
		StudentManager sm = new StudentManager();
		
		
		while (run) {

			System.out.print("아이디 > ");
			String inputId = sc.nextLine();
			System.out.println("비밀번호 > ");
			String inputPassword = sc.nextLine();
			
			if (inputId.equals(Login.getId()) && inputPassword.equals(Login.getPassword())) {
				count = 0; // 혹시몰라 초기화함
				sm.studentRun(); //StudentManager 클래스의 메뉴 선택 메소드 실행!
				break; // 맞으면 run값 변동없이 while문 실행
			} else {
				if (count == 2) {
					run = false;// 3번틀리면 이순간에 바로 종료
					System.out.println("로그인 실패\n프로그램이 종료됩니다.");
					break;
				}
				System.out.println("다시 입력하세요.");
				count++;
				continue; // continue로 틀리면 count++ 계속 반복
			}
		}
		
		
/*		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s%-8s\n", "1. 학생관리", "2. 강의관리", "3. 성적관리", "4. 출결관리", "5. 종료");
			System.out.println("-----------------------------------------------");
			System.out.println("메뉴선택>");
			String choice = sc.nextLine();
			
			switch (choice) {
			case "1": {
				System.out.println("학생관리 메뉴를 선택했습니다.");
				StudentManager.main(args);
				break;
			}
			case "2": {
				System.out.println("강의관리 메뉴를 선택했습니다.");
				LectureManagement.main(args);
				break;
			}
			case "3": {
				System.out.println("성적관리 메뉴를 선택했습니다.");
				new Score();
				break;
			}
			case "4": {
				System.out.println("출결관리 메뉴를 선택했습니다.");
				break;
			}
			case "5": {
				System.out.println("프로그램 종료!");
				run = false;
				break;
			}

			default: {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
			}
		} */

	} //main end

}
