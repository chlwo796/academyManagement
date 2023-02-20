package student.Management;

public class Lecture {
	//강의 관련 필드설정 클래스
	
	private String lecture; //강의 이름
	private String teacherName; //선생님 이름
	private int tuition; //수업료

	public Lecture(String lecture, String teacherName, int tuition) {
		super();
		this.lecture = lecture;
		this.teacherName = teacherName;
		this.tuition = tuition;
	}

	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
}
