package com.coffee;

public class Starbucks implements CoffeeShop{
	//주입을 받아야 됨
	Americano ame;
	CaffeLatte latte;
	
	public Starbucks(Americano ame, CaffeLatte latte) {
		this.ame = ame;
		this.latte = latte;
	}

	@Override
	public void info() {
		ame.info();
		latte.info();
	}
}