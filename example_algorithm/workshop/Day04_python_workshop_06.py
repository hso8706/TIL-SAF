# ASCII 코드 이용하기
# chr() : int to str
# ord() : str to int

def get_secret_number(str):
    return sum(list(map(ord, str)))

print(get_secret_number('happy'))