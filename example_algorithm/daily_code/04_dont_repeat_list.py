def dont_repeat_list(int_list):
    list_for_return = [int_list[0]]
    for idx in range(1, len(int_list)):
        if int_list[idx] != int_list[idx-1]:
            list_for_return.append(int_list[idx])
        
    return list_for_return

int_list_exam_01 = [1, 1, 3, 3, 0, 1, 1] # [1, 3, 0, 1]
int_list_exam_02 = [5, 5, 3, 2, 1, 1, 3, 3, 5, 4] # [5, 3, 2, 1, 3, 5, 4]
print(dont_repeat_list(int_list_exam_01)) # [1, 3, 0, 1]
print(dont_repeat_list(int_list_exam_02)) # [5, 3, 2, 1, 3, 5, 4]