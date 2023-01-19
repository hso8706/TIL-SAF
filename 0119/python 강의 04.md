# **Python_04**
### Index
1. 함수 응용
2. 함수 가변 입력 (패킹/언패킹)
3. 모듈과 패키지
4. 가상환경

## 함수 응용
### 내장 함수
  - map(function, iterable)  
  : `iterable`한 객체를 넘겨주면 객체의 하나하나 요소마다 `function`을 적용해주는 함수  
  : 적용된 결과를 `map object`로 반환  
  // 하지만 반환값 갯수대로 각각 받는다면 언패킹되어 우리가 아는 type으로 받을 수 있음  
  : 주로 알고리즘 문제에서 다중 `input`을 받을때나, `for`문을 대신할 때 사용함.   
  ```python
  def iterable_example(n):
    return n * 10
  list_example = [1, 2, 3, 4, 5]

  map_1 = map(iterable_example, list_example) # map object로 반환
  map_2 = list(map(iterable_example, list_example)) # [10, 20, 30, 40, 50]
  ```

  - filter(function, iterable)  
  : `iterable`한 객체를 넘겨주면 객체의 하나하나 요소마다 `function`을 적용해주는 함수 
  : `map()`과 다른 점은 `filter`의 경우 `function`에 적용한 결과가 `True`일때의 값만 모아서 반환한다.
  : 적용된 결과를 `filter object`로 반환
  ```python
  def odd(n):
    return n % 2
  num = [1, 2, 3]

  result_1 = filter(odd, num) # return 값이 1이면 True, 0이면 False
  print(result_1) # filter object로 반환
  result_2 = list(filter(odd, num))
  print(result_2) # [1, 3]
  ```  
  - zip(*iterables)  
  : 복수의 `iterable`을 모아 튜플을 원소로 하는 `zip object`를 반환  
  ```python
  girls = ['jane', 'ashley']
  boys = ['justin', 'eric']
  pair = zip(girls, boys)

  print(pair) # zip object로 반환
  print(list(pair)) # [('jane', 'ashley'), ('justin', 'eric')]
  ```  
  
### lambda 함수
- 람다함수  
: 표현식으로 계산한 결괏값을 반환하는 함수  
: 익명 함수라고도 부른다. (이름이 없는 함수)  
- 특징  
: return문을 가질 수 없음  
: 간편 조건문 외 조건문이나 반복문을 가질 수 없음  
: 간편하게 혹은 단발적으로 함수를 사용할 때 사용  
- 장점  
: 함수를 정의해서 사용하는 것보다 간결하게 사용 가능  
: def를 사용할 수 없는 곳에서도 사용가능  
- 구조  
```python
# (lambda (매개변수) : (매개변수를 이용한 리턴값))
# 매개변수는 2개 이상도 받을 수 있다.

# 예시, 아래 두 함수는 같은 함수이다.
def pow(x):
  return x * x

lambda x : x * x # 사실 이렇게 선언해서 쓰진 않고, 코드 내부에서 그냥 사용됨.
# 호출
print(pow(2)) # 4
print((lambda x : x * x)) # 4
```

### 재귀 함수(recursive function)
- 재귀 함수  
: 자기 자신을 호출하는 함수  
: 재귀 함수를 사용할 땐 필수적으로 재귀 함수를 탈출할 수 있는 조건을 설정  
: 1개 이상의 base case(종료되는 상황)가 존재하고, 수렴하도록 작성  
: 알고리즘 문제 풀 때 주로 사용 (팩토리얼 예시)  
- 단점  
: 어려움. 머릿속으로 그리기가 힘들다. (무조건 종이와 펜으로 그림을 직접 그리면서 하는 것이 좋음)  
- 팩토리얼 예시  
```python
def factorial(n):
  if n == 0: # base case
    return 1
  return n * factorial(n-1)

print(factorial(5))
# (5 * factorial(4))
# (5 * (4 * factorial(3)))
# (5 * (4 * (3 * factorial(2))))
# (5 * (4 * (3 * (2 * factorial(1)))))
# (5 * (4 * (3 * (2 * (1 * factorial(0))))))
# (5 * (4 * (3 * (2 * (1 * 1)))))
```
- 반복문과 재귀 함수  
: 알고리즘 자체가 재귀적인 표현이 자연스러울 때만 재귀 함수를 사용  
: 반복문과 재귀 함수는 서로 상호적으로 사용할 수 있음  
: 재쉬 호출은 반복문을 사용할 때보다 변수 사용을 줄여줄 수 있음  
: 하지만 연산 속도 느리니까 참고  

