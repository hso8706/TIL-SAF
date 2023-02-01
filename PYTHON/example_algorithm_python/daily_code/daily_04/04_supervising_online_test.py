# cheating 상태의 멤버를 dictionary에서 삭제하고 따로 리스트로 반환할 것(오름차순)
def supervisiong_online_test(test_status):
    result_dict = {}
    cheating_list = []
    result_status = test_status.copy() # 에러 해결 지점
    for key in test_status.keys():
        if test_status[key] == 'cheating':
            cheating_list.append(key)
            result_status.pop(key)
        elif test_status[key] == 'sleeping':
            result_status[key] = 'solving'
    cheating_list.sort()

    result_dict['cheating_list'] = cheating_list
    result_dict['result_status'] = result_status

    return result_dict


test_status = {
    '김코딩' : 'solving',
    '이싸피' : 'solving',
    '최어썬' : 'cheating',
    '오디비' : 'sleeping',
    '임온실' : 'cheating',
    '조실습' : 'solving',
    '박장고' : 'sleeping',
    '염자바' : 'cheating'
}

revised_test_status = supervisiong_online_test(test_status)
print(revised_test_status['cheating_list']) # ['염자바', '임온실', '최어썬']
print(revised_test_status['result_status']) # {'김코딩': 'solving', '이싸피': 'solving', '오디비': 'solving', '조실습': 'solving', '박장고': 'solving'}
