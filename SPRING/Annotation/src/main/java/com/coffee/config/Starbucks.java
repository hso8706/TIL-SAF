package com.coffee.config;

import org.springframework.beans.factory.annotation.Autowired;

public class Starbucks implements CoffeeShop{
	/*
	 * @Autowired
	 * : 자동 주입
	 * : 컨테이너에 의해 생성된 객체 중 타입이 동일한 객체를 자동으로 주입시켜 줌
	 * : 
	 */
	
	@Autowired
	Americano ame;
	@Autowired
	CaffeLatte latte;

	public Starbucks(Americano ame, CaffeLatte latte) {
		super();
		this.ame = ame;
		this.latte = latte;
	}

	@Override
	public void info() {
		ame.info();
		latte.info();
	}
}