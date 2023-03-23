package com.mvc.service;

import java.util.ArrayList;

import com.mvc.dao.BoardDAO;
import com.mvc.dao.BoardDAOImpl;
import com.mvc.vo.Board;

//Controller에서 넘어온 요청을 처리하는 객체 =>DAO객체에 전달해서 결과를 받음
//BoardService에서 선언한 추상 메소드의 내용을 실제 완성해 놓은 클래스
public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao;//interface type
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}	

	@Override
	public ArrayList<Board> selectAll() {		
		return dao.selectAll();
	}

	@Override
	public Board selectOne(String num) {
		dao.countUp(num);
		return dao.selectOne(num);
	}

	@Override
	public int insert(Board b) {		
		return dao.insert(b);
	}

	@Override
	public int delete(String num) {
		return dao.delete(num);
	}

}
