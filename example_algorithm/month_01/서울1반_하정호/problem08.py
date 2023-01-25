# 함수 내부에 불필요한 print문이 있는 경우 오답으로 처리가 됩니다.
def caesar(word, n):
    pass
    # 여기에 코드를 작성"하여 함수를 완성합니다.
    # A: 65 ~ Z: 90 // a: 97 ~ z: 122
    # n > 0, 양의 정수

    # 1. word를 문자별로 분해한 list로 변환
    # 2. 반환할 caesar_word 변수 준비
    # 3. `1`의 리스트를 순회
        # 3-1. 해당 문자가 대문자인지, 소문자인지 파악
        # 3-2. 해당 문자를 int로 변환(ord)하고, n을 더함(밀어줌)
        # 3-3. n을 더했을 경우 소문자의 한계('z'), 혹은 대문자의 한계('Z')를 넘는 경우 처음으로 돌아감 ('a' 혹은 'A', 주의: 'a' 혹은 'A'값도 카운트)
    word_list = list(word)
    caesar_word = ''
    for c in word_list:
        if c.islower():
            i = ord(c) + n
            if i > 122:
                i = i - 122 + (97 - 1)
            caesar_word += chr(i)
        elif c.isupper():
            i  = ord(c) + n
            if i > 90:
                i = i - 90 + (65 - 1)
            caesar_word += chr(i)
    return caesar_word
    


# 아래의 코드를 수정하거나 새롭게 추가하지 않습니다.
########## 코드 변경 금지 ############
if __name__ == '__main__':
    print(caesar('apple', 5))      # fuuqj
    print(caesar('ssafy', 1))      # ttbgz
    print(caesar('Python', 10))    # Zidryx