### 패킹/언패킹  
- 패킹/언패킹 연산자(`*`)  
: 모든 시퀀스형(list, tuple 등)은 패킹/언패킹 연산자(`*`)를 사용하여 객체의 패킹 또는 언패킹이 가능  
- 패킹 코드 예시
```python
x, y = 1, 2 # x = 1, y = 2
z = 1, 2, 3 # z = (1, 2, 3); tuple로 묶임

a, b = 1, 2, 3, 4 # Error; 어디를 기준으로 묶어야할 지 몰라서 에러남.
a, *b = 1, 2, 3, 4 # a = 1, b = (2, 3, 4) ; a에 하나 할당하고 나머지를 b에 묶어서 할당
```
- 언패킹 코드 예시
```python
def my_sum(a, b, c):
  return a + b + c

num_list = [10, 20, 30]
# 기존
result_bef = my_sum(num_list[0], num_list[1], num_list[2])
# 언패킹
result_aft = my_sum(*num_list)
```
- 패킹/언패킹 연산자_`매개변수`로의 활용  
: 가변적으로 매개변수를 사용할 수 있음(가변 인자)
```python
# *values말고 다른 기본 매개변수를 제공하면, 해당 인자를 필수적으로 받아야 되는 함수가 됨.
def test(*values)
  for value in values:
    print(value, end=" ")

test(1) # 1
test(1, 2) # 1 2
test(1, 2, 3) # 1 2 3
# 위처럼 시퀀스형 데이터가 아닌 콤마로 구분한 인자들을 제공해도 패킹/언패킹 연산자가 알아서 처리해줄 수 있음.

# 키워드(dict)를 인자로 받는 함수
def test_dect(**kwargs):
  print(kwargs, type(kwargs))

test(name="aiden", age=21)
# {"name"="aiden", "age"=21} <class 'dict>

# 가변 인자 + 키워드 복합 함수
def test_dect(*arge, **kwargs):
```

## 모듈과 패키지
### 모듈과 패키지, 그리고 라이브러리
- 모듈(파일)  
: 특정 기능을 하는 코드를 `하나의 파일`(.py)로 묶은것  
- 패키지(디렉토리)  
: 다양한 파일(모듈)을 `하나의 폴더`로 묶은것  
- 라이브러리(디렉토리)  
: 다양한 패키지를 `하나의 묶음`으로 묶은것  
// 파이썬에서는 패키지와 라이브러리를 약간 혼용해서 쓰는 경향이 있음.  
- 모듈과 패키지 불러오기
  - `import`
  ```python
  # module 불러오기
  import module # module의 전체 사용
  from module import * # module의 전체 사용
  from module import var, function, Class # module의 부분 사용
  # package 불러오기
  from package import module # package.module의 전체 사용
  from package.module import var, function, Class # package.module의 부분 사용
  ```
- 모듈과 패키지 참고  
: github에 python에서 찾아볼 수 있음  
: 용량을 줄이기 위해서 모듈이나 패키지를 불러올 때 필요한 부분만 사용하는 것이 좋음  
- 파이썬 패키지 관리자(pip)  
: 파이썬 설치할 때 같이 설치했음  
: PyPI라는 웹에 연결하여 저장된 외부 패키지들을 설치하도록 도와주는 패키지 관리 시스템이 `PIP`이다.  
: bash, cmd 환경에서 명령어를 이용하여 사용
  - pip 사용 예시
  ```python
  $ pip install SomePackage
  $ pip install SomePackage==1.0.5 # 특정 버전
  $ pip install SomePackage>=1.0.4 # 특정 버전 이상(최소 버전 명시)
  $ pip uninstall SomePackage
  $ pip list # 내 컴퓨터에 설치된 패키지 리스트 확인
  $ pip show SomePackage # 특정 패키지의 정보 출력

  # freeze, requirment 등은 이후에 공부
  ```
  - 패키지로 인식시키기  
    - `__name__`  
    : 모듈명 양 옆에 두 개의 언더바 `__`를 붙이고 만들면 파이썬이 해당 모듈이 있는 디렉토리를 패키지로 인식함