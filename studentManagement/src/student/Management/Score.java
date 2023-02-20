package student.Management;

<<<<<<< HEAD
import java.util.Scanner;

=======
>>>>>>> 2a78bee4bf56652698cdf1c1e4dc1a9f67d8ad4c
public class Score {
	// 성적 검색, 전체 성적, 반별 성적
	// 검색 -> 이름
	// 이름 -> 과목 > 점수
	// Map -> <Student,value = 점수>
	private int score;
<<<<<<< HEAD
	Student student;
	Scanner sc = new Scanner(System.in);
	String choice;
	boolean run = true;

	public Score() {
		while (run) {
			System.out.println("---------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s\n", "1. 성적검색", "2. 전체성적", "3. 반별 성적", "4. 이전화면");
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

	private void printAll() {
		System.out.println("전체출력");

	}

	private void search() {
		System.out.println("계속 검색하시겠습니까?(y/n)");

	}

	private void print() {
		System.out.println("반별점수");

	}
}

=======
}
>>>>>>> 2a78bee4bf56652698cdf1c1e4dc1a9f67d8ad4c
