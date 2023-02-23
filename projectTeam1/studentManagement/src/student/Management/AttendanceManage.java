package student.Management;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
			for (int i = 0; i < data.getStudentList().size(); i++) {
				String pNum = data.getStudentList().get(i).phoneNum; // i인덱스의 전화번호를 받음
				String sName = data.getStudentList().get(i).studentName;// i인덱스의 학생이름을 받음
				if (id.contains(pNum)) {
					System.out.println(sName + " 님이 도착하였습니다");
					System.out.print("출석 하시겠습니까? > (y/n) ");
					String answer = sc.next();
					if (answer.equals("y")) {
						attendingCheck();// 출석 체크 메소드 연결
						break;
					} else if (answer.equals("n")) {
						System.out.println("종료합니다");
						break;
					}
				} else {
					System.out.println("등록되지 않은 학생의 번호입니다");
					System.out.println("다시 입력하시겠습니까? > (y/n)");
					String answer = sc.next();
					if (answer.equals("y")) {
						return;
					} else
						break;
				}
			}
			break;
		}
	}

//			if(id.) {
//					System.out.println("등록되지 않은 학생의 번호입니다");
//					System.out.println("다시 입력하시겠습니까? > (y/n)");
//					String answer = sc.next();
//				if(answer.equals("y")) {
//						break;
//					}else if(answer.equals("n")) {
//						System.out.println("종료합니다");
//					}
//				}
//			}
//		System.out.println("잘못 입력하였습니다");
//		System.out.println("다시 입력하시겠습니까? > (y/n)");
//		String answer = sc.next();
//		if(answer.equals("y")) {
//				continue;
//		}else if(answer.equals("n")) {
//			break;
//			}

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
		} else {
			System.out.println("출석 가능한 시간이 아닙니다");
		}

	}
}
