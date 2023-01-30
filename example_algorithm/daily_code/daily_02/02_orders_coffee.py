orders = '아이스아메리카노,카라멜마키야또,에스프레소,아메리카노,아메리카노,아이스라떼,핫초코,아이스아메리카노,아메리카노,아이스카라멜마키야또,아이스라떼,라떼마키야또,카푸치노,라떼마키야또'

def order_coffee(orders):
    list_order = orders.split(',') # 문자열로 제공되는 커피 목록 리스트를 리스트로 변환
    total_cups = len(list_order) # 총 커피 갯수 == list_order의 길이
    coffee_without_rep = [] # 중복 커피 메뉴를 제거하여 구성될 리스트, 빈 리스트 생성
    for coffee in list_order:
        if coffee not in coffee_without_rep:
            coffee_without_rep.append(coffee)
    coffee_without_rep.sort(reverse=True)
    return [total_cups, coffee_without_rep]

print_list = order_coffee(orders)
print('총 주문한 커피 수량 : ', print_list[0])
print('중복을 제거한 커피 주문 리스트 : ', print_list[1])