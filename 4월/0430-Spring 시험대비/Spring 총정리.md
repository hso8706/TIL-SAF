# Spring

## Spring Framework

### Spring framework란?
- Enterprise application에서 필요로 하는 기능을 제공하는 프레임워크
- Enterprise application
  - web이라고 봐도 무방하다.
  - 원격의 환경에서 네트워크로 활용하는 어플리케이션
- JEE(Java Enterprise Edition)가 제공하는 다수의 기능을 포함한 추가 기능(DI, AOP)을 지원하는 경량화 프레임워크

### Spring framework의 목표
- java enterprise applicaion의 기반(infro) 제공하여, 잡다한 설정과 부가적인 것을 제외한 domain problem(핵심 문제)에 집중하여 개발할 수 있게 하는 것

### Spring framework 구성 요소
- Spring Framework는 여러 framework를 포함하고 있음
- Spring Core : Spring을 운용할 때 필요한 핵심 기능들
  - IoC(혹은 DI) 기능을 지원하는 영역
  - Bean Container
- Spring Context : Spring Core에 추가 버젼
- Spring AOP
- Spring DAO : DB관련
- Spring ORM : DB관련
- Spring Web : Web관련
- Spring Web MVC : Web관련
- 참고 이미지 1.
![spring 구조](https://user-images.githubusercontent.com/103169947/235348301-7f02b9c1-391b-4745-9d3c-707d27c65141.png)
- 참고 이미지 2.
![spring 구조2](https://user-images.githubusercontent.com/103169947/235348496-859d2153-ab4d-4e40-b3b6-496cfe9f50d0.png)

### Spring framework의 특징
- 경량컨테이너
- DI 패턴 지원
- AOP 지원
- POJO 지원
- IoC 제공
- 트랜잭션 처리를 위한 일관된 방법 제공
- 영속성 관련 API 지원
- 다양한 API를 연동할 수 있는 기능 지원

### 경량컨테이너
- 스프링에서 자바 객체를 담고, 자바 객체들의 라이프사이클을 관리하는 컨테이너를 의미한다.
- 스프링 컨테이너라고 한다. 
### IoC; Inversion of Control
- 제어의 반전, Spring의 핵심 기능
- 자바 객체 생성 및 의존관계 설정에 대한 제어권을 개발자가 아닌 프레임워크에게 넘기는 것을 의미
- Spring Framework에서는 Spring Container가 자바 객체 생성 및 의존관계 설정에 대한 제어권을 갖고 있음.
- DI는 IoC를 구현하는 하나의 방법. (spring framework의 개념에 한쟁해서는 IoC == DI라고 봐도 무방)
  - 설정 파일(xml, configuration)을 통해 application 실행 시 자동으로 bean 객체를 만들어놓고 이를 개발자가 가져다 쓰는(공급받는) 방식
### DI; Dependency Injection
- 의존성 주입
- 유연하게 확장 가능한 객체를 만들고 이를 의존관계로 엮어 사용하는 것
- 스프링은 설정 파일이나, 어노테이션을 통해 객체 간 의존 관계를 설정할 수 있음.
- 의존 관계로 설정된 객체는 직접 생성하거나 검색할 필요가 없다.
- A를 사용하기 위해서 B가 필요하다면 `A는 B에 의존한다`고 표현
- xml 파일과 annotation을 통해 DI를 구현한다.
- DI에 사용되는 annotation
  - @Autowired
    - 필드에 붙이는 어노테이션
    - xml에 설정된 빈 객체들을 불러온다는 것을 명시함
    - xml에는 component-scan 태그 혹은 bean 태그들을 이용하여 빈 객체 생성을 설정한다.
  - @Component
    - 클래스에 붙이는 어노테이션
    - 해당 클래스가 빈 객체가 될 것임을 명시함
    - xml 설정 파일을 사용하는 레거시 spring 에서는 component-scan 태그를 통해 해당 어노테이션을 활성화해야한다.
    - @Controller, @Service, @Repository와 같이 더 구체적인 기능을 암시하는 태그로 발전했다.
  - @Configuration
    - xml 설정 파일을 java 파일로 대신하기 위해 사용하는 어노테이션
    - 클래스에 붙이는 어노테이션으로, 해당 어노테이션이 붙은 java 파일은 설정 파일이 된다.
  - @Bean
    - java 설정 파일의 메소드에 쓰이는 어노테이션
    - xml 설정 파일에서 bean 태그를 대신한다고 생각하면 된다.
    - 메서드명이 bean 태그의 id명과 같음
### AOP; Aspect Oriented Programming
- 관점 지향 프로그래밍
- 관심사의 분리를 통해서 소프트웨어의 모듈성 향상
- 핵심 관심사와 공통 관심사 분리
  - 핵심 관심사: 실제 비즈니스 로직, application의 각 서비스 기능들을 의미
  - 공통 관심사: 핵심 관심사를 보조하며, 핵심 관심사가 실행되는 와중에 중간중간 끼어드는 기능들(예. 로그인 확인)
### POJO; Plain Old Java Object
- 특정 환경이나 기술에 종속적이나 않은 객체지향 원리에 충실한 자바 객체
- 테스트하기 용이하고 객체지향 설계를 자유롭게 적용할 수 있음.
- Plain: 특정 framework에 종속되지 않는 것을 의미
- Old: EJB 이전의 java class를 의미
- 인터페이스를 구현하거나 클래스를 상속 받지 않는 일반 자바 객체를 의미하고, 스프링이 이를 지원함
### PSA; Portable Service Abstraction
- 환경과 세부기술의 변경과 관계없이 일관된 방식으로 기술에 접근할 수 있게 해주는 설계 원칙
- low level의 기술 구현 부분과 기술을 사용하는 인터페이스로 분리. 즉, 환경과 세부기술이 변경되더라도 사용하는 인터페이스는 그대로이므로 사용 방식에는 변동이 없다.

### 기타 용어 설명
- Container : 객체 생성 기능을 가진 주체
- dependency : 작업할 때 필요한 library
- 결합도
  - 클래스간의 결합도
  - 낮을수록 좋음(interface, di로 낮출 수 있음)
- 응집도
  - 하나의 클래스를 구성하는 메소드, 필드 등의 연관성에 대한 용어
  - 클래스가 본래 목적에 맞게 모두 만들어져있는가

## AOP; Aspect-oriented Programming

### Aspect-oriented Programming이란?
- 관점 지향 프로그래밍으로, 객체 지향 프로그래밍과 같이 프로그래밍 방식 중 하나이다.
- Asect 지향의 중요 개념 : 핵심 업무에서 공통 업무를 분리 시키는 것
- `핵심 업무`와 `공통 업무`로 관점을 구분한다.
  - 핵심 업무: business logic. 즉, application의 각각의 서비스 기능을 의미한다.
  - 공통 업무: 핵심 업무를 도와주는 반복적이고 부가적인 일로, 핵심 업무가 실행되는 중 중간에 끼어들어서 실행되는 작업들이다.
- 예시. 은행 업무 처리 시스템
  - 핵심 기능: 계좌 이체, 대출 승인, 이자 계산, ...
  - 공통 기능(부가 기능): 로깅, 보안, 트랜젝션, ...

### AOP Framework
- AOP를 구현하기 위해 사용하는 Framework들이 존재한다.
- 종류
  - Spring AOP
    - Spring Framework가 제공하는 Aop Framework
    - Proxy 기반의 AOP를 제공한다.
    - Proxy를 사용하기 때문에 메모리가 낭비되거나 속도가 저하될 위험이 있다. 하지만 가볍기 때문에 enterprise application에는 사용이 적합하다. (runtime 시, 호출될 때만 실행되기 때문;추측, 추가 공부)
  - AspectJ
    - full-blown. 즉, 모든 aspect 관련 기능을 갖고 있는 프레임워크
    - complie, 혹은 loading 시점에서 Target class에 aspect 코드가 끼어들어간 형태의 .class 파일이 생성된다.
    - 떄문에 속도가 빠르고 성능이 좋다.
    - 하지만 그만큼 무겁기 때문에 enterprise application에는 사용이 부적합하다.