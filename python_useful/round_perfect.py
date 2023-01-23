# custom round() 함수 : 부동소수점 문제를 해결
def round_perfect(n, point = 0):
    a = n * (10 ** point)
    result = int(a) + (1 if (a - int(a)) >= 0.5 else 0)
    return result / (10 ** point)