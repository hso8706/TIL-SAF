# 과일명이 나열된 문자열을 입력받는다. 콤마(,)로 구분
# rotten이라는 문자열이 있는 과일을 rotten이 없는 과일명으로 바꾼다.
# 과일명과 rotten 문자열은 대소문자가 랜덤하게 섞여있고, 모두 소문자인 문자열 단어로 반환한다.
# 과일명을 리스트 형식으로 반환한다.

def rotten_to_fresh(fruits_bag):
    all_fruits = fruits_bag.lower().split(',')
    fresh_fruits = []
    for fruit in all_fruits:
        if 'rotten' in fruit:
            fresh_fruits.append(fruit[6:])
        else:
            fresh_fruits.append(fruit)
    return fresh_fruits

fruits_bag = 'apple,rottenBanana,apple,RoTTenorange,Orange'
print(rotten_to_fresh(fruits_bag))