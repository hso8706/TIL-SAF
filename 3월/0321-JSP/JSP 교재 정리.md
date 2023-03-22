# 23.03.21

## Index
1. JSP (Java Server Page)
2. JSP Scriptlet
3. JSP Directive
4. JSP 기본 객체

## JSP (Java Server Page)
### JSP과 Servlet의 차이
- Servlet : 근본적으로 .java 파일임. java 파일(프로그램) 내에 HTML이 있는 것.
- JSP : Servlet과 반대로 HTML에 java 코드를 삽입한 것.
### JSP란
- HTML내에 JAVA 코드를 삽입하여 웹 서버에서 동적으로 웹 페이지를 생성하고 웹 브라우저에서 돌려주는 언어
- 자바 서버 페이지 실행시에는 자바 서블릿으로 변환된 후 실행됨.
### 스크립트 기반 코드와 컴파일 기반 코드
- 스크립트 기반
  - 위에서부터 절차(순차)적으로 실행
  - 느리지만 코딩이 쉬움
- complie 기반
  - 컴퓨터가 코드를 미리 해석하고 실행
  - 빠르지만 코딩이 복잡함
### JSP 특징
- code는 스크립트 기반으로 작성하지만 실행은 compile 기반이다.
- 이렇게 되는 이유는 .jsp를 실행하면 servlet(.java)으로 바뀌고, complie되어 .class 파일이 되기 때문
- Servlet과 JSP는 기본적으로 같은 문법을 사용한다.
### JSP 동작 흐름
1. Client request 전달
2. WAS가 request get  
   1. 최초 JSP 요청 시 jsp가 servlet(.java)으로 변경 됨.
   2. 변환된 servlet class를 compile 하고, 이를 메모리에 적재
3. data를 받아 service logic 처리하고, response page 생성
4. Client로 response 전달

## JSP Scriptlet
### JSP Scripting Element
- **선언, Declaration**
  - 멤버 변수 선언이나 메소드를 선언하는 영역
  - 형식 : `<%! 멤버 변수와 메소드 작성 %>
- **스크립트릿, Scriptlet**
  - Client 요청이 들어올 때마다 호출되는 영역
  - Servlet 변환 시 service 처리에 해당하는 영역
  - request, response 를 다루는 영역
  - 형식 : `<% java code %>`
- **표현식, Expression**
  - 데이터를 브라우저에 출력할 때 사용
  - Servlet에서 out.print를 사용하던 부분과 같다. 실제로 표현식 형식 내부에 `문자열`을 쓰는 것과 `out.print(문자열);`을 쓰는 것과 같은 표현이다.
  - 형식 : `<%= 문자열 %>`
- **주석, Comment**
  - 코드 상에서 부가 설명 작성
  - 형식 : `<%-- 주석 내용 --%>

## JSP 지시자; JSP Directive
### JSP 지시자란
- JSP 페이지가 실행될 때, JSP 페이지를 어떻게 처리할 것인지 등과 같은 정보를 JSP 컨테이너에 전달하는 역할을 갖는 태그
- 종류로는 `page directive`, `include directive`, `taglib directive`가 있음
- 공통된 태그 형식 : `<%@ (지시자 종류) (속성=속성값)%>`
### page Directive
- `<%@ page (속성=속성값) ... %>`
- 컨테이너에게 현재 JSP 페이지를 어덯게 처리할 것인지에 대한 정보 제공
- 속성과 속성값을 한 묶음으로 작성하고, 다중 속성은 공백으로 구분한다
- 주요 속성
  - contentType : 브라우저로 내보내는 내용의 MIME 형식 지정 및 문자 집합 지정
    - (기본값) text/html;charset=ISO-8859-1
  - import : 현재 JSP 페이지에서 사용할 Java 패키지나 클래스를 지정
### include Directive
- `<%@ include file="(파일 경로)/(jsp파일명).jsp" %>`
- 특정 jsp file을 페이지에 포함한다. import의 개념
- 반복적으로 사용되는 부분을 따로 만들어두어 사용하는 방식(반복 코드 줄임)
### taglib Directive
- `<%@ taglib prefix="(커스텀 태그명)" url="(커스텀 태그 url 경로)" %>`
- 태그 라이브러리에 존재하는 커스텀 태그를 호출할 때 사용하는 지시자.

## JSP 기본객체
### 범위 (오름차순)
1. pageContext : 현재 페이지
2. request : 요청
3. session : 세션
4. application : 프로그램 전체
- 자세한 건 검색 및 표 참고

## MVC
### MVC Design Pattern
- 기능별로 쪼개는 패턴, 분업
- MVC
  - Model : 비즈니스 로직, 데이터 담당
  - View : 출력값(GUI, Design, Presentation) 담당
  - Controller : View-Model 사이의 상호동작 관리 담당

### MVC Design Pattern 목적
- 비즈니스 로직과 디자인의 분리
- 비즈니스 로직의 재사용: 디자인의 변경에 영향을 받지 않음
- 서블릿/.jsp 에서 비즈니스 로직 분리가 필요(유지보수, 확장)

### MVC Design Pattern 구조
![MVCPattern](https://user-images.githubusercontent.com/103169947/226819073-71a4d739-fa85-40c4-bcd3-7db51df11a87.PNG)
![MVCPattern2](https://user-images.githubusercontent.com/103169947/226819565-44231c4a-5245-480b-a61f-81b49015bb5d.PNG)

### 두 개의 Controller 사용 예정
- MVC pattern 흐름
  - Front Controller(Servlet)
    - Client(web)의 요청 수집, request가 가장 먼저 도달하는 지점
    - request 분류 : 해당 request가 무엇을 요구하는지 파악
    - Controller에 전달(== Controller 메소드 호출)
  - Controller(JAVA)
    - Service에 전달(== Servcie 메소드 호출)
    - 처리가 끝난 작업물을 View에 전달
  - Service(JAVA)
    - 실제로 일하는 부분, 하지만 DB관련 작업은 DAO가 함(DAO에 전달)
    - 끝난 작업은 다시 Controller에게 전달
  - DAO(JAVA)
    - DB관련된 작업을 처리하는 부분
  - VO()
  - DB
  - View(JSP)
    - Controller에 전달받은 작업물을 바탕으로 view 화면을 구성한다.
- 내부에선 forward 방식으로 정보 전달
- 싱글톤 패턴 사용