package com.mvc.service;

import java.util.ArrayList;

import com.mvc.vo.Board;

//클라이언트(Controller)에 서비스 할 내용으로 메소드 선언하기
//Controller가 이용 가능한 메소드 목록
public interface BoardService {
	ArrayList<Board> selectAll();//모든글 목록
	Board selectOne(String num);//해당 번호의 글 한 개
	int insert(Board b);//새글 등록
	int delete(String num);//해당 번호의 글 삭제
}
