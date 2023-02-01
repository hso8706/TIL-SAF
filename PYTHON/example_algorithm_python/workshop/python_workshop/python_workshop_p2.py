# sum() 사용하지 않고 list의 합 구하기

def list_sum(intArr):
    result_sum = 0
    for i in intArr:
        result_sum += i
    return result_sum

list_1 = [1,2,3,4,5,6,7,8,9,10]
list_2 = [1,2,3,4,5,6,7,8,9]
print(list_sum(list_1))
print(list_sum(list_2))