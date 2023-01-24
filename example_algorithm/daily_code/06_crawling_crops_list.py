grain_lst = [('고구마',3000), ('감자',2000), ('옥수수',4500),('토란',1300)]

def crawling_crops_list(crops_list):
    crops_dict = {}
    for crop in crops_list:
        crops_dict[crop[0]] = crop[1]
    
    top_price = 0
    for crop_price in crops_dict.values():
        if top_price < crop_price:
            top_price = crop_price
    for crop_name in crops_dict.keys():
        if crops_dict[crop_name] == top_price:
            return crop_name
    return '작물 목록을 입력하여 주십시오.'

print(crawling_crops_list(grain_lst))
