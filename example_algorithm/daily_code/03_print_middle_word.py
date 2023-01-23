# 입력받은 문자열의 정중앙의 문자를 출력하기. 문자열이 짝수인 경우 2개를 출력함

def print_middle_word(str):
    if len(str) % 2 != 0:
        return str[len(str)//2]
    elif len(str) % 2 == 0:
        return str[len(str)//2-1 : len(str)//2+1]

print(print_middle_word('print')) # 홀수
print(print_middle_word('middle')) # 짝수1
print(print_middle_word('33333middle33333')) # 짝수2