package com.mvc.dao;

import com.mvc.vo.Board;

import java.util.ArrayList;

//클라리언트(Service)에 서비스 할 내용으로 메소드 선언
//Service 가 이용 가능한 메소드 목록
public interface BoardDAO {
    ArrayList<Board> selectAll(); // 모든 글 목록
    Board selectOne(String num); // 해당 번호의 글 한 개
    int insert(Board b); // 새 글 등록
    int delete(String num); // 해당 번호의 글 삭제

    int countUp(String num);
}
