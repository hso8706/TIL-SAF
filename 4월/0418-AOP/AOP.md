# 23.04.18

## remind

### IoC
- framework이 필요한 요소를 제공함(개발자가 만들지 않음)
- Spring에 한정해서 IoC == DI 라고 생각해도 큰 문제는 안된다.


### DI
- 생성자 DI
- setter DI


### DL; Dependency Lookup


### DI 구현
- xml
- xml + annotation
- java 설정 file : xml이 하던 일을 자바에게 시킴
  - @Configuration


### Annotation
- Autowired
  - 타입 기준으로 동일한 객체를 자동을 주입시킴
  - 타입이 같은 객체가 존재한다면 @Qualifier을 이용(혹은 name 속성으로 별칭달아서 이용, 원칙은 @Qualifier)
  - 존재 유무는 XML 파일에 명시
- Component
  - 설정한 패키지를 순회하여 @Component가 달린 클래스를 자동으로 객체로 만들어 준다.
  - 해당 애너테이션을 활성화 시키기 위해 XML에 따로 작성할 코드가 필요하다
  - Namespaces, context
  - component-scan, base-package

## AOP


### Aspect-oriented Programming
- 관점 지향 프로그래밍
- 객체 지향 프로그래밍과 같이 프로그래밍 방식 중 하나
- `핵심 업무`와 `공통 업무`로 관점을 구분한다.
- Asect 지향의 중요 개념 : 핵심 업무에서 공통 업무를 분리 시키는 것
- 예시. 은행 업무 처리 시스템
  - 핵심 기능: 계좌 이체, 대출 승인, 이자 계산, ...
  - 공통 기능(부가 기능): 로깅, 보안, 트랜젝션, ... 


### 핵심 업무(Core Concern)
- biz logic


### 공통 업무(Cross-cutting Concern)
- 핵심 업무를 도와주는 반복적이고 부가적인 일
- 핵심 업무 중간 중간 끼어들어서 하게 될 작업


### OOP와의 차이
- OOP라면 핵심 업무 클래스에 공통 업무 작업을 호출하는 코드가 존재할 것임.
- 이런 혼합 코드를 완전히 분리한 것이 AOP이다.
- 완전한 분리를 위해서 사용하는 것이 `AOP 프레임워크`이고, `AOP 프레임워크`가 위빙을 하여 공통 업무를 실행한다.
- 위빙(Weaving)
  - 핵심 업무 중간에 공통 업무가 끼어드는 것
  - 호출과는 다르다.
  - 위빙은 동적인 작업


### AOP 용어
- Joinpoint
  - `~~할 때`를 의미하는 용어
  - 애플리케이션을 실행할 때 특정 작업이 시작되는 시점
  - 예
    - 클래스의 인스턴스 생성 시점
    - 메서드 호출 시점
    - 예외 발생 시점
- Advice
  - Joinpoint에 삽입(weaving)되어져 동작할 수 있는 코드
  - advice는 메서드로 구현된다.
- Pointcut
  - 여러 개의 Joinpoint를 하나로 묶은 것
- Weaving
  - Advice를 핵심 로직 코드에 삽입하는 것
- Target
  - 핵심 로직을 구현하는 클래스
  - Client가 호출할 메소드를 가지고 있음
- Aspect
  - 여러 객체에 공통으로 적용되는 공통 관점 사항
  - 공통 로직을 구현하는 클래스
  - Advice를 갖고 있는 클래스


### AOP 예시
- 게시판
  - Pointcut1 : 글쓰기, 글 수정, 글 삭제 ==> when
  - Advice1 : 로그인 여부 확인 ==> what
  - Aspect : Pointcut1 + Advice1 ==> wher + what : 언제 뭐하니~?


### Spring AOP
- Spring Framework가 제공하는 Framework
- Proxy 기반의 AOP
  - Target 객체에 대한 proxy를 만들어 제공함
