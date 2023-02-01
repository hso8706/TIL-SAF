# 함수 내부에 불필요한 print문이 있는 경우 오답으로 처리가 됩니다.
def is_position_safe(N, M, position):
    pass
    # 여기에 코드를 작성하여 함수를 완성합니다.
    # (x, y) : 0 <= x < 100, 0 <= y < 100
    # N * N 평면 : 0 < N <= 100
    # 상, 하, 좌, 우 => 0, 1, 2, 3
    # 0: x=-1, y=0
    # 1: x=1, y=0
    # 2: x=0, y=-1
    # 3: x=0, y=1
    # 3번 인자 default position

    # 1. M에 따라 변화하게 될 값을 설정
    # 2. position(tuple)을 position(list)로 변경
    # 3. 변경된 position이 N*N 필드, 즉 0 혹은 N-1을 초과하는지 파악
    # 4. `3`에 따라서 True, False 반환
    if M == 0:
        x = -1
        y = 0
        moved_position = list(position)
        moved_position[0] += x
        moved_position[1] += y
        if moved_position[0] < 0 or moved_position[0] > (N-1) or moved_position[1] < 0 or moved_position[1] > (N-1):
            return False
        else: return True
    elif M == 1:
        x = 1
        y = 0
        moved_position = list(position)
        moved_position[0] += x
        moved_position[1] += y
        if moved_position[0] < 0 or moved_position[0] > (N-1) or moved_position[1] < 0 or moved_position[1] > (N-1):
            return False
        else: return True
    elif M == 2:
        x = 0
        y = -1
        moved_position = list(position)
        moved_position[0] += x
        moved_position[1] += y
        if moved_position[0] < 0 or moved_position[0] > (N-1) or moved_position[1] < 0 or moved_position[1] > (N-1):
            return False
        else: return True
    elif M == 3:
        x = 0
        y = 1
        moved_position = list(position)
        moved_position[0] += x
        moved_position[1] += y
        if moved_position[0] < 0 or moved_position[0] > (N-1) or moved_position[1] < 0 or moved_position[1] > (N-1):
            return False
        else: return True
    return None



# 아래의 코드를 수정하거나 새롭게 추가하지 않습니다.
########## 코드 변경 금지 ############
if __name__ == '__main__':
    print(is_position_safe(3, 1, (0, 0)))  # True
    print(is_position_safe(3, 0, (0, 0)))  # False
