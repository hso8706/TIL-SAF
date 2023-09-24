```json
{
		"message":"조회 성공"
		"data": {
			//자산 묶음
			"assets_bundle":{
					"total_assets": number,
					"total_investment": number,
					"profit_and_loss": number
			},
			//포트폴리오 묶음
			"portfolio_bundle":[{
					//노출 정보_기업
					"corporation_id": number,
					"corporation_name" : string,
					"industry_type" : string,
					"total_rank": number, // 등급으로 바꾸기 고려(server)
					"stock_close": number, // 주식 종가
					//비노출 정보_기업
					"stability_score": number, // 등급으로 바꾸기 고려(server)
					"growth_score": number, // 등급으로 바꾸기 고려(server)
					"profitability_score": number, // 등급으로 바꾸기 고려(server)
					"activity_score": number, // 등급으로 바꾸기 고려(server)
					//노출 정보_포트폴리오
					"stock_count": number,
					"average_price": number
			},
			...,
			{
				...
			}],
			//회원 포트폴리오 묶음
			"member_bundle":{
					//등급
					"total_portfolio_rank": number, // 등급으로 바꾸기 고려(server)
					"each_rank":{
							"S": number,
							"A+": number,
							...
							"C": number
					}
					//금액
					"total_assets": number,
					"each_assets":[{ // 내림차순
							"corporation_name" : string,
							"corporation_assets" : number
					},
					...,
					{
							"corporation_name" : string,
							"corporation_assets" : number
					}]
					//지표
					"portfolio_stability_score": number, // 등급으로 바꾸기 고려(server)
					"portfolio_growth_score": number, // 등급으로 바꾸기 고려(server)
					"portfolio_profitability_score": number, // 등급으로 바꾸기 고려(server)
					"portfolio_activity_score": number, // 등급으로 바꾸기 고려(server)
			}
		}
}
```