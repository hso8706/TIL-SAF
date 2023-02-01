# 애너그램 : 사용된 문자는 같지만, 순서를 다르게 한 단어들, 어구전철
# - 리스트의 요소인 단어들을 분해하여 각각의 문자와 문자 갯수 쌍으로 이루어진 dictionary로 만든다.
# - 해당 dict의 리스트를 만든다.

words = ["eat", "tea", "tan", "ate", "nat", "bat"]
words_02 = ["gag", "teg", "gga", "agg", "get", "bbc", "teg", "ccb"]
# dictionary 이용
def anagram(words):
    char_dict_list = []
    anagram_list = []
    for str in words:
        temp_dict = {}
        for c in str:
            if c in temp_dict:
                temp_dict[c] += 1
            else:
                temp_dict[c] = 1
        char_dict_list.append(temp_dict)

    for words_idx in range(len(words)):
        temp_list = []
        for char_idx in range(len(char_dict_list)):
            if char_dict_list[words_idx] == char_dict_list[char_idx]:
                temp_list.append(words[char_idx])
        if temp_list not in anagram_list:
            anagram_list.append(temp_list)
    return anagram_list

# list와 string 이용
def group_anagrams(arrList):
    resultStrList = []
    sortedStrList = []
    for s in arrList:
        sortedStrList.append("".join(sorted(s)))
    for i in range(len(sortedStrList)):
        tempStrList = []
        if arrList[i] != "":
            tempStrList.append(arrList[i])
            for j in range(i+1, len(sortedStrList)):
                if sortedStrList[j] == sortedStrList[i]:
                    tempStrList.append(arrList[j])
                    arrList[j] = ""
            resultStrList.append(tempStrList)
    return resultStrList

print(anagram(words)) # [['eat', 'tea', 'ate'], ['tan', 'nat'], ['bat']]
print(anagram(words_02)) # [['gag', 'gga', 'agg'], ['teg', 'get', 'teg'], ['bbc'], ['ccb']]
print(group_anagrams(words)) # [['eat', 'tea', 'ate'], ['tan', 'nat'], ['bat']]
print(group_anagrams(words_02)) # [['gag', 'gga', 'agg'], ['teg', 'get', 'teg'], ['bbc'], ['ccb']]