- Proxy
  - 클래스
  - Target을 감싸는 구조로 runtime에 생성(실행 시 생성)
  - Advice를 Target 객체에 적용
  - Client(main 메소드를 갖는 객체)가 Target을 호출할 때 생성
  - Proxy는 Client가 Target을 호출할 때 weaving의 필요 여부를 파악하고 필요 시 weaving을 실행시킴
  - 즉, Proxy는 Aspect의 정보를 갖고 있어야함.
  - Proxy는 대리인(대리 클래스)이라고 생각하면 좋다
  - Proxy는 타겟이 되는 클래스, 혹은 상위 인터페이스를 상속받거나 implements를 해서 같은 메서드를 공유한다.
- Proxy 단점
  - 메모리 낭비
  - 속도 저하
- Proxy 단점 극복
  - AOP 전용 프레임워크는 proxy를 안 씀
  - 애초에 Target 클래스에 Aspect 코드가 끼어들어간 형태의 .class가 만들어진다
  - 속도가 proxy보다 빠르다
  - 위 작업은 compile 시점, loading 시점에서 작업이 실행된다
  - proxy는 runtime 시점에 작업함.
  - proxy를 사용하는 이유는 다른 방법보다 성능이 좋진 않지만 가볍기 때문이다. Spring 에서는 가벼워야하므로


### Advice Type
- Before : Target의 핵심 메소드 실행 전
- After : Target의 핵심 메소드 실행 후
- AfterReturning : Target의 핵심 메소드 실행하고 값을 리턴한 후 실행
- Around : Target의 핵심 메소드 실행 전/후로, 총 두 번 실행
- AfterThrowing : Target의 핵심 메소드 실행 중 예외 발생 시


### Pointcut 표현식
![image](https://github.com/hso8706/TIL-SAF/assets/103169947/7c251831-1e5f-4efb-8409-89666b81eb9e)
- Pointcut의 표기 방법
- `designator`, `return type`, `method name`, `params` 는 필수 작성 요소
- `*` : any의 의미(메소드명에도 붙을 수 있음), 혹은 single 파라미터라는 의미
- `..` : parameter 위치에 작성하는 표기법. 와도되고 안와도 되고


### AOP Framework 종류
- AspectJ : full-blown, 모든 aspect 관련 기능을 갖고 있는 framwork
- Spring AOP : 메소드 호출할 때만 사용 가능


### Spring AOP 구현 방식
1. XML 활용
2. Annotation 활용

## Java 설정 file을 이용한 DI
### 1. Annotation pjt
- com.coffee.config.CoffeeConfig : xml 설정 파일을 대신할 Spring 설정 파일(.java)
  - `@Configuration`
    - 클래스 단위 애너테이션
    - 해당 파일(.java)이 spring 설정 파일임을 명시
  - `@Bean`
    - `<Bean>`태그를 대신함
    - 메서드 단위 애너테이션
    - 메서드명 == id명
## Annotation을 활용한 Spring AOP 구현
### dependecy
- 여러 dependecy를 사용할 때 충돌나는 경우는 버전을 맞춰줘야한다.
    ```
    <!-- Library for AOP -->
		<dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>3.0.7.RELEASE</version>
        </dependency>

      <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjrt -->
	    <dependency>
	        <groupId>org.aspectj</groupId>
	        <artifactId>aspectjrt</artifactId><!-- rt: runtime; proxy -->
	        <version>1.7.3</version>
	    </dependency>
	
	    <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
	    <dependency>
	        <groupId>org.aspectj</groupId>
	        <artifactId>aspectjweaver</artifactId><!-- weaver: weaving -->
	        <version>1.6.7</version>
	    </dependency>
    ```
### Car.interface
- 하위 클래스(Avante)와 결합도를 낮추기 위함
### Avante
- Target 클래스
- Client가 실제로 이용하려는 기능
- Car.interface를 구현함
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