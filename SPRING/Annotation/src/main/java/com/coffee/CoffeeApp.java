package com.coffee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//ClassPathXmlApplicationContext
//: ~~ApplicationContext == Container라는 뜻
//: ClassPath로 지정된 위치에서 xml 문서를 읽어와서 객체를 생성해 주는 컨테이너
//ClassPath 위치란 : src/main/resources를 의미
public class CoffeeApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("coffeeAnnotation.xml"); //CPXAC
		
		CoffeeShop star = context.getBean("star", CoffeeShop.class);
		CoffeeShop bean = context.getBean("bean", CoffeeShop.class);
		star.info();
		System.out.println("---------------------------------------");
		bean.info();
	}
}
