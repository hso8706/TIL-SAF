str_lst = input('문자열을 입력하세요. : ')
str_blank_split = str_lst.split(' ')
checker = True
if len(str_blank_split) <= 1: checker = True
else : 
    for i in range(1, len(str_blank_split)):
        if str_blank_split[i-1][len(str_blank_split[i-1])-1].upper() != str_blank_split[i][0].upper():
            checker = False
            break
print('PASS') if checker == True else print('FAIL')