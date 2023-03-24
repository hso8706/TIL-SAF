package com.mvc.service;

import com.mvc.dao.BoardDAO;
import com.mvc.dao.BoardDAOImpl;
import com.mvc.vo.Board;

import java.util.ArrayList;

//Controller 에서 넘어온 요청을 처리하는 객체 => DAO 객체에 전달해서 결과를 받음
//BoardService 에서 선언한 추상 메소드의 내용을 실제 완성해 놓은 클래스
public class BoardServiceImpl implements BoardService {
    BoardDAO dao; // interface type

    public BoardServiceImpl() {
        dao = new BoardDAOImpl();
    }

    public ArrayList<Board> selectAll() {
        return dao.selectAll(); // 만들어진 ArrayList<Board>를 Controller 로 반환
    }

    public Board selectOne(String num) {
        dao.countUp(num); // 값을 읽기 전에 조회수 카운트업
        return dao.selectOne(num); // 값을 읽음
    }

    public int insert(Board b) {
        return dao.insert(b);
    }

    public int delete(String num) {
        return 0;
    }
}
