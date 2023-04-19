package com.coffee.config;

public class CoffeeBean implements CoffeeShop{
	Americano ame;
	CaffeLatte latte;
	
	public void setAme(Americano ame) {
		this.ame = ame;
	}

	public void setLatte(CaffeLatte latte) {
		this.latte = latte;
	}

	@Override
	public void info() {
		ame.info();
		latte.info();
	
	}
}
