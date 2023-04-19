package com.animal;

public class Lion {
	int age;
	String name;
	String origin;
	
	public Lion(int age, String origin) {
		this.age = age;
		this.origin = origin;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void info() {
		System.out.println("Age: " + this.age);
		System.out.println("Name: " + this.name);
		System.out.println("Origin: " + this.origin);
	}
}
