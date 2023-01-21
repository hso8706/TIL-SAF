def all_list_sum(lst_lst):
    sum_list = 0
    for lst in lst_lst:
        for i in lst:
            sum_list += i
    return sum_list

print(all_list_sum([[1],[2,3],[4,5,6],[7,8,9,10]]))

def all_list_sum_recursive(lst_lst, total=0):
    for lst in lst_lst:
        if type(lst) == list:
            total = all_list_sum_recursive(lst, total)
        elif type(lst) == int:
            total += lst
    return total

print(all_list_sum_recursive([[1],[2,3],[4,5,6],[7,8,9,10]]))