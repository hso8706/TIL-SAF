# 가장 많이 입장한 top 3 뽑기
# 입장 횟수와 퇴장 횟수가 차이나는 사람 뽑기
# collections의 Counter 객체 사용

from collections import Counter
# collections 모듈의 Counter 객체 사용하기
# Counter의 생성자에 인자로 list, string을 제공하면 해당 요소는 key, 요소가 등장한 횟수는 value값인 dictionary 형태로 변환된다. (list, string 외에는 뭐가 더 있는지 파악 안 함.)
# Counter.most_common() : 데이터의 등장 횟수에 대해 내림차순으로 Counter 객체 요소를 정렬한다. 반환값은 key-value를 쌍으로 하는 tuple을 요소로 갖는 list이다.

entry_record = ['이싸피', '박장고', '조실습', '이싸피', '조실습', '오디비', '임온실', '조실습', '조실습', '이싸피', '안도둑', '임온실', '최이썬', '오디비', '안도둑', '염자바', '박장고', '조실습',
                '최이썬', '조실습', '염자바', '박장고', '임온실', '임온실', '이싸피', '임온실', '오디비', '조실습', '염자바', '임온실', '박장고', '최이썬', '안도둑', '염자바', '임온실', '박장고', '이싸피', '안도둑',
                '임온실', '오디비', '최이썬', '안도둑', '이싸피', '오디비', '안도둑', '이싸피', '박장고', '박장고', '안도둑', '안도둑', '안도둑', '염자바', '최이썬', '오디비', '오디비', '최이썬', '이싸피', '임온실', '안도둑']

exit_record = ['최이썬', '조실습', '이싸피', '안도둑', '임온실', '안도둑', '이싸피', '오디비', '염자바', '박장고', '최이썬', '이싸피', '염자바', '염자바', '박장고', '임온실', '이싸피',
               '박장고', '안도둑', '염자바', '이싸피', '조실습', '조실습', '임온실', '박장고', '이싸피', '조실습', '박장고', '오디비', '안도둑', '조실습', '임온실', '안도둑', '안도둑', '임온실', '조실습', '최이썬', '안도둑', '임온실',
               '염자바', '이싸피', '임온실', '안도둑', '오디비', '안도둑', '오디비', '임온실', '염자바', '임온실', '박장고', '조실습', '이싸피', '최이썬', '최이썬', '오디비', '오디비', '염자바', '오디비', '안도둑', '박장고']

def top_3_in_entry_record(entry_record):
    counter = Counter(entry_record).most_common()
    return counter[:3]

def not_match_in_records(entry_record, exit_record):
    entry_counter = Counter(entry_record)
    exit_counter = Counter(exit_record)
    suspect = {}

    for key_entry in entry_counter.keys():
        if key_entry not in exit_counter.keys():
            suspect[key_entry] = entry_counter[key_entry]
        elif entry_counter[key_entry] != exit_counter[key_entry]:
            suspect[key_entry] = entry_counter[key_entry] - exit_counter[key_entry]
    for key_exit in exit_counter.keys():
        if key_exit not in exit_counter.keys():
            suspect[key_exit] = -1 * exit_counter[key_exit]
    
    return suspect

def print_not_match(entry_record, exit_record):
    suspect = not_match_in_records(entry_record, exit_record)
    for key in suspect.keys():
        if suspect[key] > 0:
            print(f'{key}은 입장 기록이 {suspect[key]}회 더 많아 수상합니다.')
        elif suspect[key] < 0:
            print(f'{key}은 퇴장 기록이 {suspect[key] * -1}회 더 많아 수상합니다.')

print('입장 기록 많은 Top3')
for i in top_3_in_entry_record(entry_record):
    print(*i) 

print('\n출입 기록이 수상한 사람')
print_not_match(entry_record, exit_record)

