# 숫자의 의미
# chr(): int -> char
# ord(): char -> int

def get_secret_word(lst):
    str = ""
    for i in lst:
        str += chr(i)
    return str

print(get_secret_word([83, 115, 65, 102, 89]))
print(get_secret_word([72, 97, 112, 112, 89]))