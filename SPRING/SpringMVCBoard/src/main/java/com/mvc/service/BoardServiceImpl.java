package com.mvc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.BoardDAO;
import com.mvc.dao.BoardDAOImpl;
import com.mvc.vo.Board;

@Service //@Component도 되지만 세분화하기 위함
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;//interface type

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
