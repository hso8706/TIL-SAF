# **Python_02**
## **Index**
1. 코드 스타일 가이드
2. 조건문
3. 반복문  
  
## **제어문**
### 제어문이란?  
: 순차, 선택, 반복  

## **코드 스타일 가이드**
### PEP8
: 파이썬에서 제언하는 스타일 가이드  
: 두 개 이상의 스타일 선택지가 있을 경우에는 하나의 파일 내에서는 통일된 스타일을 사용할 것.  

## **조건문**
### 정의
: 참/거짓을 판단하는 문법  
### 사용법
- `if` - `elif` - `else`
- `:` + `들여쓰기`
- `Falsy`
### 삼항 연산자(조건 표현식)
- 조건 표현식  
```python
# python 
# (true인 경우의 값) if (조건식) else (false인 경우의 값)

# 예시 1
# num의 절대값은 value에 저장하는 코드
value = num if num >= 0 else -num
# 예시 2
# num이 홀수인지, 짝수인지 판단하는 코드
print("홀수입니다.") if num%2 else print("짝수입니다.")


# java
# (조건식) ? (true인 경우의 값) : (false인 경우의 값)
```

## **반복문**
### 정의
: 특정 조건을 만족할 때까지 같은 동작을 계속 반복시키는 문법
### `while`  
: 조건식이 참인 경우 코드를 반복하여 실행
```python
while (condition):
  (body)
```
### `for`  
: 순회 가능한 객체(iterable)의 요소를 모두 순회  
: variable은 2개 이상이어도 됨.  
: java의 for-each문이라고 생각하면 좋을듯
- `iterable`  
: 순회할 수 있는 자료형(string, list, dict,tuple, range, set 등)  
: 순회형 함수(range, enumerate)
```python
for (variable) in (iterable):
  (body)
```
  - `dict`  
  : dict가 iterable일 경우, 기본적으로 key 값을 순회

```python
# dict 메서드

dict.keys() # dict의 key들로 구성된 결과
# 출력 : dict_keys(['john', 'eric'])

dict.values() # dict의 value들로 구성된 결과
# 출력 : dict_values([80, 90])

dict.items() # (key, value)의 튜플로 구성된 결과
# 출력 : dict_items([('john', 80), ('eric', 90)])
```
  - `enumerate`  
  : 열거형  
  : (index, value) 형태의 tuple로 구성된 객체

  ```python
  members = ['민수', '영희', '철수']
  print(list(enumerate(members)))
  print(list(enumerate(members, start=1)))

  for idx, number in enumerate(members):
    print(idx, number)
  '''
  [(0, '민수'), (1, '영희'), (2, '철수')]
  [(1, '민수'), (2, '영희'), (3, '철수')]

  0 민수
  1 영희
  2 철수
  '''
  ```
  - `List Comprehension`  
  : 표현식과 제어문을 통해 특정한 값을 가진 리스트를 간결하게 생성하는 방법  
  : java에서 stream 쓰듯 쓸 수 있을 것 같다.
  ```python
  # [code for variable in iterable]
  cubic_list = []
  for i in range(1,4):
    cubic_list.append(i**3)
  print(cubic_list) #[1, 8, 27]

  cubic_list = [i**3 for i in range(1,4)]
  print(cubic_list) #[1, 8, 27]

  # [code for variable in iterable if 조건식]
  arr = [n for n in range(1, 11) if n % 2 == 0]
  print(arr) #[2, 4, 6, 8, 10]
  ```

### `반복 제어문`
- break
- continue
- pass  
  : 아무것도 하지 않음(문법적으로 피룡하지만, 할 일이 없을 때 사용)  
  : 그저 빈 자리를 채우는 용도이고, 반복문이 아닌 곳에서도 사용하는 키워드이다.
- for-else  
  : 반복문을 끝까지 실행한 이후에 else 문 실행  
  : if-else 문과 비슷   
  : break으로 중간에서 탈출했으면 else 문도 실행하지 않음.