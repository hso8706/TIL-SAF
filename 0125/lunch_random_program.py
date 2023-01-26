'''
고려사항(우선)
- 사용자 입력 받기 (한 명 씩 입력)
- 10층, 20층 구분
- 층 별로 인원수가 딱 떨어지는 숫자로 조 편성(3,4,5 중 하나)
- 딱 떨어지지 않을 경우 4명 조를 기본으로하고 나머지 편성 => 특정 경우 나머지가 1명이 되는데, 1명은 팀 선택 특권(사실 이렇게 안하면 하드코딩이 될 듯하여 패스 - 모든 소수 경우의 수)
- 프로그램 사용자 기록 남기기 => reward 시스템 적용 => txt 파일로 뿜자(Database로 사용)

고려사항(확장용)
- 일정 카테고리로 정렬된 dict로 value값을 삼으면 좀 더 성향에 맞는 사람끼리 주선도 할 수 있을 것 같다. => 하지만 랜덤 프로그램이라는 목적이 희미해질듯.
- 하나의 함수에 모든 기능이 다있음. 리팩토링 필요

수정 필요
- 오입력에 대한 처리 필요
'''
import random # random 모듈 사용 : 임의 수 사용을 위함
import json # dict to str, str to dict => 현재는 eval로 사용

def lunch_random_program():
    
    read_file = open("C:/Users/SSAFY/Desktop/TIL-SAF/0125/database.txt", "r", encoding='UTF8')
    seoul_01_data = eval(read_file.read()) # eval 알아보기, json 모듈 사용할 생각해보기
    read_file.close()
    
    write_file = open("C:/Users/SSAFY/Desktop/TIL-SAF/0125/database.txt", "w", encoding='UTF8')

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
            seoul_01_data[input_user] += 1
    write_file.write(str(seoul_01_data))
    write_file.close()

            
            
    num_of_people = len(seoul_01_name_list_10F)
    random.shuffle(seoul_01_name_list_10F)
    if num_of_people % 3 == 0:
        seoul_01_name_list_10F_random = [seoul_01_name_list_10F[i:i+3] for i in range(0, len(seoul_01_name_list_10F), 3)]
    elif num_of_people % 4 == 0:
        seoul_01_name_list_10F_random = [seoul_01_name_list_10F[i:i+4] for i in range(0, len(seoul_01_name_list_10F), 4)]
    elif num_of_people % 5 == 0:
        seoul_01_name_list_10F_random = [seoul_01_name_list_10F[i:i+5] for i in range(0, len(seoul_01_name_list_10F), 5)]
    else:
        seoul_01_name_list_10F_random = [seoul_01_name_list_10F[i:i+4] for i in range(0, len(seoul_01_name_list_10F), 4)]
    print(seoul_01_name_list_10F_random)


    print("=======================20층 희망자=======================")
    print("이름을 입력하여 주십시오. 입력을 종료하려면 'N' 또는 'n'을 입력하여 주십시오.")
    for i in range(28): # 28명 기본으로 전체 순회
        input_user = input('입력 : ')
        if input_user == 'N' or input_user == 'n':
            break
        else:
            seoul_01_name_list_20F.append(input_user)

    num_of_people = len(seoul_01_name_list_20F)
    random.shuffle(seoul_01_name_list_20F)
    if num_of_people % 3 == 0:
        seoul_01_name_list_20F_random = [seoul_01_name_list_20F[i:i+3] for i in range(0, len(seoul_01_name_list_20F), 3)]
    elif num_of_people % 4 == 0:
        seoul_01_name_list_20F_random = [seoul_01_name_list_20F[i:i+4] for i in range(0, len(seoul_01_name_list_20F), 4)]
    elif num_of_people % 5 == 0:
        seoul_01_name_list_20F_random = [seoul_01_name_list_20F[i:i+5] for i in range(0, len(seoul_01_name_list_20F), 5)]
    else:
        seoul_01_name_list_20F_random = [seoul_01_name_list_20F[i:i+4] for i in range(0, len(seoul_01_name_list_20F), 4)]
    print(seoul_01_name_list_20F_random)

print(lunch_random_program())

