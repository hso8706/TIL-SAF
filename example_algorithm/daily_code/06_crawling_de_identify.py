# A. 입력예시
# de_identify('970103-1234567')
# de_identify('8611232345678')

# B. 출력예시
# 970103*******
# 861123******* 

# 주민등록번호 구조 = 생년월일(6자리) + 성별, 지역, 오류검출코드(7자리)
# de_identify : 뒷자리(7자리)를 '*'로 만들어서 출력하는 함수

def de_identify(registration_num):
    code_num = ''
    code_num = registration_num[:6] + '*' * 7
    return code_num

regi_num_01 = '970103-1234567'
regi_num_02 = '8611232345678'

print(de_identify(regi_num_01))
print(de_identify(regi_num_02))