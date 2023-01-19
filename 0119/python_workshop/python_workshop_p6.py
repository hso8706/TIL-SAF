# 내 이름은 몇일까?
# 전달받은 인자의 문자열을 분해하고, 각각의 문자에 해당하는 아스키코드 값을 더하여 반환

def get_secret_number(str):
    lst = list(str)
    result_sum = 0
    for ch in lst:
        result_sum += ord(ch)
    return result_sum

print(get_secret_number('happy'))
print(get_secret_number('HaJungHo'))