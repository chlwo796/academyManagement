package bank;

import java.util.Scanner;

public class BankApplication {
	
	static Scanner sc = new Scanner(System.in);
	private static Account[] accounts = new Account[100];

	public static void main(String[] args) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("----------------------------------------------------------------");
			System.out.print("메뉴 선택 > ");
			
			String menu = sc.nextLine();
			if ( menu.equals("1") ) {
				createAccount();
			} else if ( menu.equals("2") ){
				accountList();
			}else if ( menu.equals("3") ){
				inputMoney();
			}else if ( menu.equals("4") ){
				outMoney();
			}else if ( menu.equals("5") ){
				run = false;
				System.out.println( "프로그램이 종료되었습니다." );
				break;
			} else {
				System.out.println( "메뉴 입력이 잘못되었습니다.\n다시 입력해주세요." );
			}
		
		}
	} //main
	
	private static void createAccount() {
		System.out.println("------------------");
		System.out.println("      계좌생성");
		System.out.println("------------------");
		
		System.out.print("계좌번호: ");
		String num = sc.nextLine();
		System.out.print("계좌주: ");
		String owner = sc.nextLine();
		System.out.print("초기입금액: ");
		int firstMoney = Integer.parseInt(sc.nextLine());
		
		Account newAccount = new Account(num, owner, firstMoney);
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = newAccount;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}
	
	private static void accountList() {
		System.out.println("-------------------");
		System.out.println("      계좌 목록");
		System.out.println("-------------------");
		
		for(int i=0; i<accounts.length; i++) {
			Account account = accounts[i];
			if(account != null) {
				System.out.print("계좌번호: ");
				System.out.print(account.getAccountNumber());
				System.out.print(" / 예금주: ");
				System.out.print(account.getOwner());
				System.out.print(" / 총 예금액: ");
				System.out.print(account.getMoney());
				System.out.println();
			} else  {
				System.out.println("생성된 계좌가 없습니다.");
				break;
			}
		}
	}
	
	private static void inputMoney() {
		System.out.println("-------------------");
		System.out.println("      입금");
		System.out.println("-------------------");
		
		System.out.print("계좌번호: ");
		String num = sc.nextLine();
		System.out.print("예금액: ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account account = findAccount(num);
		if(account == null) {
			System.out.println("결과: 해당하는 계좌가 없습니다.");
			return;
		}
		account.setMoney(account.getMoney() + money);
		System.out.println("결과: 예금이 성공되었습니다.");

	}
	
	private static void outMoney() {
		System.out.println("-------------------");
		System.out.println("      출금");
		System.out.println("-------------------");
		
		System.out.print("계좌번호: ");
		String num = sc.nextLine();
		System.out.print("출금액: ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account account = findAccount(num);
		if(account == null) {
			System.out.println("결과: 해당하는 계좌가 없습니다.");
			return;
		}
		account.setMoney(account.getMoney() - money);
		System.out.println("결과: 출금이 성공되었습니다.");

	}
	
	private static Account findAccount (String accountNumber){
		Account account = null;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				String accountList = accounts[i].getAccountNumber();
				if (accountList.equals(accountNumber)) {
					account = accounts[i];
					break;
				}
			}
		}
		return account;
	}
	

}
