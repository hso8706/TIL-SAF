package com.ssafy.homework.service;

import com.ssafy.homework.vo.Board;

import java.util.ArrayList;

public interface BoardService {
    ArrayList<Board> selectAll();

    Board selectOne(String num);

    int insert(Board board);
}
