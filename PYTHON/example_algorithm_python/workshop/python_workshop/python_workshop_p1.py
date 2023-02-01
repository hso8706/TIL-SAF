# SWEA #1933. 간단한 N의 약수
# 1 <= N <= 1000
# N 입력
# N의 모든 약수를 오름차순으로 출력

# n 입력
n = int(input())
# n의 모든 약수를 저장할 빈 리스트 생성
result = []
# 약수를 구하기 위한 for문
for i in range(1, n+1):
    if n % i == 0:
        result.append(i)
# 언패킹 연산자를 이용해서 출력
print(*result)