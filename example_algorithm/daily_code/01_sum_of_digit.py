# 입력받은 수의 각 자릿수의 합

lst_digit = list(map(int, list(input()))) # 사실 list 타입으로 변환시킬 것이 아니라 sum 함수를 이용해서 바로 합을 구할 수도 있음.
sum_digit = 0
for i in lst_digit:
    sum_digit += i
print(sum_digit)

lst_digit_to_sum = sum(map(int, list(input())))
print(lst_digit_to_sum)