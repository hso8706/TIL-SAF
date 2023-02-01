# 함수 내부에 불필요한 print문이 있는 경우 오답으로 처리가 됩니다.
def calculator(*numbers):
    pass
    # 여기에 코드를 작성하여 함수를 완성합니다.

    # 가변인자는 tuple 형식으로 제공
    # 입력 값의 갯수는 가변인자의 길이로 판단 => len 함수 사용
    
    # 입력 값이 하나인 경우, 값을 반지름 취급 : 원의 넓이를 반환
    if len(numbers) == 1:
        return (numbers[0] ** 2) * 3.14
    # 입력 값이 두개인 경우, 값을 변의 길이로 취급 : 삼각형 혹은 사각형 넓이를 반환
    elif len(numbers) == 2:
        if sum(numbers) % 2 != 0: # 두 입력 값(두 변)의 합이 홀수라면, 삼각형 취급
            return numbers[0] * numbers[1] / 2
        else: # 두 입력 값(두 변)의 합이 짝수라면, 사각형 취급
            return numbers[0] * numbers[1]
    # 입력 값이 3개 이상인 경우: (입력 값의 총합 , 입력 값의 평균) # tuple 형식으로 반환
    elif len(numbers) >= 3:
        sum_numbers = sum(numbers)
        avg_numbers = sum_numbers / len(numbers)
        return (sum_numbers, avg_numbers)
    # 입력 값이 없다면, 0을 반환
    else: return 0


# 아래의 코드를 수정하거나 새롭게 추가하지 않습니다.
########## 코드 변경 금지 ############
if __name__ == '__main__':
    print(calculator(5))                # 78.5
    print(calculator(10, 20))           # 200
    print(calculator(10, 20, 30, 40))   # (100, 25.0)
    print(calculator())                 # 0