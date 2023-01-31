# **객체 지향 프로그래밍 01**
## Index
- 객체 지향 프로그래밍
  - 추상화
  - 상속
  - 다형성
  - 캡슐화
- 에러와 예외처리
  - 디버깅
  - 에러와 예외

## 객체 지향의 핵심 개념
### 캡상추다
- 추상화
- 상속
- 다형성
- 캡슐화
### 추상화
- 복잡한 것은 숨기고, 필요한 것만 들어내기(강의)
- 카테고리의 상위 분기점의 속성으로 올라가는 것(나)
### 상속
- 의미
  - 부모-자식 관계를 정립하는 관계
  - 상위 클래스의 멤버를 하위 클래스가 이어받아 활용하는 것
  - 다른 클래스들이 공통된 규약을 갖기 위한 방법
- `Object`
  - 최상위 클래스
- 상속 구조
  ```python
  class Person:
    pass

  class Developer(Person): # 클래스의 인자로 넣어주면 상속 완료
    pass
  ```
- super()
  - 하위 클래스에서 상위 클래스를 대신하는 키워드(표현)
  - 해당 키워드로 상위 클래스의 요소를 호출할 수 있음
  - 예시: `super().__init__(...)`
- 다중 상속
  - 파이썬에서는 다중 상속이 가능
  - 인자로 두 개 이상의 클래스 제공
  - 중복된 멤버가 있는 경우에는 상속 순서에 의해 결정됨(먼저 넣은 인자가 우선)
- 상속 관련 함수와 메서드
  - `isinstance(object, classinfo)`
    - `object`가 `classinfo`의 instance이거나 subclass(하위 클래스)인 경우 True 반환
  - `issubclass(class, classinfo)`
    - `class`가 `classinfo`의 subclass면 True
    - classinfo의 모든 항목을 검사(여러 개의 classinfo를 제공할 수 있음)
  - mro(Method Resolution Order)
    - 해당 인스턴스의 클래스가 어떤 상위 클래스를 가지는지 확인하는 메서드
    - 인스턴스 -> 하위 클래스 -> 상위 클래스로 확장
### 다형성
- Polymorphism
- 메서드 오버라이딩
  - 상속받은 메서드를 재정의
    - 상위 클래스의 메서드를 하위 클래스내에서 같은 이름의 메서드로 재정의하면 됨.
### 캡슐화
- 캡슐화
  - 객체의 일부 구현 내용을 외부로부터 보호(직접적인 액세스를 차단)
  - 파이썬에서는 암묵적으로만 존재하고 언어적으로는 존재하지 않음
- 접근 제어자
  - Public Access Modifier
  - Protected Access Modifier
  - Private Access Modifier
- Public Access Modifier  
: 언더바 없이 시작하는 메서드나 속성  
: 어디서나 호출 가능, 하위 클래스 override 허용
- Protected Access Modifier  
: 언더바 하나로 시작하는 메서드나 속성  
: 상위 클래스 내부와 자식 클래스에서만 호출 가능(암묵적 규칙)  
: 하위 클래스 override 허용
- Private Access Modifier  
: 언더바 두개로 시작하는 메서드나 속성  
: 본 클래스 내부에서만 사용 가능(암묵적 규칙)  
: 하위 클래스 상속 및 호출 불가능, 외부 호출 불가능
- getter, setter
  - getter
    - @property 데코레이터 사용
  - setter
    - @변수.setter 사용

## 에러와 예외처리
### 디버깅
- 버그
  - 소프트웨어에서 발생하는 문제
- 디버깅
  - de + bugging
  - 버그를 수정하는 행위
### 에러와 예외
### 예외처리
### 예외 발생 시키기