words_dict = {'proper' : '적절한',
'possible' : '가능한',
'moral' : '도덕적인',
'patient' : '참을성 있는',
'balance' : '균형',
'perfect' : '완벽한',
'logical' : '논리적인',
'legal' : '합법적인',
'relevant' : '관련 있는',
'responsible' : '책임감 있는',
'regular' : '규칙적인'}

def create_antonym(words_dict):
    antonym_list_sorted = []
    for word in words_dict.keys():
        if word[0] == 'b' or word[0] == 'm' or word[0] == 'p':
            antonym_str = 'im' + word
            antonym_list_sorted.append(antonym_str)
        elif word[0] == 'l':
            antonym_str = 'il' + word
            antonym_list_sorted.append(antonym_str)
        elif word[0] == 'r':
            antonym_str = 'ir' + word
            antonym_list_sorted.append(antonym_str)
        else:
            antonym_str = 'in' + word
            antonym_list_sorted.append(antonym_str)
    antonym_list_sorted.sort()
    return antonym_list_sorted

print(create_antonym(words_dict))
