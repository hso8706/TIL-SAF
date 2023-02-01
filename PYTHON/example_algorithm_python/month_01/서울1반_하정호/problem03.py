# 함수 내부에 불필요한 print문이 있는 경우 오답으로 처리가 됩니다.
def is_good_rate(movie):
    pass
    # 여기에 코드를 작성하여 함수를 완성합니다.

    # movie에서 "user_rating"의 value를 호출하여 해당 값과 8.0과 비교
    if movie["user_rating"] >= 8.0: # movie["user_rating"]이 8.0 이상인 경우, True 반환
        return True
    else: return False # movie["user_rating"]이 8.0 미만인 경우, False 반환


# 아래의 코드를 수정하거나 새롭게 추가하지 않습니다.
########## 코드 변경 금지 ############
if __name__ == '__main__':
    movie = {
            "id": 1,
            "user_rating": 8.1,
            "title": "그리고 내일",
            "overview": "과거보다 더 성장한 당신은 드디어 꿈을 이루게 된다.",
        }

    print(is_good_rate(movie))  # True