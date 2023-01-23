# 혈액형의 종류 = key, 종류별 사람 수 = values\

def blood_type_dict(list_blood):
    dict_blood = {}
    for blood_type in sorted(list_blood): # 보기좋게 추가로 sorted()함수 사용. 정렬된 리스트를 반환하는 함수
        if blood_type in dict_blood.keys():
            dict_blood[blood_type] += 1
        else:
            dict_blood[blood_type] = 1
    return dict_blood

blood_types = [ 'A','A','O', 'B', 'A', 'O', 'AB','O', 'A', 'B', 'O', 'B', 'AB']
print(blood_type_dict(blood_types))
