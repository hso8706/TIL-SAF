# Dictionary로 이루어진 List의 합 구하기

# 01. 그냥 풀기, 반복문 순회하면서 age 다 찾기
# : age를 다시 찾을 일이 있으면 반복문을 또 순회해야하는 손실이 발생함.
def dict_list_sum_01(dict_list):
    sum_age = 0
    for dict in dict_list:
        sum_age += dict['age']
    return sum_age

print(dict_list_sum_01([{'name' : 'kim', 'age' : 12}, {'name' : 'lee', 'age' : 4}]))

# 02. age 정보를 새로운 dictionary로 정리하기
# : 간단한 문제에는 오히려 메모리 손실이 나겠지만, 반복적으로 특정 정보를 사용해야할 경우에는 성능적으로 큰 이득을 볼 수 있음.

def dict_list_sum(dict_list):
    sum_age = 0
    dict_age = {}
    for dict in dict_list:
        dict_age[dict.get('name')] = dict.get('age')
    for i in dict_age.values():
        sum_age += i
    return sum_age

print(dict_list_sum([{'name' : 'kim', 'age' : 12}, {'name' : 'lee', 'age' : 4}]))