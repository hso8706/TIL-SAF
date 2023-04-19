package com.aop;

//Target: client가 호출할 메소드를 가지고 있음; 메소드 == 핵심 로직
public class Avante implements Car{
	String color;
	
	@Override
	public void setColor(String color) {
		System.out.println("setColor 호출");
		this.color = color;
	}

	@Override
	public String getColor() {
		System.out.println("getColor 호출");
		return color;
	}

	@Override
	public void go(int num) {
		System.out.println("go method call");
		System.out.println(++num);
	}
}