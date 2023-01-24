# count_vowels('apple') #=> 2
# count_vowels('banana') #=> 3

def count_vowels(str):
    vowels_list = ['a', 'e', 'i', 'o', 'u']
    vowel_cnt = 0
    for c in str:
        if c in vowels_list:
            vowel_cnt += 1
    
    return vowel_cnt

print(count_vowels('apple')) # 2
print(count_vowels('banana')) # 3