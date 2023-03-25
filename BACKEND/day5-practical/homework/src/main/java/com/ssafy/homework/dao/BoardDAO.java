package com.ssafy.homework.dao;

import com.ssafy.homework.vo.Board;

import java.util.ArrayList;

public interface BoardDAO {
    ArrayList<Board> selectAll();

    Board selectOne(String num);

    int insert(Board board);

    int delete(String num);

    void countUp(String num);
}
