# 1. 앞뒤로 붙은 특수 문자 제거 => 아스키코드 
# 2. 첫 문자를 제외한 모든 문자 소문자

# 입력 예시
# s = '@#~I NeVEr DrEamEd AbouT SuCCeSs, i woRkEd foR iT.!>!'
# 출력 예시
# 'I never dreamed about success, i worked for it.'

# 1. 
# print(ord('a'), ord('A'), ord('z'), ord('Z'))
# A ~ Z, a~ z : 65 ~ , ~ 122
# '.' 은 제외할 것, '.' : 46

s_01 = '@#~I NeVEr DrEamEd AbouT SuCCeSs, i woRkEd foR iT.!>!'

def clean_string(str):
    start = 0
    end = 0
    for i in range(len(str)):
        if ord(str[i]) >= 65 and ord(str[i]) <= 122:
            start = i
            break
    for i in range(len(str)-1, -1, -1):
        # if ord(str[i]) >= 65 and ord(str[i]) <= 122:
        if ord(str[i]) == 46:
            end = i
            break
    return_str = str[start: end+1]
    return_str = return_str[0] + return_str[1:].lower()
    return return_str
    
print(clean_string(s_01))