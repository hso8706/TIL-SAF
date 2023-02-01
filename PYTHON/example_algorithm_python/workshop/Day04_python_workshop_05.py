# ASCII 코드 이용하기
# chr() : int to str
# ord() : str to int

def get_secret_word(lst):
    str_for_return = ""
    for i in lst:
        str_for_return += chr(i)
    return str_for_return

print(get_secret_word([83, 115, 65, 102, 89]))