package com.aop.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		Board board = (Board) context.getBean("board");
		
		System.out.println(board.read(99));
		System.out.println();
		
		board.write("남남곤곤");
		System.out.println();
		
		board.delete(99);
		System.out.println();
	}
}
