package com.coffee.config;

public class CaffeLatte implements Coffee{
	int price;
	String origin;
	
	public CaffeLatte(String origin) {
		this.origin = origin;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void info() {
		System.out.println("가격: "+price);
		System.out.println("원산지: "+origin);
	}

}
