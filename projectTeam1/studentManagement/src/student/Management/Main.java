package student.Management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//메인 화면 및 로그인 메소드
		
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		AttendanceManage atdm = new AttendanceManage(null);
		
		System.out.println("-----------------");
		System.out.println("이젠학원 관리 프로그램");
		System.out.println("-----------------");
		System.out.println("코드를 입력하세요\n관리자 > 0 \n학생 > 1");
		int inputCode = sc.nextInt();
		switch(inputCode) {
		case 0 : {
			System.out.println("관리자가 로그인을 합니다"); 
			login.login();
		}break;
		case 1 : {
			System.out.println("학생이 로그인을 합니다"); 
			atdm.studentArrive();
		}break;
		default: {
			System.out.println("잘못된 입력입니다.");
			System.out.println("프로그램을 종료합니다.");
			}break;
		}
		
	}
}