package com.mvc.service;

import java.util.ArrayList;

import com.mvc.vo.Board;


public interface BoardService {
	public ArrayList<Board> selectAll()throws Exception;
	public Board selectOne(String num)throws Exception;
	public void modify(Board b)throws Exception;
	public void insert(Board b) throws Exception;
	public void delete(String num)throws Exception;
	void txtest() throws Exception; //transaction test �뵵
	public ArrayList<Board> search(String condition, String word) throws Exception;
}
