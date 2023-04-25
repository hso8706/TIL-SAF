package com.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.mapper.BoardMapper;
import com.mvc.vo.Board;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper dao;
	
	@Override
	public ArrayList<Board> selectAll() throws Exception{		
		return dao.selectAll();
	}

	@Override
	public Board selectOne(String num)throws Exception {
		dao.countUp(num);
		Board b = dao.selectOne(num);
		return b;
	}

	@Override
	public void insert(Board b) throws Exception{
		dao.insert(b);		
	}

	@Override
	public void delete(String num) throws Exception{
		dao.delete(num);
	}
	
	@ExceptionHandler(MysqlDataTruncation.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView mnv = new ModelAndView();
		System.out.println(ex.getClass().getName());
		// if (e instanceof ArithmeticException) { }
		mnv.addObject("msg", "do well!!!3333");
		mnv.setViewName("error/error");
		return mnv;
	}

	@Override
	public void modify(Board b) throws Exception {
		dao.modify(b);
	}

	@Override
	@Transactional
	public void txtest() throws Exception {
		dao.test();
		dao.test();
	}

	@Override
	public ArrayList<Board> search(String condition, String word) throws Exception {
		Map<String, String> map = new HashMap();
		map.put("condition", condition);
		map.put("word", word);
		return dao.search(map);
	}
	

}
