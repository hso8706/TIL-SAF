package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		Car c = (Car) context.getBean("avante");
//		System.out.println(c.getClass().getName()); //출력: com.sun.proxy.$Proxy5
		
		c.setColor("red"); //before
		System.out.println();
		
		System.out.println(c.getColor()); //after
		System.out.println();
		
		c.go(99);
	}
}