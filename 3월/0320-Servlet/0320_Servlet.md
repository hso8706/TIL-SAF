### java servlet 사용
1. implements Servlet : Servlet 인터페이스 구현
2. extends GenericServlet : GenericServlet 추상클래스 상속(service 메서드만 필수 구현)
3. extends HttpServlet : HttpServlet 추상클래스 상속(하나 이상 골라서 메서드 구현), 웹에선 주로 이걸 사용

### client의 get과 post
- get 은 주소를 통해 데이터 전달
- post 는 body를 통해 데이터 전달
- 구분해야하는 이유
  - 숫자, 한글 등이 깨지는 경우가 발생하기 때문

### servlet을 사용한다는 의미
- 브라우저와 톰캣과의 연결 통로(stream)를 만드는 것

### JSP와 Servlet
- JSP : HTML안에 JAVA가 있다.
- Servlet : Java안에 HTML이 있다.

### Servlet Life-Cycle
1. Constructor
2. init() : WAS가 자동으로 최초 1회 실시
3. servcie(), doGet(), doPost() : 클라이언트 실행 시 매번 실행되는 영역
4. destroy() : 서버가 종료되는 시점에 자원 반납용으로 실행되는 영역

---------------------------------------
## 현장 강의
### Context-root
- url port 다음 부분에 들어가는 내용
- 하나의 애플리케이션은 하나의 context-root를 갖음. (하나의 실행 환경)

### Servlet
- 웹 컨테이너에서 실행되며, 동적인 콘텐츠를 생성하기 위한 자바 클래스
  - 웹 컨테이너 : Tomcat
  - 동적 : 실행될 때마다 DB 값을 기준으로 화면이 달라짐
- 쉽게 말하면 웹에서 실행되는 자바 프로그램
- open source
- servlet의 불편을 개선한 것이 `jsp`

### Servelt의 장점
- 자바의 장점과 유사
1. 플랫폼 독립성
2. 서버 독립성
3. 확장성
4. 개발 용이

### 서블릿 관련 패키지
- javax.servlet //x는 extension(확장)을 의미함
  - 일반 서비스를 위한 서블릿 패키지
- javax.servlet.http
  - http 서비스를 위한 패키지(웹 용)

### servlet을 사용하기 위한 조건
1. HttpServlet을 상속 받는다.
2. 서비스 메서드(클라이언트로부터 요청이 들어왔을 때 응답을 만들어 내는 메서드)를 구현한다. => doGet, doPost

### @, Annotation
- 웹 프로그램 실행 시 필요한 설정 정보, 환경 정보 등을 나타냄

### @WebServlet
- 해당 클래스가 Servlet 임을 보여줌

### 구성
- HttpServletRequest : client에서 들어오는 요청 정보가 담긴 객체
- HttpServletResponse : client로 나갈 응답 정보가 담긴 객체
- PrintWriter : 클라이언트로 보낼 컨텐츠 출력을 위한 출력용 스트림

### get과 post
- get: 주소로 직접 요청
- post: body로 요청(form 태그)

### url
- `http://localhost:8080/backentproject/`
  - http : protocol
  - localhost : sever
  - 8080 : port
  - backentproject : Context-root

### PrintWriter
- .println()
  - html 코드를 보내는 client에 보내는 용도
  - 모든 코드를 한 줄씩 일일이 적어서 보내야하기 떄문에 굉장히 불편
  - 때문에 개발된 것이 JSP

### HTTP 프로토콜; requset
- 요청줄
  - GET/books/search.jsp HTTP/1.1
    - GET : 요청 방식
    - books/search.jsp : 서버에 요청하는 자원
    - HTTP/1.1 : HTTP 버전
- header
- body

### HTTP 프로토콜; response
- 요청줄
  - HTTP/1.1 200 OK
    - HTTP/1.1 : HTTP 버전
    - 200 : 응답 코드
    - OK : 응답 명
- header
- body

### HTTP Request 처리 단계
1. Client가 요청을 전달하고, 전달한 요청을 가장 먼저 Container(Tomcat)가 받는다.
2. Container(Tomcat)가 요청 객체와 응답 객체로 만듬 => request는 정보가 다 있지만, response는 빈 객체인 상태
3. 2에서 만든 request 객체와 response 객체를 Servlet에 전달. 전달하는 과정에서 thread를 생성하여 사용(thread는 일꾼 개념)
4. service() 함수 실행, response 객체에 정보를 담음
5. doGet() 함수 실행, responset 객체를 Container(Tomcat)에 전달
6. Container(Tomcat)가 Client에 HTTP Response를 전달. 전달 후 필요 없어진 request 객체와 response 객체는 사라짐

### Servlet Life-Cycle
1. Constructor : 맨 처음 실행
2. init() : 서블릿 생성 후 맨 처음 한 번만 실행됨. 초기화 작업
3. servcie(), doGet(), doPost() : 클라이언트 실행 시 매번 실행되는 영역
4. destroy() : 서블릿이 메모리에서 사라지기 직전에 실행됨
- 위 사이클은 서버 관점의 실행이다. 즉, 어떤 클라이언트든 최초의 클라이언트 요청이 들어오면 1,2,3이 실행되고 이후부터는 어떤 클라이언트가 요청을 보내든 3번이 실행된다. 그리고 서버를 종료하면 그때 4번이 실행된다.