package com.coffee.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//spring 설정 파일(xml)을 대신함.

@Configuration //@Configuration: spring 설정 파일임
public class CoffeeConfig {
	// bean 태그를 대신함, method명으로 id를 대신함
	// @Bean == <bean id="getAme" class="~">
	@Bean 
	public Americano getAme() {
		Americano ame= new Americano("kenya");
		ame.setPrice(4500);
		return ame;
	}
	
	@Bean
	public CaffeLatte getLatte() {
		CaffeLatte latte= new CaffeLatte("columbia");
		latte.setPrice(4500);
		return latte;
	}
	
	@Bean
	public Starbucks getStar() {
		Starbucks star = new Starbucks(getAme(), getLatte());
		return star;
	}
	@Bean
	public CoffeeBean getBean() {
		CoffeeBean bean = new CoffeeBean();
		bean.setAme(getAme());
		bean.setLatte(getLatte());
		return bean;
	}
}
