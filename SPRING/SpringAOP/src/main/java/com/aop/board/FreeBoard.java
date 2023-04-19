package com.aop.board;

//Target
public class FreeBoard implements Board{

	@Override
	public String read(int num) {
		return "read: " + num;
	}

	@Override
	public void delete(int num) {
		System.out.println("deleted: " + num);
	}

	@Override
	public void write(String content) {
		System.out.println("write: " + content);
	}
	
}
