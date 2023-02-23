package student.Management;

import java.util.Scanner;

public class LectureMenu {

	public static void main(String[] args) {
		LectureManagement cont = new LectureManagement();
		boolean flage = true;
		Scanner sc = new Scanner(System.in);
		
		while (flage) {
			System.out.println(" ");
			System.out.println("-----------------------------------------------------------");
			System.out.println("1.강의 검색 | 2.전체 강의 목록 | 3.선생님 검색 | 4. 이전화면으로");
			System.out.println("-----------------------------------------------------------");
			System.out.print("1번 ~ 4번에 속하는 번호를 입력하세요 -> ");
			String menu = sc.nextLine(); 
			System.out.println(" ");

			switch (menu) {

			case "1":
				cont.serch(); // 강의 검색으로
				break;
			case "2":
				cont.serchAll(); // 전체 강의 목록으로
				break;
			case "3":
				cont.thserch(); // 선생님 검색으로
				break;
			case "4":
				System.out.println("이전화면으로");
				flage = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다. 1번 ~ 4번에 속하는 번호를 입력하세요. ");
			}
		}

	}

}
