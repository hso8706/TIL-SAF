# 23.04.21

###
- 예외처리
- 인터셉터

## SpringMVCBoard
### BoardService
- 각 메서드에 throws Exception 추가
- Impl에도 추가
- dao, daoImpl도 추가
- throws Exception
  - 이전에 호출했던 클래스(객체)에 예외를 던짐
### 예외처리 방법
- 전역에서 처리하기
- Controller 내에서 처리하기
### BoardDao
- throws SQLException
- try-catch 삭제
### BoardController
- 메서드마다 throws Exception 붙이기
- 예외처리용 메서드 작성
- `@ExceptionHandler`
### ExceptionControllerAdvice
- `@ControllerAdvice`
- `@ExceptionHandler`
- 
## Interceptor
### Filter 설명
- 전처리기, 후처리기 라고도 함 (요청 및 응답, 2번 실행)
- FrontController 보다도 먼저 실행되는 부분
- custom filter 가능
### Interceptor
- Dispatcher Servlet 이후, Controller 이전에 실행되는 작업
- Controller 이후의 작업을 편하기 만들어주기 위함
- Controller에서 Dispatcher Servlet으로 이동하는 응답 과정에서도 실행됨(2번 실행)
### SessionInterceptor.java
- com.mvc.interceptor
- `@Component` => servlet-context.xml 수정
- implements HandlerInterceptor
  - HandlerInterceptor interface
    - default methods로 구성된 인터페이스
    - default methods는 구현을 원하면 구현하고, 아니면 안해도 되는게 특징
    - preHandle, postHandle, afterCompletion
        1. preHandler
        2. 요청 처리 
        3. postHandler
        4. View 렌더링
        5. afterCompletion
- interceptor의 실행 조건 작성 => servlet-context.xml 수정
  - `<interceptors>` 태그
  - 여거 개의 인터셉터 작성 가능

## Filter
### new - filter 생성
- class 생성 + web.xml 태그 자동 생성