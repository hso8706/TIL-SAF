# 1. name와 age 라는 두개의 argument를 넘기면 각각 이 값을 출력하는 함수를
# 작성해보세요.
# 2. 두개의 매개변수가 있고, 이 매개변수들을 덧셈하고 뺄셈한 결과를 모두 반환하는 함수를 작성해 보세요.
# 3. 우리 회사 멤버의 이름과 연봉을 출력하는 함수를 만들어보세요.
# 매개변수는 이름과 연봉이 들어가는데, 만약 함수 호출에서 연봉이 누락되면 기본으로 4500이 나오도록 해주세요.
# 4. n을 넘기면 1부터 n까지 더하는 my_sum 함수를 만들어보세요 (for 사용)
# 5. 4번을 while로 바꿔보세요
# 6. 주어진 리스트에서 가장 큰 값을 찾아주는 함수를 작성해 보세요.
# ```
# num_list = [4, 6, 8, 24, 12, 2]
# ```

# 1
def print_args(num, age):
    print(num, age)
# 2
def plus_minus(a, b):
    return [(a+b), (a-b)]
# 3
def print_info_corps(name, salary = 4500):
    print(name, salary)
# 4
def my_sum_for(n):
    sum_return = 0
    for i in range(1, n+1):
        sum_return += i
    return sum_return
# 5
def my_sum_while(n):
    sum_return = 0
    i = 1
    while i < n:
        sum_return += i
    return sum_return
# 6
def look_for_max(lst):
    max_return = 0
    for i in lst:
        if i > max_return :
            max_return = i
    return max_return

print(look_for_max([4, 6, 8, 24, 12, 2]))