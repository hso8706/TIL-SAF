'''
고려사항(우선)
- 사용자 입력 받기 (한 명 씩 입력)
- 10층, 20층 구분
- 층 별로 인원수가 딱 떨어지는 숫자로 조 편성(3,4,5 중 하나)
- 딱 떨어지지 않을 경우 4명 조를 기본으로하고 나머지 편성
- 프로그램 사용자 기록 남기기 => reward 시스템 적용 => txt 파일로 뿜자(Database로 사용)

고려사항(확장용)
- 일정 카테고리로 정렬된 dict로 value값을 삼으면 좀 더 성향에 맞는 사람끼리 주선도 할 수 있을 것 같다. => 하지만 랜덤 프로그램이라는 목적이 희미해질듯.
'''
import random

def lunch_random_program():
    # seoul_01_name_list_input = []
    seoul_01_name_list_10F = []
    seoul_01_name_list_10F_random = []
    seoul_01_name_list_20F = []
    seoul_01_name_list_20F_random = []
    
    print("=======================10층 희망자=======================")
    print("이름을 입력하여 주십시오. 입력을 종료하려면 'N' 또는 'n'을 입력하여 주십시오.")
    for i in range(28): # 28명 기본으로 전체 순회
        input_user = input('입력 : ')
        if input_user == 'N' or input_user == 'n':
            break
        else:
            seoul_01_name_list_10F.append(input_user)
            
        num_of_people = len(seoul_01_name_list_10F)
        random.shuffle(seoul_01_name_list_10F)
        if num_of_people % 3 == 0:
            seoul_01_name_list_10F_random
        elif num_of_people % 4 == 0:
        elif num_of_people % 5 == 0:
        else: 


    print("=======================20층 희망자=======================")
    print("이름을 입력하여 주십시오. 입력을 종료하려면 'N' 또는 'n'을 입력하여 주십시오.")
    for i in range(28): # 28명 기본으로 전체 순회
        input_user = input('입력 : ')
        if input_user == 'N' or input_user == 'n':
            break
        else:
            seoul_01_name_list_20F.append(input_user)

print(lunch_random_program())
