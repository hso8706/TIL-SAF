# Dictionary로 이루어진 List의 합 구하기
# dict_list_sum : 인자로 제공받는 dict의 'age' key에 해당하는 value들의 합을 반환하는 함수
# args : dictionary로 이루어진 list

def dict_list_sum(dict_list):
    sum_age = 0
    for dict in dict_list:
        for key in dict.keys():
            if key == 'age':
                sum_age += dict[key]
    return sum_age

print(dict_list_sum([{'name': 'kim', 'age': 12},
{'name': 'lee', 'age': 4}]))

print(dict_list_sum([{'name': 'kim', 'age': 12}, {'name': 'lee', 'age': 4}, {'name': 'ha', 'age': 20}]))