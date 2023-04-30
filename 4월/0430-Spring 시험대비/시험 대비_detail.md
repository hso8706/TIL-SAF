# 23.04.28
```
<< Spring Framework  정리>>
1.DI 방식 
2.REST 특징, 관련 어노테이션
3.Spring MVC ARCHITECTURE 이해
* 요청 처리 흐름 중요!
4.ANNOTATION들 - 주관식 많음
5.SPRING BOOT 특징 및 구조, 설정 위치, 사용 파일
6.web.xml 
7.MyBatis 특징 및 핵심 클래스 
8.root-context/servlet context 구분
9.Spring FrameWork 개념 및 모듈
```

### Spring MVC : 동작 순서(서술 가능성)
- 주요 component
  - Client
    - server를 사용하는 주체
  - Dispatcher Servlet
    - server의 최전선에서 client의 요청과 응답 처리를 담당(front controller)
  - **HandlerMapping(언급)**
    - client의 요청(url)이 어떤 controller와 매핑되는지 확인해주는 주체
  - Controller + Service + Repository(mapper, dao) + Database
    - client의 요청에 따라 model을 만드는 로직
  - Model
    - client의 요청에 대응하여 만들어진 정보
  - ViewResolver
    - 어떻게 view를 구성할 지에 대한 정보를 만드는 요소
  - View
    - 화면(페이지) 혹은 화면에 뿌릴 데이터
- Spring MVC 흐름도
    1. Client => DispatcherServlet
      - 처리 요청(URL)
    2. DispatcherServlet(DS) => HandlerMapping
      - 요청 URL과 매핑되는 Controller 검색
      - 검색된 Controller 정보를 DS에 전달
    3. DispatcherServlet => Controller => Business Logic(Service + DB) => Controller
      - HandlerMapping이 검색한 Controller에 요청을 전달함
      - Business Logic을 통해 Model 생성
      - Model
        - DB에서 가져온 데이터
    4. Controller => DispatcherServlet
      - Model and View를 리턴한다
      - model : DB data
      - view : 화면
        - 논리적인 화면 (!= 물리적인 화면, 즉 파일이 아님)
        - 어떤 화면어 model을 뿌릴지에 대한 정보
    5. DispatcherServlet => ViewResolver => DispatcherServlet
      - ViewResolver가 논리적인 뷰 정보(view)를 기반으로 물리적인 뷰 정보를 결정한다.
      - servlet-context.xml에 bean으로 설정된 `InternalResourceViewResolver`이 어떤 물리적인 view를 사용하는지 지정함.
    6. DispatcherServlet => View => DispatcherServlet
      - 물리적인 뷰 정보를 통해 어떤 View, 즉 .jsp 파일을 정해서 응답 정보에 포함하여 DispatcherServlet에 전달
      - 응답으로 전달하는 데이터는 꼭 .jsp가 아닐 수 있음

### REST 서비스 : 동작 방식 개념(서술 가능성)
- 요청을 통해 `URI + Methods 정보`를 제공받음
  - HTTP URI : 제어할 자원(Resource)을 명시
  - HTTP Method : 해당 자원을 제어하는 명령(GET, POST, PUT, DELETE)
  - Resource : Client가 원하는 content
  - Method : GET, POST, PUT, DELETE
- 응답으로 `XML, JSON`을 제공함
  - 이로인해 client가 어떤 기기이든, 화면 크기가 어떻든 상관없어짐
  - 물리적인 view는 이제 client의 몫이됨.

### Annotation
- @Autowired
  - **type 기준으로 주입(강조)**
  - @Qualifier("{이름}")
    - type이 동일한 객체가 있을 경우 구분하기 위한 어노테이션
  - **package 기준으로 주입된다 (x, 틀린 예시 언급)**
  - field에 붙이는 어노테이션이다. (setter 이런 것도 되긴함)
- @Configuration
  - java 파일로 xml 설정 파일 대신 하겠다고 명시하는 어노테이션
  - @Bean 어노테이션을 붙인 메서드들을 포함하고 있음
- @Bean
  - @Configuration파일 내 메서드들에 붙는 어노테이션
  - xml 파일의 bean 태그를 대신함
- @RestController
  - Rest 서비스 어노테이션
  - @RestController = @Controller + @ResponseBody
  - @Controller : MVC에서 Controller 역할을 하는 클래스를 명시
  - @ResponseBody : Java 객체를 JSON으로 변환하여 응답 제공
- @RequestMapping
  - Controller의 handler method에 붙여줌
  - 인자로 매핑할 요청 url과 http method 명을 제공
  - Request 자리에 Get, Post, Put, Delete인 매핑 어노테이션도 존재
- @PathVariable
  - Controller의 handler method 매개변수에 붙여줌
  - uri 경로 중 변수를 받는 어노테이션
- @RequestBody
  - Controller의 handler method 매개변수에 붙여줌
  - 요청으로 제공받는 JSON을 Java 객체로 변환해줌
