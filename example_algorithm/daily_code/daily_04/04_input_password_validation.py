# 비밀번호 유효성 판단
# 3회 이상 틀리면 입력 기회 종료

def input_password_validaton(pwd):
    for i in range(3):
        user_input = input('패스워드를 입력하여 주십시오.: ')
        if user_input == pwd:
            print('올바른 패스워드를 입력하셨습니다.')
            return True
        else: 
            print('틀린 패스워드를 입력하셨습니다. 다시 입력하여 주십시오.')
    print('비밀번호 입력을 세 번 틀리셨습니다.\n 종료')
    return False

pwd = 'qlalfqjsgh1234'
input_password_validaton(pwd)