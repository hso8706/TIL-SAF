# 함수 내부에 불필요한 print문이 있는 경우 오답으로 처리가 됩니다.
# 반드시 재귀함수로 구현해야 합니다.
def dec_to_bin(number):
    pass
    # 여기에 코드를 작성하여 함수를 완성합니다.

    # 재귀함수 구현
    # base_case : 2로 나눈 몫이 0인 경우
    # 반환값 : 문자열 형식, 각 나머지를 문자열로 반환하여 더해주면 완성

    str_number = ''
    if number // 2 == 0:
        str_number += str(number % 2)
        return str_number
    else:
        str_number += dec_to_bin(number // 2) + str(number % 2)
    return str_number






# 아래의 코드를 수정하거나 새롭게 추가하지 않습니다.
########## 코드 변경 금지 ############
if __name__ == '__main__':
    print(dec_to_bin(10))  # 1010
    print(dec_to_bin(5))   # 101
    print(dec_to_bin(50))  # 110010
