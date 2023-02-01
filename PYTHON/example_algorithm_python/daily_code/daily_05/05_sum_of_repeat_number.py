# num_list = [4, 4, 7, 8, 10, 4]
# sum_of_repeat_number(num_list)

# 출력 예시 
#  25

# dictionary로 정리 후 value가 1인 값만 sum

def sum_of_repeat_number(num_list):
    num_dict = {}
    sum_for_return = 0
    for num in num_list:
        if num in num_dict.keys():
            num_dict[num] += 1
        else:
            num_dict[num] = 1
    
    for key in num_dict.keys():
        if num_dict[key] == 1:
            sum_for_return += key

    return sum_for_return

num_list_01 = [4, 4, 7, 8, 10, 4]
num_list_02 = [4, 4, 7, 5, 6, 7, 8, 10, 8, 9, 10, 4, 9, 6, 5]
print(sum_of_repeat_number(num_list_01)) # 25
print(sum_of_repeat_number(num_list_02)) # 0