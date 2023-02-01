# dictionary로 받은 인자에서 'age'에 해당하는 value의 총합을 반환하는 함수 만들기

def age_sum_total(infos):
    sum_total = 0
    for info in infos:
        sum_total += info['age']
    return sum_total

infos = [{'name': 'kim', 'age': 12}, {'name': 'lee', 'age': 4}]
print(age_sum_total(infos))