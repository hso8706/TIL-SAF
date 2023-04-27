# 23.04.27
### Spring Boot의 특징
- library, dependency 등 여러 구성 및 설정 파일을 자동으로 처리해준 것. 즉, 환경 설정을 자동으로 처리해주는 framework이다.
- 기존에는 충돌을 방지하기 위해 dependency 버전도 고려해야했는데, spring boot는 버전도 알아서 맞춰준다.
- 내장 서버가 존재해서 편함
- jar 파일로도 web 어플리케이션 개발을 할 수 있다.
  - .war : web 어플리케이션 압축파일
  - .jar : main 함수를 갖는 로컬 어플리케이션 압축파일
- 기본적으로 jsp를 지원하지 않음
  - 화면 구성에 대한 지원이 적음
  - rest api를 기본으로 함.

### MSA; Micro Service Architecture
- 하나의 애플리케이션 내부의 여러 서비스가 존재할 때, 서비스마다 프로그램으로 만들어서 구성하는 것.
- 하나의 서비스가 문제가 생기거나 업데이트가 필요한 경우, 다른 서비스에 영향을 끼치지 않으면서 전체 애플리케이션을 사용할 수 있음
- Spring boot가 애플리케이션 생산성을 높여줘서 MSA에 많이 사용됨

## Spring boot 구성
### src/main/java
- main함수가 포함된 .java 파일
  - main() 
    - local 어플리케이션을 만들때만 필요하지만, spring boot 특성상 main 사용 가능
  - `@SpringBootApplication`
    - 해당 어노테이션이 붙은 클래스를 메인 클래스, 부트스트랩 클래스, 시작 클래스 라고 부름
    - 실행시키면 서버(내장된 톰캣)가 시작됨. 즉, 따로 서버를 돌릴 필요가 없는 버튼과 같은 존재
- `@SpringBootApplication`
  - `@SpringBootConfiguration`
    - xml 문서를 대신해서 설정 정보를 가지고 있음을 표시하는 애너테이션
    - `@Cofiguration`
      - xml 파일 대신 설정 정보를 담는 java 파일임을 알려주는 애너테이션
      - 내부 메서드에는 `@Bean`애너테이션으로 bean 태그를 대신한다.
  - `@ComponentScan`
    - 현재 패키지를 기준으로 하위 패키지를 스캔해서 객체를 생성해 줌.
    - 현재 패기지 == 해당 애너테이션이 붙은 클래스가 포함된 패키지
  - `@EnableAutoConfiguration`
    - boot의 자동 설정 작업을 활성화시키는 애너테이션.
    - 사용자가 필요로 할 것 같은 빈을 생성하고 설정하는 작업을 함
  - Spring Boot에서 빈을 등록하는 단계
        1. @ComponentScan : 사용자가 지정한 빈을 생성(현재 패키지에서 하위 패키지로)
        2. @EnableAutoConfiguration : boot의 추가적인 빈 생성이 이루어짐
- SpringApplication.run()
  - boot application을 시작하는 메서드
    - SpringBootFirstApplication.class를 메모리에 로딩함
### src/main/resources
- 이 위치를 `classpath` 라고함
- static
- templates
- application properties

### LiveReload 설치

### dependency  설치
- Spring boot 는 기본적으로 jsp를 지원하지 않기 때문에 따로 설치

## SpringBootMVCCustomer
### dependency
- Mybatis, MYSQL


## 프론트 서버와 백엔드 서버
### 2 Server
- SpringMVCRestCustomer
  - Backend
- SpringBootMVCCustomer
  - Client
### SOP
- Same Origin Policy
- origin : 일반적으로 우리가 부르는 `server`를 의미함
  - origin == scheme + host + port
    - `http://localhost:8080/`
      - scheme : `http://`
      - host : `localhost:`
      - port : `8080/`
- 같은 origin이면 허용하는 정책
### CORS
- Cross Origin Resource Sharing
- origin이 달라도 필요한 resource가 있으면 공유할 수 있도록 허용하는 정책
  - SOP 정책은 너무 제약이 강해서 일정 부분은 허용할 수 있도록 만든 정책
  - 하지만 기본은 SOP 정책을 따른다.
- origin의 동일 유무는 browser가 판단함. 
  - 값은 서로 전달 및 생성은 되지만 browser가 로딩을 거부함
- origin이 다르더라도 허용할 수 있는 방법
  - 1. 응답 헤더 정보 이용
    - 응답 헤더에 origin이 다르더라도 허용할 수 있다는 정보를 묶어서 보냄
    - `@CrossOrigin`애너테이션 사용
- 응답 헤더 확인하기
  - 개발자 도구 - 네트워크 - `access-control-allow-origin: *`(모두 허용)