def sum_of_digit_with_repeat(num):
    digit_list = list(map(int, list(str(num))))
    sum_digit = 0
    for i in digit_list:
        sum_digit += i
    return sum_digit

def sum_of_digit_without_repeat(num):
    return sum(list(map(int, list(str(num)))))

print(sum_of_digit_with_repeat(3904)) # 16
print(sum_of_digit_without_repeat(3904)) # 16
