# 함수 내부에 불필요한 print문이 있는 경우 오답으로 처리가 됩니다.
# python 내장함수 min, max 사용 금지
def min_max(scores):
    pass
    # 여기에 코드를 작성하여 함수를 완성합니다.
    # 점수 <= 100

    if len(scores) == 0: return None # 빈 리스트가 들어올 경우 None 반환

    # scores 리스트의 첫번째 인덱스를 임의로 할당
    min_score = scores[0] # 최소값 변수
    max_score = scores[0] # 최대값 변수
    # scores 리스트를 순회하며 가장 큰 값과 가장 작은 값을 갱신하여 할당하는 반복문
    for i in scores:
        if min_score > i: # scores 리스트 순회 중 순회한 요소가 min_score보다 작은 경우 갱신
            min_score = i
        if max_score < i: # scores 리스트 순회 중 순회한 요소가 max_score보다 큰 경우 갱신
            max_score = i
    return (min_score, max_score)

# 아래의 코드를 수정하거나 새롭게 추가하지 않습니다.
########## 코드 변경 금지 ############
if __name__ == '__main__':
    scores = [80, 90, 85, 75]
    print(min_max(scores))    # (75, 90)
