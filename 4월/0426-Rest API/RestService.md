# 23.04.26
### RestService
- REpresentational Safe Transfer
- HTTP URI + HTTP Method
  - HTTP URI : 제어할 자원(Resource)을 명시
  - HTTP Method : 해당 자원을 제어하는 명령(GET, POST, PUT, DELETE)
  - Resource : Client가 원하는 content

### CRUD Operation
- Post : Create(insert)
- GET : Read(Select)
- PUT : Update or Create
- DELETE : Delete
- //기존에는 2가지만 사용

### RESTful 서비스
- REst 방식을 잘 따르는 서비스

### 흐름도
- Client(PC, phone, ...)
  - 다양한 클라이언트(다양한 화면 크기, 다양한 기기)
- HTTP request(XML,JSON)
  - view를 다양한 클라이언트에 일일이 맞추지 않고, 데이터만 제공하는 방법(XML, JSON)
  - view는 화면을 제공받은 클라이언트에서 신경쓴다.
- Web Server
- Database
- //기존에는 view를 생성하여 주었지만, rest 서비스는 데이터만 준다.

### JSON의 종류
- 중괄호 JSON
- 대괄호 JSON(배열)

### Restful service를 위한 annotation
- `@RequestBody`
  - JSON => Java 객체
- `@ResponseBody`
  - Java 객체 => JSON
- `@RestController`
  - `@Controller` + `@ResponseBody`
  - 자바 객체를 응답의 Body에 바로 넣어 보냄
  - spring 4부터 지원