- @Controller, @Service, @Repository
  - Spring MVC 내에서 해당 클래스가 어떤 역할을 할 것인지 명시
  - 내부에 @Component를 포함하고 있음

### @RequestMapping
- client의 요청을 매핑.
- 경로가 중복되더라도 메소드가 다르면 상관없음
- 메소드에 붙이는 애너테이션
- 근데 클래스에도 붙일 수 있음
  - 중복되는 url 경로를 적어두기 가능
- **필드에만 못 붙인다고 기억하기(언급)**
- **@RequestMapping의 인자 값들의 형식을 잘 기억할 것(언급)**
  - `@RequestMapping(value = "/customers/{num}", method = RequestMethod.GET)`

### DI 방식
- 생성자 주입
  - `<constructor-arg>`
    - name 속성으로 생성자 인자 제공
    - index 속성으로 생성자 인자 제공
- Setter 주입
  - `<property>`
    - name 속성의 값이 set + {Value} 메소드를 호출하는 것이다.

### Interceptor
- Controller 가기 전 채가는 녀석
  - Filter는 D.S. 전에 가로챔
**- servlet-context.xml에 작성**
  - web 관련이기 때문
  **- filter는 web.xml에 작성**

### Spring Boot 특징
- Dependency 관리가 자동으로 됨.
  - version 체크도 자동
- Server(tomcat)가 내장되어있음.
- application.properties 파일
  - 프로젝트 설정 정보를 기록하는 파일
- 자동으로 관리해주기 때문에 개발 속도가 빨라짐
  - **성능(속도)과는 무관!(언급)**
- 애너테이션
  - @Service
  - @Repository
  - @Controller

### AOP 개념
- 핵심 개념
  - `공통 업무`와 `핵심 업무`로 구분
  - 핵심 업무(Core Concern)
    - 해당 기능을 구현하는 로직
  - 공통 업무(Cross-cutting Concern)
    - 핵심 업무를 도와주는 반복적이고 부가적인 일들
    - 핵심 업무 중간중간 끼어들어서 사용됨
- 용어 정리
  - joinpoint : 시점들을 의미
  - pointcut : joinpoint의 묶음
  - weaving : 핵심 업무 중간에 공통 업무가 끼어드는 것
  - advice : joinpoint에 weaving(삽입)되어 동작하는 코드(method)
  - aspect : advice를 갖는 클래스(집합체)
  - target : 핵심 로직을 구현하는 클래스

### WebApplication 동작 순서
- tomcat
- web.xml
  - root context(container), servlet context(container) 생성
    - root context : `ContextLoaderListener`가 생성 주체
    - servlet context : `Dispatcher Servlet`이 생성 주체

### Web.xml 구성
- Dispatcher Servlet 정보
- Filter 정보
- ContextLoaderListner 정보
- **Interceptor는 web.xml에 적지 않음(언급)**
  - **Interceptor는 servlet-context.xml에 작성**

### myBatis 설정 필수 요건 3가지
-  datasource 정보
-  VO 패키지 경로
-  mapper.xml 파일 경로
   -  classpath: => context라는 의미 => 패키지 구조내에선 resource를 의미

### SqlSessionFactory
- SqlSession
  - Connection
  - CRUD method를 가지고 있음
  - MyBatis의 핵심 클래스
- SqlSessionFactory
  - SqlSession를 호출하는 공장
  - interface
- SqlSessionFactoryBuilder(==SqlSessionFactoryBean)
  - SqlSessionFactory을 생성하는 클래스
  - SqlSessionFactory의 구현체
  - 실제 클래스 명은 SqlSessionFactoryBean.class 이다.
  - new 키워드 사용

### CPXAC; ClassPathXmlApplicationContext
- .getBean()
  - 여러 번 호출해도 하나의 객체 정보만 호출됨.
  - 싱글톤 패턴이기 때문
  - scope 속성 기본값이 싱글톤
- bean 태그 속성 scope
  - scope 속성을 prototype으로 하면 위의 문제를 해결할 수 있음

### Spring Framework Module
- Core
- Spring Mvc
- Context
- Spring Web
- Spring ORM
- JDBC
- AOP
- **EJB는 없다(언급)**

### SOP, CORS
- @CrossOrigin

### 응집도, 결합도
- 응집도
  - 높아야 좋음
  - 클래스를 구성하는 메소드, 필드 등의 연관성에 대한 용어
- 결합도
  - 낮아야 좋음
  - 클래스 간 의존 관계에 대한 용어
  - `DI 이용`, `interface 이용`으로 결합도를 낮출 수 있음

### root-context.xml 로 생성되는 객체
- service
- dao
- db pool
- web 흐름에 연관없는 친구들을 미리 만들어 놓는 곳
- **controller는 아님(언급)**
  - servlet-context.xml에 명시

### framework를 사용할 경우 결합도는?
- 낮아짐
  - DI를 쓰니까~

### component-scan
- package를 뒤져서 bean을 등록하는 태그
- 예시
  - `<context:component-scan base-package="com.mvc.controller"/>`