score = {
    'python': 80,
    'django': 89,
    'web': 83
}

# 'algorithm'과목 점수 추가, 90점
score['algorithm'] = 90

# 'python'과목 점수 정정, 80 -> 85
score['python'] = 85

# 전체 평균 출력
avg = sum(score.values()) / len(score)
print(avg)
# 전체 평균 출력 하드코딩
sum_hard_c = 0
cnt = 0 
for i in score.values():
    sum_hard_c += i
    cnt += 1
print(sum_hard_c / cnt)
