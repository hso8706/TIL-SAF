# 출력 결과 예시
# 스테이크   50,000
# + VAT     7,500
# 총계 ₩    57,500

steak = 50000
vat = 0.15
print(f'{steak}', f'{int(steak * vat)}', f'{int(steak + (steak*vat))}')