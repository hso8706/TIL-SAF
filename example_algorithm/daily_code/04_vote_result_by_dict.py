# 리스트로 주어진 투표 결과를 '이름':'투표수'의 형태의 dict로 반환하는 함수
def vote_result_list_by_dict(students):
    vote_result_list = {}
    for student in students:
        if student in vote_result_list.keys():
            vote_result_list[student] += 1
        else:
            vote_result_list[student] = 1
    return vote_result_list

# '이름':'투표수'의 형태의 dict를 인자로 받고, 이를 투표수-이름순으로 정렬하는 함수
def vote_result_rank(students):
    vote_result_bef_sort = vote_result_list_by_dict(students)
    vote_result_aft_sort = {}

    for votes in sorted(vote_result_bef_sort.values(), reverse=True):
        for student in sorted(vote_result_bef_sort.keys()):
            if vote_result_bef_sort[student] == votes:
                if student in vote_result_aft_sort.keys(): continue
                vote_result_aft_sort[student] = votes

    return vote_result_aft_sort

# 중복 키의 값이 할당될 경우, 새로운 키의 값으로 수정되는 문제
# def vote_result_rank(students):
#     vote_result_for_sort = {}
#     vote_result_for_rank = {}
#     for k, v in vote_result_list_by_dict(students).items(): # 문제 발생 지점
#         vote_result_for_sort[v] = k
#     for k in sorted(vote_result_for_sort.keys(), reverse=True):
#         vote_result_for_rank[vote_result_for_sort[k]] = k
#     return vote_result_for_rank

students = [
    '박해피',
    '이영희',
    '조민지',
    '조민지',
    '김철수',
    '이영희',
    '이영희',
    '김해킹',
    '박해피',
    '김철수',
    '한케이',
    '강디티',
    '조민지',
    '박해피',
    '김철수',
    '이영희',
    '박해피',
    '김해킹',
    '박해피',
    '한케이',
    '강디티'
]

print(vote_result_list_by_dict(students)) # {'박해피': 5, '이영희': 4, '조민지': 3, '김철수': 3, '김해킹': 2, '한케이': 2, '강디티': 2}
print(vote_result_rank(students)) # {'박해피': 5, '이영희': 4, '김철수': 3, '조민지': 3, '강디티': 2, '김해킹': 2, '한케이': 2}