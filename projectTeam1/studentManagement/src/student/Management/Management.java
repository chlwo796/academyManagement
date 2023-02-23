package student.Management;
import java.util.List;
import java.util.Scanner;

public class Management {
	Scanner sc;

	Management() {
		sc = new Scanner(System.in);
	}
	
	//객체 생성 - 추가한 부분
	Data data = new Data();
	List<Lecture> lectureList = data.getLectureList();
	
	// 강의 검색
	void serch() {

		String find; // 강의 이름 받는 곳

		System.out.print("검색할 강의 과목을 입력하세요 : ");
		find = sc.next();

		for (int i = 0; i < lectureList.size(); i++) { // list 크기만큼 for문 실행
			// 강의 검색
			if (find.equals(lectureList.get(i).getLecture())) {
				System.out.println("강의 : " + lectureList.get(i).getLecture());
				System.out.println("선생님 : " + lectureList.get(i).getTeacherName());
			} else {
				System.out.println("과목을 다시 확인해주세요.");
			}break;
		}
	}
	
	// 전체 강의 목록
	void serchAll() {
		System.out.println("전체 강의 목록");
		System.out.println("----------------------------------");
		System.out.println("수업명   담당선생님   수강인원   수강료");
		System.out.println("----------------------------------");
		for (int i = 0; i < lectureList.size(); i++) {
			System.out.println(lectureList.get(i).getLecture() + " " + lectureList.get(i).getTeacherName());
		}
	}
}
