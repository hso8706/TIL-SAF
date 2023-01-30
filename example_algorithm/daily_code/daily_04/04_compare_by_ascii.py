def compare_by_ascii(str1, str2):
    str1_to_ascii = 0
    str2_to_ascii = 0

    for c in str1:
        str1_to_ascii += ord(c)
    for c in str2:
        str2_to_ascii += ord(c)
    
    return str1 if str1_to_ascii > str2_to_ascii else str2

word1 = input('첫 번째 이름을 입력하세요 : ')
word2 = input('두 번째 이름을 입력하세요 : ')
print(compare_by_ascii(word1, word2))