package com.coffee.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * @Component
 * : bean 태그 대신에 사용하는 어노테이션
 * : 프로그램 실행 시 패키지를 검색하다가 해당 태그가 있는 클래스를 자동으로 bean 객체로 생성해줌
 * : xml문서의 <bean>태그를 대신하여 사용됨
 * : 인자로 주는 string 은 getBean 시 사용하는 id
 * : 인자로 주지 않는다면 class 이름(첫번재 글짜가 소문자인)이 default 값이다.
 */
@Component("star")
public class Starbucks implements CoffeeShop{
	/*
	 * @Autowired
	 * : 자동 주입
	 * : 컨테이너에 의해 생성된 객체 중 타입이 동일한 객체를 자동으로 주입시켜 줌
	 * : 타입 기준으로 자동 주입을 진행
	 */
	
	@Autowired
	@Qualifier("ame1") // Autowired가 타입을 기준으로 자동 주입을 시키는데, 같은 타입이 있을 경우 구분할 수 있게 해주는 애너테이션
	Americano ame;
	
	@Autowired
	@Qualifier("latte1")
	CaffeLatte latte;

	@Override
	public void info() {
		ame.info();
		latte.info();
	}
}