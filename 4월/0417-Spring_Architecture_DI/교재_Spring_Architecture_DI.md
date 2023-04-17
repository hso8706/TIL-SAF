# 23.04.17
## index
1. Spring & 개발환경
2. IoC & Contrainer
3. 의존성 주입, DI
4. DI - XML
5. DI - Annotation


### Spring Framework
- 엔터프라이즈 급 애플리케이션을 만드는 것을 목적으로 함
- 이전에 쓰던 프레임워크의 모든 기능을 종합적으로 사용하면서 경량화 된 솔루션
- low level까지 개발자기 신경 쓰지 않고 business logic 개발에만 전념할 수 있도록 돕는 솔루션
- JEE의 기능 + DI + AOP
- JEE: Java Enterprise Edition
- DI: Dependency Injection
- AOP: Aspect Oriented Programming

### Spring Framework Triangle
![image](https://user-images.githubusercontent.com/103169947/232359969-f12706c5-7a4d-41b9-9308-8d529541c9e6.png)

### Spring의 특징
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
### DI; Dependency Injection
- 의존성 주입
- 유연하게 확장 가능한 객체를 만들고 이를 의존관계로 엮어 사용하는 것
- 스프링은 설정 파일이나, 어노테이션을 통해 객체 간 의존 관계를 설정할 수 있음.
- 의존 관계로 설정된 객체는 직접 생성하거나 검색할 필요가 없다.
### AOP; Aspect Oriented Programming
- 관점 지향 프로그래밍
- 관심사의 분리를 통해서 소프트웨어의 모듈성 향상
- 핵심 관심사와 공통 관심사 분리
### POJO; Plain Old Java Object
- 특정 환경이나 기술에 종속적이나 않은 객체지향 원리에 충실한 자바 객체
- 테스트하기 용이하고 객체지향 설계를 자유롭게 적용할 수 있음.
- Plain: 특정 framework에 종속되지 않는 것을 의미
- Old: EJB 이전의 java class를 의미
- 인터페이스를 구현하거나 클래스를 상속 받지 않는 일반 자바 객체를 의미하고, 스프링이 이를 지원함
### IoC; Inversion of Control
- 제어의 반전, Spring의 핵심 기능
- 자바 객체 생성 및 의존관계 설정에 대한 제어권을 개발자가 아닌 프레임워크에게 넘기는 것을 의미
- Spring Framework에서는 Spring Container가 자바 객체 생성 및 의존관계 설정에 대한 제어권을 갖고 있음.
### PSA; Portable Service Abstraction
- 환경과 세부기술의 변경과 관계없이 일관된 방식으로 기술에 접근할 수 있게 해주는 설계 원칙
- low level의 기술 구현 부분과 기술을 사용하는 인터페이스로 분리. 즉, 환경과 세부기술이 변경되더라도 사용하는 인터페이스는 그대로이므로 사용 방식에는 변동이 없다.