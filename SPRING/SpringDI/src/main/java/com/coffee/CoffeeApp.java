package com.coffee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//ClassPathXmlApplicationContext
//: ~~ApplicationContext == Container라는 뜻
//: ClassPath로 지정된 위치에서 xml 문서를 읽어와서 객체를 생성해 주는 컨테이너
//ClassPath 위치란 : src/main/resources를 의미
public class CoffeeApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("coffee.xml"); //CPXAC
//		Coffee cof = context.getBean("ame1", Coffee.class); //id, type 제공, return은 interface type으로 받을 것
//		Coffee cof2 = context.getBean("latte1", Coffee.class);
//
//		cof.info();
//		System.out.println();
//		cof2.info();
		
		CoffeeShop star = context.getBean("star", CoffeeShop.class);
		CoffeeShop bean = context.getBean("bean", CoffeeShop.class);
		star.info();
		System.out.println("---------------------------------------");
		bean.info();
	}
}
