package com.coffee;

public class Americano implements Coffee{
	//필드값에 주입이 필요함
	//1. 생성자 2. setter
	int price;
	String origin;
	
	//생성자를 통한 필드 주입
	public Americano(String origin) {
		this.origin = origin;
	}

	//setter를 통한 주입
	public void setPrice(int price) {
		this.price = price;
	}	
	
	public void info() {
		System.out.println("가격: "+price);
		System.out.println("원산지: "+origin);
	}

}
