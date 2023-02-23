package student.Management;

public class Student {
	
	public String studentName; // 학생 이름
	public String phoneNum; // 전화번호
	public String className; // 반
	public String subjectName; // 과목명

	
	
	public Student(String studentName, String phoneNum, String className, String subjectName) {
		// super();
		this.studentName = studentName;
		this.phoneNum = phoneNum;
		this.className = className;
		this.subjectName = subjectName;
	}

	
	
	// 게터세터
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
