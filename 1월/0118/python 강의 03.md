# **Python_03**
### Index
1. 함수 기초
2. 함수의 결괏값(Output)
3. 함수의 입력(Input)
4. 함수의 범위(Scope)

### 함수
- 목적
  - 기능 분해
  - 재사용 가능성(추상화)

- 종류
  - 내장 함수
  - 외장 함수  
  : 외부 라이브러리 함수, `import` 사용
  - 사용자 정의 함수

- 정의  
  : 특정한 기능을 하는 코드의 묶음

- 함수 기본 구조
  - 선언과 호출
  - 입력
  - 문서화
  - 범위
  - 결과값
  <img width="40%" src="https://user-images.githubusercontent.com/103169947/213060640-c65cb7d0-77d0-45ad-9537-76a285a43dc4.PNG"/>

- 선언과 호출  
  - 선언  
  : `def` 키워드 사용하여 선언  
  : 함수명과 파라미터(매개변수)를 설정  
  : 함수의 몸체(function body)에 해당하는 코드 작성(함수 호출 시 실행될 코드)  
  : 함수의 몸체에서 나온 결과를 반환하기 위해 `return` 키워드 사용(반환값이 없을 경우 생략)
  - 호출  
  : `함수명(인자)`를 통해 선언한 함수를 호출할 수 있음

- 함수의 종류
  - void function  
  : 명시적인 return 값이 없는 함수
  : None 을 반환하고 종료
  - value retruning funcion
  : return 값이 존재하는 함수  
  : 값 반환 후 함수가 바로 종료됨  
  : 2개 이상의 반환값은 기본적으로 `tuple` 형식으로 반환됨(아래 참고)  
  : 2개 이상의 반환값을 `tuple`이 아닌 값으로 받기 위해서는, `tuple` 이 아닌 다른 컨테이너로 묶어서 반환할 수도 있음.
  ```python
  # 2개 이상의 반환값이 존재하는 경우
  def minus_and_product(x, y):
    return x - y, x * y
  
  y = minus_and_product(4, 5):
  print(y) # (-1, 20)
  print(type(y)) # <class 'tuple'>
  ```

- parameter 와 argument
  - parmeter : 매개변수
  - argument : 인자

- argument 제공 방법
  - 기본  
  : 기본적으로 `parameter`를 설정한 순서대로 인자로 제공됨   
  : 혹은 `parameter`명으로 설정한 이름을 붙여 주어서 값을 제공하면 순서와 상관없이 올바른 위치로 인자가 제공됨
  ```python
  # 예시
  def add(x, y):
    return x + y
  
  add(2, 5) # x=2, y=5
  add(x=2, y=5) # x=2, y=5
  add(2, y=5) # x=2, y=5
  add(x=2, 5) # Error
  ```
  

- Default Arguments Values  
  : `parameter`를 설정할 때 기본값을 설정하면, 인자로 값을 제공하지 않고 함수를 호출할 때 기본값이 인자로 제공된다.
  ```python
  def add(x, y=0):
    return x + y
  
  add(2) # x=2, y=0, return=2
  ```  
### Scope
- name space  
  : 이름을 할당했을때 저장되는 공간

- name space 종류
  - built-in  
  : 파이썬에 내장
  - global  
  : `.py`에 해당하는 공간
  - enclosing  
  : 중첩된 local 공간이 존재할 때, 내부 local을 감싸는 외부 local 공간을 enclosing name space라고 함
  - local  
  : 함수 생성 시 함수 안쪽에 생성되는 공간

- Scope
  - global scope
  - local scope
  - 식별자 검색 규칙  
  : 식별자를 검색할 때, Scope에 따라 검색됨  
  : `Local` -> `Enclosed` -> `Global` -> `Built-in`  
  // 식별자 검색 규칙 때문에 키워드를 변수명으로 하지말라는 이유임
  
- 변수 생명주기  
  : 변수가 해당되는 scope를 벗어나면 사라진다
  - built-in scope  
  : 파이썬이 실행된 이후부터 영원히 유지
  - global variable  
  : 모듈이 호출된 시점 이후부터 유지  
  : 인터프리터가 끝날 때까지 유지
  - local variable  
  : 함수 호출될 때 생성, 함수 종료될 때 삭제

- `global` 키워드  
  : global 식별자가 아닌 식별자를 global scope의 식별자로 만들어주는 키워드 
  - 사용 시 주의사항  
  : `global` 키워드가 붙은 식별자를 local 식별자의 이름으로 사용할 수 없음  
  : `global` 키워드를 붙인 식별자를 이전에 다른 scope 식별자로 사용했으면 안 됨(선언된 적 없는 식별자에 사용가능)
- `nonlocal` 키워드  
  : global을 제외하고 가장 가까운(둘러싼, enclosed) scope의 변수를 연결함  
  : global과 반대로 선언된 적 없는 식별자에 `nonlocal` 키워드를 사용할 수 없음(선언된 적 있는 식별자에 사용가능)

- Scope 주의사항 정리
  1. `Local` 식별자는 함수 생성 시 생성되고, 함수 종료시 사라진다.  
  2. 해당 scope에 식별자가 없을 경우, `LEGB rule`에 의해 이름을 검색한다.  
  3. 하위 scope에서 상위 scope의 값을 변경할 수 없다. 특별한 방법이 필요함.
  4. `global`, `nonlocal` 키워드를 사용하면, 상위 scope의 값에 접근 및 변경할 수 있다. 하지만 각각의 키워드에서 주의할 점도 존재한다. (사용하지 않는 것을 권장)
