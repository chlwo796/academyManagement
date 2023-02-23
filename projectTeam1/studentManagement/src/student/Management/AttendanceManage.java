package student.Management;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AttendanceManage {
	String attendStatus; // 출석 상태

	public AttendanceManage(String attendStatus) {
		super();
		this.attendStatus = attendStatus;
	}

	public String getAttendStatus() {
		return attendStatus;
	}

	public void setAttendStatus(String attendStatus) {
		this.attendStatus = attendStatus;
	}

	public void studentArrive() {// 학생 도착 메소드
		Scanner sc = new Scanner(System.in);
		Data data = new Data();
		System.out.print("본인의 핸드폰 번호를 입력하여주십시오 > ");
		String id = sc.next();
		boolean flag = true;
		while (flag) {
			List<AttendanceManage> list = new ArrayList<AttendanceManage>();
			String sNum;
			String sName;
			for (int i = 0; i < data.getStudentList().size(); i++) {
				sNum = data.getStudentList().get(i).getPhoneNum();// .get(i).getPhoneNum(); // studentList - i인덱스의 전화번호를 받음
				sName = data.getStudentList().get(i).getStudentName();// studentList - i인덱스의 학생이름을 받음			
			
				if(id.equals(sNum)) { // sNum이 입력한 id와 같다면
					System.out.println(sName + " 님, 출석 하시겠습니까? > (y/n) ");
					System.out.println("'n'을 입력하면 프로그램이 종료됩니다");
					String answer = sc.next(); //대답 입력
					if (answer.equals("y")) {
						attendingCheck();// 출석 체크 메소드 연결
						flag = false;	
					}else if (answer.equals("n")) {
						System.out.println("프로그램을 종료합니다");
						flag = false;	
					}else { // y or n가 아닌 다른것 입력됐을 때
						System.out.println("잘못 입력하였습니다");
						System.out.println("다시 입력하여주십시오");		
					}
				}
			}
		}
	}
		/*	if(!id.equals(sNum)) { // sNum이 입력한 id와 다르다면
				System.out.println("등록되지 않은 학생의 번호입니다");
				System.out.println("다시 입력하시겠습니까? > (y/n)");
				String answer = sc.next();
				if(answer.equals("n")) {
					System.out.println("프로그램을 종료합니다");
					flag = false;
				}else if(answer.equals("y")) {
							
				}
			}*/

	public void attendingCheck() {// 출석 체크 메소드
//		Calendar now = Calendar.getInstance();
//		int year = now.get(Calendar.YEAR);
//		int month = now.get(Calendar.MONTH);
//		int day = now.get(Calendar.DAY_OF_WEEK);// 년/월/일/
		
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("HH시mm분ss초"); // 날짜를 특정 형태로 바꿈
		String str = sim.format(date);// 날짜를 문자로 형변환

		if (9 <= date.getHours() && date.getHours() <= 18) {
			System.out.println("출석체크 완료");
			System.out.println("현재 시각 : " + str);
			System.out.println(date.getHours() - 9 + "시간 " + date.getMinutes() + "분 " + date.getSeconds() + "초 지각입니다.");
		} else if (8 <= date.getHours() && date.getHours() < 9) {
			System.out.println("출석체크 완료");
			System.out.println("현재 시각 : " + str);
			System.out.println("정상 출석 입니다.");
		} else if (0 <= date.getHours() && date.getHours() < 8){
		 	System.out.println("너무 일찍 오셨습니다");
			System.out.println("오픈시간 이후에 등원 부탁드립니다.");
		} else {
			System.out.println("출석 가능한 시간이 지났습니다.");
			System.out.println("내일 다시 등원해주십시오.");
		}

	}
}
