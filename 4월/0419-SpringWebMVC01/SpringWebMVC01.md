# 23.04.19
## Spring MVC

### Spring MVC
- Spring Framework이 제공해주는 Framework 중 하나
- 프론트 컨트롤러 역할을 하는 `DispatcherServlet`을 제공함

### 기존 web 작업 과정
- 요청 진행
  - Client -> Front Controller -> Controller -> Service -> DAO -> DB
    - Front Controller : Client 요청을 구분
    - DAO : DB 관련 부분 처리 담당 => 이후에 myBatis라는 프레임워크 사용 예정
- 응답 진행
  - DB -> DAO -> Service -> Controller -> View -> Client

### Spring MVC 흐름도
- 1. Client => DispatcherServlet
  - 처리 요청(URL)
- 2. DispatcherServlet => HandlerMapping
  - 요청 URL과 매핑되는 Controller 검색
- 3. DispatcherServlet => Controller => Model => Controller
  - HandlerMapping이 검색한 Controller에 요청을 전달함
  - Model
    - DB에서 가져온 데이터
- 4. Controller => DispatcherServlet
  - Model and View를 리턴한다
  - model : DB data
  - view : 화면
    - 논리적인 화면 ( != 물리적인 화면, 즉 파일이 아님)
    - 어떤 화면어 model을 뿌릴지에 대한 정보
- 5. DispatcherServlet => ViewResolver => DispatcherServlet
  - ViewResolver가 논리적인 뷰 정보(view)를 기반으로 물리적인 뷰 정보를 결정한다.
- 6. DispatcherServlet => View => DispatcherServlet
  - 물리적인 뷰 정보를 통해 어떤 View, 즉 .jsp 파일을 정해서 응답 정보에 포함하여 DispatcherServlet에 전달
  - 응답으로 전달하는 데이터는 꼭 .jsp가 아닐 수 있음

### Spring MVC 구성 요소
- DispatcherServlet : Client의 요청을 받고, 응답을 전달한다.
- HandlerMapping : 요청 URL에 적합한 Controller를 결정한다.
- Controller : 요청을 처리하여 결과를 DispatcherServlet에 전달
- ViewResolver : Controller가 처리한 결과를 보여줄 View 결정
- View : Controller의 처리 결과에 대한 화면 생성