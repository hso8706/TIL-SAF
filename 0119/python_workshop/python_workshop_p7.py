# 강한 이름
# 문자열 2개를 제공받고, 문자열의 각 문자에 해당되는 아스키코드의 총합이 큰 문자열을 반환한다.

def get_strong_word(str1, str2):
    str_to_int_1 = sum(list(map(ord, str1)))
    str_to_int_2 = sum(list(map(ord, str2)))

    if str_to_int_1 == str_to_int_2: return [str1, str2]
    return str1 if str_to_int_1 > str_to_int_2 else str2


print(get_strong_word('z', 'a'))
print(get_strong_word('a', 'a'))
print(get_strong_word('delilah', 'dixon'))