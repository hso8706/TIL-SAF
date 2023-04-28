# 23.04.28
### SOP, CORS 복습
- SOP
  - 다른 origin과의 통신은 불가
- CORS
  - SOP만 따르면 너무 제약이 많아서 특정 조건에서는 SOP를 위반하더라도 통신이 되게끔하는 규약
  - 해당 조건을 Header 부분에 명시함
  - `Access-Control-Allow-Origin: `

### Logger_Spring boot
- sout 대체
- `log4j` 라이브러리 이용
- application.properties 에 설정 등록
  - `logging.level.{패키지 경로} = trace`
  - 해당 경로가 실행될 때 로그를 남기는 코드
  - trace
    - 로그를 남기는 레벨 중 하나
    - 6가지 정도가 존재하며, trace는 가장 낮은 레벨이다. (때문에 잡다한 로그가 다 찍힐 예정)
  - log level
    - fatal > error > warn > info > debug > trace
    - 설정한 레벨 이상의 로그만 출력

### Logger_Legacy
- src/test/resources/log4j.xml
  - main 보다 우선 순위가 높음
  - test 용 logger
- src/main/resources/log4j.xml
  - appender 태그 : 로그의 출력 위치(방식)을 결정
    - appender 태그의 class 속성값으로 결정
    - 콘솔, 파일, DB
  - logger 태그 : 지정된 패키지가 실행될 때 로그 기록

### Swagger 
- API 문서를 자동으로 생성해주는 Library
- API 문서 : Client에 제공
- 작동 방법
  - Boot server controller에 명시된 어노테이션을 해석해서 API 문서를 자동으로 생성해줌
- boot 프로젝트의 com.SwaggerConfiguration.class 참고
- boot 프로젝트의 com.mvc.controller 참고

### 확인
- Swagger-UI 2.x 확인
  - http://localhost:8080/{your-app-root}/swagger-ui.html
- Swagger-UI 3.x 확인
  - http://localhost:8080/{your-app-root}/swagger-ui/index.html