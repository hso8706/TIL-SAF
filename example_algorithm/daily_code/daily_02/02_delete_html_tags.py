# 입력된 문자열에서 html tag를 지우자.
# html tag는 문자열 양측에 공백없이 붙어있고, 왼쪽 태그는 `<p>`이고 오른쪽 태그는 `</p>`이다.
input_str = "<p>입력된 html 코드입니다.</p>"
print(input_str[3: -4])