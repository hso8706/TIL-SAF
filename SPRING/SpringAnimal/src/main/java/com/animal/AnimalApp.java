package com.animal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("animal.xml");
		
		Zoo seoul = context.getBean("seoul", Zoo.class);
		Zoo london = context.getBean("london", Zoo.class);
		
		seoul.info();
		System.out.println("---------------------------------------");
		london.info();
	}
}
