package student.Management;

import java.util.Scanner;

public class Login {
	//로그인 관련 필드
	
	private static final String ID = "김원장";
	private static final String PASSWORD = "123456";

	public static String getId() {
		return ID;
	}

	public static String getPassword() {
		return PASSWORD;
	}
	
	void login() {
		Scanner sc = new Scanner(System.in);
		boolean run = true; // 로그인 성공시 boolean 값변동없이 메인화면ㄱㄱ
		int count = 0; // 3번틀리면 강종
		while (run) {
			System.out.println("-----------------------------");
			System.out.println("관리자 아이디와 비밀번호를 입력해주세요.");
			System.out.println("-----------------------------");
			System.out.print("아이디 > ");
			String inputId = sc.nextLine();
			System.out.print("비밀번호 > ");
			String inputPassword = sc.nextLine();
			StudentManager sm = new StudentManager();

			if (inputId.equals(Login.getId()) && inputPassword.equals(Login.getPassword())) {
				count = 0; // 혹시몰라 초기화함
				System.out.println("로그인 성공!");
				sm.studentRun(); // StudentManager 클래스의 메뉴 선택 메소드 실행!
				break; // 맞으면 run값 변동없이 while문 실행
			} else {
				if (count == 2) {
					run = false;// 3번틀리면 이순간에 바로 종료
					System.out.println("로그인 실패\n프로그램이 종료됩니다.");
					break;
				}
				System.out.println("등록되지 않은 계정입니다.\n다시 입력하세요.");
				count++;
				continue; // continue로 틀리면 count++ 계속 반복
			}
		}
	}
}
