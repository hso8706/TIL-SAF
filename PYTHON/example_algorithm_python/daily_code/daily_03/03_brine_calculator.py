# 입력한 소금물 혼합물의 농도(%)와 양을 출력하는 함수 생성
# 소금물의 농도(%), 소금물의 양을 사용자 입력 처리(쌍으로 받을 것)
# done을 입력하면 입력 종료
# 입력받는 소금물의 종류는 최대 5개
# 출력되는 소금물의 퍼센트 농도는 소수 둘째자리까지 반올림할 것

# custom round() 함수 : 부동소수점 문제를 해결
def round_perfect(n, point = 0):
    a = n * (10 ** point)
    result = int(a) + (1 if (a - int(a)) >= 0.5 else 0)
    return result / (10 ** point)

def brine_calculator():
    dict_brine = {}
    total_salt = 0

    print('소금물 농도 계산기입니다. 최대 5개의 소금물의 농도와 양을 계산할 수 있습니다.')
    end_point = ''
    for i in range(5):
        if end_point == 'done': break

        brine_con = int(input('소금물의 농도를 입력해주세요(%): '))
        brine_vol = int(input('소금물의 양을 입력해주세요(g): '))

        end_point = input('추가로 입력하시려면 "enter", 입력을 마치시길 원하면 "done"을 입력하여 주십시오: ')
        dict_brine[brine_con] = brine_vol
        total_salt += brine_con * brine_vol

    total_vol = round_perfect(sum(dict_brine.values()), 2)
    total_con = round_perfect(total_salt / total_vol, 2)
    return {'volume' : total_vol, 'concentration' : total_con}

print(brine_calculator())
