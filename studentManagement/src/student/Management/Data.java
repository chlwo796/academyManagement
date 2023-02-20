package student.Management;

import java.util.ArrayList;
import java.util.List;

public class Data {
	
	public List<Student> getStudentList() {
		//학생 리스트 생성
		List<Student> studentList = new ArrayList<Student>();
		
		//객체 추가
		studentList.add(new Student("홍길동", "010-1111-1111", "1반", "국어"));
		studentList.add(new Student("이순신", "010-2222-2222", "2반", "수학"));
		studentList.add(new Student("유관순", "010-3333-3333", "1반", "국어"));
		
		return studentList; //리스트의 주소를 리턴
 		
	}
	
	public List<Lecture> getLectureList() {
		// 강의 리스트 생성
		List<Lecture> lectureList = new ArrayList<Lecture>();

		// 객체 추가
		lectureList.add(new Lecture("국어", "김민수", 200000));
		lectureList.add(new Lecture("수학", "김지수", 300000));
		lectureList.add(new Lecture("영어", "최수민", 400000));

		return lectureList; // 리스트의 주소를 리턴

	}
}
