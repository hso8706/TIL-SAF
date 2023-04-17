# 23.04.17

### Spring framework
- Enterprise application에서 필요로 하는 기능을 제공하는 프레임워크
- Enterprise application
  - web이라고 봐도 무방하다.
  - 원격의 환경에서 네트워크로 활용하는 어플리케이션
- JEE가 제공하는 다수의 기능을 지원하는 경량화 프레임워크

### Spring framework의 목표
- java enterprise applicaion의 기반(infro) 제공하는 것.
- 그로인해 개발자는 domain problem(핵심 문제)에만 집중할 수 있게 도와주는 것이 목표

### Spring Framework 구성 요소
- Spring Core
- Spring Context : Spring Core에 추가 버젼
- Spring AOP
- Spring DAO : DB관련
- Spring ORM : DB관련
- Spring Web : Web관련
- Spring Web MVC : Web관련

### Spring Core, Context
- Spring core
  - IoC(혹은 DI) 기능을 지원하는 영역
  - Bean Container
- Srping context

### DI, Dependency Injection
- 객체 사이의 의존 관계가 객체가 아닌 외부에 의해서 설정
- A를 사용하기 위해서 B가 필요하다면 `A는 B에 의존한다`고 표현

### IoC
- 자바 객체 생성/ 객체간의 의존관계 설정이 `개발자`가 주체가 아닌 `컨테이너`에게 주체를 넘긴것
- 제어의 역전
  - 필요한 객체를 자신이 직접 생성하지 않고 외부(spring container)로부터 공급 받는 일

### 용어 설명
- Container : 객체 생성 기능
- dependency : 작업할 때 필요한 library
- 결합도
  - 클래스간의 결합도
  - 낮을수록 좋음
- 응집도
  - 하나의 클래스 내에서의 얘기
  - 클래스가 본래 목적에 맞게 모두 만들어져있는가