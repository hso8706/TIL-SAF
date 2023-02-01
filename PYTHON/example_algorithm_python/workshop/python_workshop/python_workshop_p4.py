# 2차원 List의 전체 합 구하기
# 1. 요소 하나하나 순회하기
# 2. 재귀 함수 사용하기

# 1. 
def all_list_sum(outer_list):
    sum = 0
    for inner_list in outer_list:
        for i in range(len(inner_list)):
            sum += inner_list[i]
    return sum

print(all_list_sum([[1], [2, 3], [4, 5, 6], [7, 8, 9, 10]])) # 55
print(all_list_sum([[1], [2, 3], [4, 5, 6], [7, 8, 9, 10], [20], [20, 30, 25]])) # 150

# 2.
def all_list_sum_recursive(lst, res = 0):
    for i in lst:
        if type(i) == list:
            res += all_list_sum_recursive(i)
        else:
            res += i
    return res
# lst: 인자로 제공받는 list
# res: 반환할 list 요소의 총합, 기본값=0으로 지정하고 인자로 제공받지 않는다, 합을 계속 건네주기 위해서 매개변수로 설정
# base_case: lst의 요소가 list가 아닌 경우가 base_case가 될 예정
# 1) n차 list를 lst 매개변수로 제공받는다
# 2) lst의 요소의 타입이 list가 아닐때까지 재귀함수를 반복한다.
# 3) lst의 요소의 타입이 list가 아니면 해당 요소의 값을 res에 더해준다
# 4) res를 반환하여 이전 재귀 뎁스로 올린다.

print(all_list_sum_recursive([[1], [2, 3], [4, 5, 6], [7, 8, 9, 10]])) # 55
print(all_list_sum_recursive([[1], [2, 3], [4, 5, 6], [7, 8, 9, 10], [20], [20, 30, 25]])) # 150