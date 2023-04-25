package com.mvc.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.mvc.vo.Board;


public interface BoardMapper {
	public ArrayList<Board> selectAll()throws SQLException;
	public Board selectOne(String num)throws SQLException;
	public void insert(Board b)throws SQLException;
	public void delete(String num)throws SQLException;
	public void countUp(String num)throws SQLException;
	public void modify(Board b)throws Exception;
	public void test() throws Exception;
	public ArrayList<Board> search(Map<String, String> map) throws Exception;
}
