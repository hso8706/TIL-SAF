# 간단한 N의 약수
# input : N // 1 <= N(int) <= 1000
# output : N의 모든 약수 // 오름차순

def divisor(n):
    list_for_result = []
    for i in range(1, n+1):
        if n % i == 0:
            list_for_result.append(i)
    return list_for_result

n = int(input())
print(divisor(n))