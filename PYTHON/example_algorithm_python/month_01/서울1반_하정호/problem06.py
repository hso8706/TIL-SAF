# 함수 내부에 불필요한 print문이 있는 경우 오답으로 처리가 됩니다.
def over_24(people):
    pass
    # 여기에 코드를 작성하여 함수를 완성합니다.

    # 24세를 `초과`하는 지원자의 `수` 반환
    sum_over_people = 0 # 24세 초과 지원자 수의 총합(카운트)

    for people_dict in people: # people(dict)를 순회 
        if people_dict['age'] > 24: # people['age']의 value가 24세를 초과하는지 판단
            sum_over_people += 1 # 초과한다면 24세 초과 지원자 수 총합에 더함
    
    return sum_over_people


# 아래의 코드를 수정하거나 새롭게 추가하지 않습니다.
########## 코드 변경 금지 ############
if __name__ == '__main__':
    people = [
        {'name': '김싸피', 'age': 25},
        {'name': '이싸피', 'age': 28},
        {'name': '조싸피', 'age': 29},
        {'name': '아싸피', 'age': 23},
        {'name': '최싸피', 'age': 22},
        {'name': '고싸피', 'age': 21},
        {'name': '유싸피', 'age': 26},
        {'name': '후싸피', 'age': 20},
    ]

    print(over_24(people))  # 4