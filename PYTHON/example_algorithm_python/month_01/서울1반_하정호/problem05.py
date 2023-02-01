# 함수 내부에 불필요한 print문이 있는 경우 오답으로 처리가 됩니다.
def calc_lunch_cost(lunch_cost):
    pass
    # 여기에 코드를 작성하여 함수를 완성합니다.

    # dictionary => {'이름' : 점심값}
    # 딕셔너리의 values를 순회하며 총합을 계산하고 반환(반복문 사용). 혹은 sum 함수 사용 가능
    # sum_cost = sum(lunch_cost.values())

    sum_cost = 0
    for cost in lunch_cost.values():
        sum_cost += cost
    return sum_cost


# 아래의 코드를 수정하거나 새롭게 추가하지 않습니다.
########## 코드 변경 금지 ############
if __name__ == '__main__':
    lunch_cost = {
        '이싸피' : 12000,
        '김싸피' : 30000,
        '박싸피' : 10000,
        '최싸피' : 15000,
        '조싸피' : 18000, 
    }

    print(calc_lunch_cost(lunch_cost))  # 85000