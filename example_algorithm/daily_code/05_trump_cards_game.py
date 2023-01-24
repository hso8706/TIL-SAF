import random
# 전체 카드 목록을 만드는 함수
def making_card_list() -> list:
	card_list = []

	for shape in ["spade", "heart", "diamond", "clover"]:

		for number in ["A", 2, 3, 4, 5, 6, 7, 8, 9, 10, "J", "Q", "K"]:

			card_list.append((shape, number))

	return card_list

# 카드 목록을 받고, 카드 목록을 섞은 후 2장의 카드를 뽑아 반환하는 함수
def play_game(trump_card_list):
    player1_won_cnt = 0
    player2_won_cnt = 0
    while player1_won_cnt < 6 and player2_won_cnt < 6:
        random.shuffle(trump_card_list) # random 모듈을 통해 card_list를 섞음
        player_1 = trump_card_list.pop() # 섞은 것 중에 마지막 카드(제일 위에 놓인 카드라고 가정)를 뽑음
        player_2 = trump_card_list.pop()
        players_dict = {'player_1' : player_1, 'player_2' : player_2}

    # 카드에 적힌 수를 대소 비교해서 승부를 가르는 부분 <- 함수에서 수정
        shape_dict = {'clover' : 1, 'heart' : 2, 'diamond' : 3, 'spade' : 4}
        score_dict = {'J' : 11, 'Q' : 12, 'K': 13, 'A': 14}
        shape_01 = players_dict['player_1'][0]
        shape_02 = players_dict['player_2'][0]
        score_01 = players_dict['player_1'][1]
        score_02 = players_dict['player_2'][1]
        for key in shape_dict.keys():
            if shape_01 == key:
                shape_01 = shape_dict[key]
            if shape_02 == key:
                shape_02 = shape_dict[key]
        
        for key in score_dict.keys():
            if score_01 == key:
                score_01 = score_dict[key]
            if score_02 == key:
                score_02 = score_dict[key]
        
        if score_01 > score_02:
            print(f'{players_dict["player_1"]}', f'{players_dict["player_2"]}', 'player1 win!')
            player1_won_cnt += 1
        elif score_01 < score_02:
            print(f'{players_dict["player_1"]}', f'{players_dict["player_2"]}', 'player2 win!')
            player2_won_cnt += 1
        else:
            if shape_01 > score_02:
                print(f'{players_dict["player_1"]}', f'{players_dict["player_2"]}', 'player1 win!')
                player1_won_cnt += 1
            elif shape_01 < shape_02:
                print(f'{players_dict["player_1"]}', f'{players_dict["player_2"]}', 'player2 win!')
                player2_won_cnt += 1
            else: 
                print(f'{players_dict["player_1"]}', f'{players_dict["player_2"]}', 'draw!')
    print(f'{player1_won_cnt}:{player2_won_cnt} Finally {"player1" if player1_won_cnt > player2_won_cnt else "player2"} win')

trump_card_list = making_card_list()
play_game(trump_card_list)