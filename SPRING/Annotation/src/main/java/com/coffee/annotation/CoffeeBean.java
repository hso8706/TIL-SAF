package com.coffee.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("bean")
public class CoffeeBean implements CoffeeShop{
	@Autowired
	@Qualifier("ame2")
	Americano ame;
	
	@Autowired
	@Qualifier("latte2")
	CaffeLatte latte;


	@Override
	public void info() {
		ame.info();
		latte.info();
	
	}
}
