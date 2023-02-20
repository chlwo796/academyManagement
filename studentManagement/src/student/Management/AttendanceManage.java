package student.Management;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AttendanceManage extends Data{ //data의 학생이름 끌어쓰려고
	String name; //학생 이름
	String attendStatus; // 출석 상태
	Date date; // 날짜 유틸
	SimpleDateFormat spdf; // 날짜 유틸
	
	public String getName() {
		return name;
	}

	public void setName(String name) {//<< 여기에 data의 이름을 끌어와야하는데 방법을 모르겠다
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SimpleDateFormat getSpdf() {
		return spdf;
	}

	public void setSpdf(SimpleDateFormat spdf) {
		this.spdf = spdf;
	}

	public void attendingCheck() {//출석 체크 메소드
		
		Date date = new Date();//날짜 출력 유틸(영문)
		SimpleDateFormat sim = new SimpleDateFormat("HH시mm분ss초");
		//날짜를 특정 형태로 포맷하는 유틸
		String str = sim.format(date);//날짜를 문자로 형변환
        int hour = Integer.parseInt(str.substring(0, 2));//문자열에서 
        int minute = Integer.parseInt(str.substring(3, 5));
/*      출석, 지각, 결석 여부 : 기본값은 결석, 날짜 출력 포멧의 일부분을 가져와 int 자료형으로 형변환 한 뒤
       	값을 비교하여 지각, 출석 여부를 판별한다. >> 이게 무슨 말일까...*/ 
		ArrayList<AttendanceManage> am = new ArrayList<AttendanceManage>();

        
 /*       if (hour >= 9 ) { 
            System.out.println("[출석체크 완료]");
            System.out.println("현재 시각 : "+str);
            System.out.println("지각입니다.");
 //           studentsInfo.get(num).checkStatus = "지각"; 
        } else {
            System.out.println("[출석체크 완료]");
            System.out.println("현재 시각 : "+str);
            System.out.println("정상 출석 입니다.");
  //          studentsInfo.get(num).checkStatus = "출석";
        }*/
        
    }

}
