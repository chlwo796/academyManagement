package student.Management;

import java.util.Comparator;

public class StudentComporator implements Comparator<Student> {	
	// TreeMap<Student, Score>으로 성적표를 생성했다, 중복객체구분하려고 만들었다.
	@Override
	public int compare(Student o1, Student o2) {
		return (o1.getClassName() + o1.getSubjectName() + o1.getStudentName()).compareTo((o2.getClassName() + o2.getSubjectName() + o2.getStudentName()));
	}
}