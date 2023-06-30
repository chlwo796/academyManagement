# AcademyManagement

### 1. 주제 : 학원 관리 프로그램

- 학생의 성적, 출결상태 등 개인정보를 관리하며 원내의 강의, 교사, 수업료 등의 자료를 통해 전반적인 학원 운영을 편리하고 간편하게 도와주는 프로그램
- 일정
  1. 주제발표 2/13
  2. 프로젝트 발표 2/24

### 2. 요구사항

1. 관리자 로그인 (2023.2.24 수정)
2. 관리자, 학생 로그인
3. 출결프로그램(확장필요)
4. 학생관리(검색, 등록, 수정, 삭제 )
5. 강의관리(강의검색, 강의조회, 강의교사조회)
6. 성적관리(성적검색, 전체성적, 반별성적)
7. 출결관리(출결검색, 출석현황, 반별출석)

### 3. 화면 설계

```
---

ㅇㅇ학원 관리 프로그램

---

코드입력

관리자>0

학생> 1

1

학생입니다.

핸드폰번호를 입력하여주세요.>000-0000-0000

000 학생, 출석하시겠습니까?(y/n)y

출석체크 완료

현재 시각 : 00시00분00초

지각or출석완료

n

종료

0

---

ㅇㅇ학원 관리 프로그램

---

아이디 > 김원장

비밀번호 > 123456

---

1. 학생관리 2. 강의관리 3. 성적관리 4. 출결관리 5. 종료

---

메뉴선택 > 1

학생 관리 메뉴를 선택했습니다.

---

1. 학생 검색 2. 학생 등록 3. 학생 정보수정 4. 학생 삭제 5. 이전화면으로

---

메뉴선택 > 1

학생 이름을 입력해주세요 > 홍길동

이름: 홍길동

전화번호: 010-1111-2222

수강과목: 수학

반: 1반

계속 검색하시겠습니까? (y/n) > n

---

메뉴 선택 > 2

등록할 학생의 이름 > 이순신

전화 번호 등록 > 010-3333-4444

수강과목 : 국어

반: 2반

계속 등록하시겠습니까? (y/n) > n

---

메뉴 선택 > 3

학생 이름 입력 > 홍길동

전화번호 수정 > 010-1111-1111

정보가 수정되었습니다.

계속 수정하시겠습니까? (y/n) > n

---

메뉴 선택 > 4

삭제할 학생을 입력 > 이순신

정말 삭제하시겠습니까? (y/n) > y

이순신 학생의 정보가 삭제되었습니다.

---

메뉴 선택 > 5

이전 화면으로 돌아갑니다.

---

1. 학생관리 2. 강의관리 3. 성적관리 4. 출결관리 5. 종료

---

메뉴 선택 > 2

강의 관리 메뉴를 선택했습니다.

---

1. 강의 검색 2. 전체 강의 목록 3. 선생님 검색 4. 이전화면으로

---

메뉴 선택 > 1

강의 이름 입력 > 국어

강의: 국어

담당 선생님: 김민수

수강 학생 수 : n명

강의 수업료 : 50만원

계속 검색하시겠습니까? (y/n) > n

---

메뉴 선택 > 2

전체 강의 목록

---

수업명 담당선생님 수강인원 수강료

---

국어 김민수 n명 50만원

수학 김혜수 n명 60만원

....

---

---

메뉴 선택 > 3

선생님 이름 입력 > 김민수

담당 과목 : 국어

수강 학생 수: n명

담당 학생 : 이순신

계속 검색하시겠습니까? (y/n) > n

---

메뉴선택 > 4

이전 화면으로 돌아갑니다.

---

1. 학생관리 2. 강의관리 3. 성적관리 4. 출결관리 5. 종료

---

메뉴 선택> 3

성적 관리 메뉴를 선택했습니다.
---

1. 성적 검색 2. 전체 성적 3. 반별 성적 4. 이전화면으로

---

메뉴 선택 > 1

학생 이름 입력 > 홍길동

홍길동 학생의 성적

수학: 90점

국어: 60점

계속 검색하시겠습니까? (y/n) > n

---

메뉴 선택 > 2

ㅇㅇ학원 전체 성적

---

수업명 학생이름 담당선생님 성적

---

국어 홍길동 김민수 60점

수학 홍길동 김혜수 90점

국어 이순신 김민수 100점

....

---

상담 필요 학생 : 홍길동

---

메뉴 선택 > 3

1반의 평균 : 0.00, 표준편차 : 0.00

2반의 평균 : 0.00, 표준편차 : 0.00

...

---

메뉴 선택 > 4

이전 화면으로 돌아갑니다.

---

1. 학생관리 2. 강의관리 3. 성적관리 4. 출결관리 5. 종료

---

메뉴 선택 > 4

출결 관리 메뉴를 선택했습니다.

---

1. 출결 검색 2. 출석 현황 4. 반별 출석 5. 이전화면으로

---

메뉴 선택 > 1

학생 이름 입력 > 홍길동

출석 상태 : 출석or결석

계속 검색하시겠습니까? (y/n) > n

---

메뉴 선택 > 2

ㅇㅇ학원 출석 미달자

---

수업명 학생이름 담당선생님 출석상태

---

국어 홍길동 김민수 출석

국어 이순신 김민수 결석

....

---

상담 필요 학생 : 이순신

---

메뉴 선택 > 3

---

반 담당선생님 인원수 출석률

---

1반 0명 70%

2반 0명 80%

....

---

---

메뉴 선택 > 4

이전 화면으로 돌아갑니다.

---

1. 학생관리 2. 강의관리 3. 성적관리 4. 출결관리 5. 종료

---

메뉴 선택 > 5

프로그램 종료!
```

### 4. 업무분장

0. 메인 : 같이
1. 학생관리 : 박정은
2. 강의관리 : 권영우
3. 성적관리 : 최재환
4. 출결관리 : 오성철(출결프로그램)

### 5. 사용 언어 및 도구

![Java11](https://img.shields.io/badge/Java11-blue?style=flat&logo=&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-blueviolet?style=flat&logo=Eclipse&logoColor=white)

### 6. 느낀점

- 지난 배열로 만든 자바프로젝트에 비해, 컬렉션의을 사용하여 데이터관리는 비교적 쉬웠으나 프로그램의 규모가 커지다 보니, 객체지향적 관점에서 프로그램을 바라보아야만 했다. 이 프로젝트를 통해 객체지향프로그래밍이 무엇(특히 모듈화)인지 조금이나마 느꼈고, 설계단계에서 상당히 많은 부분을 미리 정해놓고 시작해야 코딩작업 시 각 다른 역할(클래스)의 팀원들과의 작업이 수월하다는 것을 많이 느꼈다.
- 이클립스 환경세팅에 인코딩 개념을 프로젝트 이후 추후에 알게 되었다.(기본 ENC-KR이 아닌 UTF-8로 인코딩을 하는 이유)
  - EUC-KR : 완성형 방식, 완성된 문자가 없을 경우 글자가 깨져보일 수 있다.
  - UTF-8 : 조합형 방식, 모음과 자음으로 나누어져 조합을 통해 글자가 완성되어 표현된다.

