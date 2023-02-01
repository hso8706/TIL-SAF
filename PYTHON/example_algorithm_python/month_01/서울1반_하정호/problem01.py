# 함수 내부에 불필요한 print문이 있는 경우 오답으로 처리가 됩니다.
def average(scores):
    pass
    # 여기에 코드를 작성하여 함수를 완성합니다.
    
    # 평균 점수 = 전체 점수 총합 / 전체 점수의 갯수

    if len(scores) == 0 : return None # 빈 리스트가 들어올 경우 None 반환, 나누는 값은 0이면 안 됨.

    sum_scores = sum(scores) # sum 함수를 이용하여 점수 총합 계산
    len_scores = len(scores) # len 함수를 이용하여 점수의 갯수 파악

    return sum_scores / len_scores # 평균 점수를 반환 (= 전체 점수 총합 / 전체 점수의 갯수)



# 아래의 코드를 수정하거나 새롭게 추가하지 않습니다.
########## 코드 변경 금지 ############
if __name__ == '__main__':
    scores = [80, 90, 85, 75]
    print(average(scores))    # 82.5