### src/main/java
- java 파일 집합
### src/main/resources
- java 파일 외의 집합

### coffee1
- 강한 결합

### coffee2
- 인터페이스를 이용해서 결합을 보다 느슨하게 변경

### coffee3
- Spring Container를 활용해서 더 느슨하고, 유지보수가 쉽도록 변경
- coffee.xml에 설정 내용 기입
- Spring Container가 객체 관리를 담당
  - 객체를 미리 생성하여 준비해두는 느낌
  - client는 호출만 하면 된다.
  - 필요없어지면 알아서 삭제
- 이후 변경이 필요한 경우 java코드가 아닌 xml만 바꾸면 된다.
- bean 객체
  - 기본 싱글톤 패턴
  - scope 속성으로 설정 가능
- lazy-init 속성
  - true일 경우 요청이 들어오면 그제서야 생성
  - 그렇지 않은 경우는 미리 생성되어있음
  - `<beans>`태그 속성에 아예 default-lazy-init 속성을 붙일 수도 있음.

### 객체 주입
- ref 속성
- property tag : set method 호출

### XML 문서
- 나중엔 XML 문서가 너무 거대해지게됨
- 때문에 다 조각내고 main.xml에서 조각들을 import함
- CoffeeApp에서는 main.xml만 읽게함

### 어노테이션

- `<context:component-scan base-package="">`

### namespace
- 쓸 수 있는 태그를 추가하는 부분