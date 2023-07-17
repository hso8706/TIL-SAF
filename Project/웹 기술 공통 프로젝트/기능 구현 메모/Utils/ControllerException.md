### ControllerException
- 애플리케이션에서 발생한 예외를 Client에 제공할 때, 좀 더 구체적이고 알기 쉽게 전달하는 예외 처리 작업

### 예외 발생 상황
- 애플리케이션 내부에서 발생한 예외
- Dto 유효성 검증에서 실패한 경우에 발생한 예외

### @ExceptionHandler
- 메소드 레벨에 작성하는 어노테이션
- ControllerException 처리를 위해서 사용하는 어노테이션
- Controller의 Handler method에 붙이는 것으로, 예외 처리를 위한 전용 Handler method를 작성

### ErrorResponse
- 좀 더 깔끔한 예외 정보 응답(response) 제공을 위한 객체
- Error에 대한 Response를 만들기 위해 연관된 모든 것을 묶어 놓은 클래스

### @RestControllerAdvice
- 클래스 레벨에 작성하는 어노테이션
- 각 컨트롤러에 Error를 핸들링하기 위한 @ExceptionHandler 메소드를 만드는 것을 방지하기 위해 사용하는 어노테이션(중복 코드 방지)
- 모든 컨트롤러에서 클라이언트로 전달하는 예외를 모두 받는 클래스를 만들 때 사용
- 세 가지의 어노테이션이 포함되어있음
  - @ExceptionHandler
  - @InitBinder
  - @ModelAttribute
  - 아래 두 개는 SSR 방식에 사용되는 어노테이션