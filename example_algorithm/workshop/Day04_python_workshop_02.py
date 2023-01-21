# List의 합 구하기
def list_sum(lst):
    sum = 0
    for i in lst:
        sum += i
    return sum

print(list_sum([1,2,3,4,5]))
print(list_sum([1,2,3,4,5,6,7,8,9,10]))