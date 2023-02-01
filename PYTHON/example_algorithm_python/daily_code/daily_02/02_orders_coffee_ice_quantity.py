orders = '아이스아메리카노,카라멜마키야또,에스프레소,아메리카노,아메리카노,아이스라떼,핫초코,아이스아메리카노,아메리카노,아이스카라멜마키야또,아이스라떼,라떼마키야또,카푸치노,라떼마키야또'

# 1. 아이스 음료 잔 수 확인
# '아이스'가 주어진 문자열에 포함되어 있는지 확인 or [:3] 슬라이싱 이용
def how_many_ice(orders):
    orders_list = orders.split(',')
    ice_cnt = 0
    for coffee in orders_list:
        if '아이스' in coffee: ice_cnt += 1
    return ice_cnt

# 2. 메뉴 별 주문 수 확인
# dict 형을 이용하여 커피 이름을 key로, 갯수를 value로 설정
def how_many_coffee(orders):
    orders_list = orders.split(',')
    order_coffee = {}
    for coffee in orders_list:
        if coffee in order_coffee:
            order_coffee[coffee] += 1
        else:
            order_coffee[coffee] = 1
    return order_coffee


print(how_many_ice(orders))
print(how_many_coffee(orders))