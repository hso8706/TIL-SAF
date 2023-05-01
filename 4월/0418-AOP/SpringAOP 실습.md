# 23.04.18
## SpringAOP
### Car.interface
- 하위 클래스(Avante)와 결합도를 낮추기 위함
### Avante
- Target 클래스
- Client가 실제로 이용하려는 기능
- Car.interface를 구현함
### CarApp
- Application 시작 지점
### ColorTracker
- Aspect 클래스
  - Aspect 객체: Advice(what) + Pointcut(when). 공통 업무를 포함하는 객체.
- @Aspect
  - 클래스 단위 애너테이션
  - Aspect 객체임을 명시하는 애너테이션
  - 해당 애너테이션을 통해 Proxy에게 정보를 제공
- Advice
  - 메서드 단위 애너테이션
  - Aspect 클래스 내에 존재하는 methods
  - 메서드명은 상관없음
  - @Before, @After, @AfterReturning, @Around, @AfterThrowing을 붙여서 advice임을 명시(동시에 advice 타입 지정)
### aop.xml
- Container가 생성할 객체 설정
- Target 객체, Aspect 객체 생성 설정
- Proxy 자동 생성을 위한 태그 설정
  - `<aop:aspectj-autoproxy></aop:aspectj-autoproxy>`
    - Namespaces - aop
  - `<aop:include name=""/>`
    - aspect 객체 정보 제공을 위한 태그
    - 위 자동 생성 태그 내부에 추가
    - aspect가 여러 개면 include를 여러개 추가하면 된다.