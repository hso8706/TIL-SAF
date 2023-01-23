# string 형식으로 삼각형의 세 변의 길이를 제공받는다.
# 삼각형이라는 조건 내에서 삼각형의 종류를 판별할 수 있는 조건문 작성
# 직각 이등변 삼각형은 특별 케이스로 만듬
# 1. 삼각형인지 판단
# 2. 정삼각형인지 판단
# 3. 이등변 삼각형인지 판단 -> 변의 길이 리스트를 오름차순 정렬하여 케이스 줄이기
# 3-1. 직각 판단(피타고라스)
# 4. 직각 판단(피타고라스)

def what_kind_of_triangle(str_lengs):
    list_length = list(map(int, str_lengs.split(',')))
    list_length.sort() # 세 변의 길이 오름차순으로 정렬
    if list_length[0] + list_length[1] >= list_length[2]:
        if list_length[0] == list_length[1] and list_length[1] == list_length[2]:
            return '정삼각형입니다.'
        elif (list_length[0] == list_length[1] and list_length[1] != list_length[2]):
            if (list_length[0] ** 2) + (list_length[1] ** 2) == (list_length[2] ** 2):
                return '직각 이등변 삼각형입니다.'
            else:
                return '이등변 삼각형입니다.'
        elif (list_length[0] ** 2) + (list_length[1] ** 2) == (list_length[2] ** 2):
            return '직각 삼각형입니다.'
        else:
            return '삼각형입니다.'
    else:
        return '삼각형이 아닙니다.'

t_exam_1 = '5,3,4'
t_exam_2 = '5,5,10'
t_exam_3 = '5,5,5'
t_exam_4 = '4,5,6'

print(what_kind_of_triangle(t_exam_1))
print(what_kind_of_triangle(t_exam_2))
print(what_kind_of_triangle(t_exam_3))
print(what_kind_of_triangle(t_exam_4))