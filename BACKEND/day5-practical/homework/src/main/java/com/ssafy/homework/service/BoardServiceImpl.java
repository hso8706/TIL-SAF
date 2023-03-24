package com.ssafy.homework.service;

import com.ssafy.homework.dao.BoardDAO;
import com.ssafy.homework.dao.BoardDAOImpl;
import com.ssafy.homework.vo.Board;

import java.util.ArrayList;

public class BoardServiceImpl implements BoardService{
    BoardDAO dao;

    public BoardServiceImpl() {
        dao = new BoardDAOImpl();
    }

    @Override
    public ArrayList<Board> selectAll() {
        return dao.selectAll();
    }

    @Override
    public Board selectOne(String num) {
        return dao.selectOne(num);
    }

    @Override
    public int insert(Board board) {
        return dao.insert(board);
    }
}
