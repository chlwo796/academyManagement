package student.Management;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
   ArrayList<LectureData> list;
   Scanner sc;

   Management() {
      list = new ArrayList();
      sc = new Scanner(System.in);
   }

// 강의 검색
   void serch() {

      String find; // 강의 이름 받는 곳

      System.out.print("검색할 강의 과목을 입력하세요 : ");
      find = sc.next();

      for (int i = 0; i < list.size(); i++) { // list 크기만큼 for문 실행

         // 강의 검색
         if (find.equals(list.get(i).getLecture())) {

            System.out.println("강의 : " + list.get(i).getLecture());
            System.out.println("선생님 : " + list.get(i).getTeacherName());
         } else {
            System.out.println("과목을 다시 확인해주세요.");
         }
         break;
      }
   }

// 전체 강의 목록
   void serchAll() {

      System.out.println("전체 강의 목록");
      System.out.println("----------------------------------");
      System.out.println("수업명   담당선생님   수강인원   수강료");
      System.out.println("----------------------------------");
      for (int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i).getLecture() + " " + list.get(i).getTeacherName());
      }
   }

}