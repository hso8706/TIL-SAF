package com.mvc.dao;

import com.mvc.util.DBUtil;
import com.mvc.vo.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//BoardDAO에서 선언한 추상 메소드의 내용을 실제 완성해 놓은 클래스
//DB 접근 작업을 하는 객체(CRUD)
public class BoardDAOImpl implements BoardDAO {
    private DBUtil util; // DB 작업을 위해 필요한 util

    public BoardDAOImpl() {
        util = DBUtil.getInstance();
    }

    public ArrayList<Board> selectAll() {
        ArrayList<Board> list = new ArrayList<>(); // 반환할 빈 리스트, Board 의 값으로 채울 예정

        try {
            Connection con = util.getConnection(); // db Connection
            Statement stat = con.createStatement(); // Statement 준비 => 한 개의 쿼리 문장을 담을 수 있는 객체
            String q = "select num, name, wdate, title, count from board order by num desc";
            ResultSet rs = stat.executeQuery(q); // executeQuery : select 쿼리 실행이 목적인 메서드, 쿼리를 직접 넘겨받고 실행시킴
            //ResultSet : 쿼리문으로 조회된 결과(rows)가 담긴 객체, 첫번째 인덱스(0)은 제목줄이다.

            while (rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
                String wdate = rs.getString(3);
                String title = rs.getString(4);
                String count = rs.getString(5);

                Board b = new Board(num, null, name, wdate, title, null, count); // db 에서 호출한 data 를 바탕으로 Board 객체 생성
                list.add(b); // 리스트에 저장
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // DB 값으로 만들어진 Board 정보가 담긴 list
    }

    @Override
    public int countUp(String num) { // read(조회) 기능을 실행하기 전 실행되는 작업, num 을 공유
        int x = 0; // 수정 여부를 담아내는 변수
        try {
            String q = "update board set count = count + 1 where num = ?";
            Connection con = util.getConnection();// pool에서 한개 빌려옴
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);// ?에 setting
            x = stat.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
    public Board selectOne(String num) { // 인자로 num 을 전달 받음.
        Board b = null; // 하나의 row 값을 담을 Board 객체

        try {
            Connection con = util.getConnection(); // DB 연결
            String q = "select num, name, wdate, title, content, count from board where num = ?"; // 해당 num의 모든 값을 받아오는 쿼리문 (row 하나의 모든 정보)
            PreparedStatement stat = con.prepareStatement(q); // PreparedStatement : `?`에 대한 변수를 비워두고 반복적으로 쓰는 쿼리문이기 때문에 사용. 실행시키기 전 쿼리를 준비시킴
            stat.setString(1, num); // 1번 ?에 메서즈 인자인 num 값 제공
            ResultSet rs = stat.executeQuery(); // select 쿼리문 실행, prepared 상태의 쿼리문을 실행

            if(rs.next()) { // 하나의 row 값만 있기 때문에 반복문 없음
                num = rs.getString(1); 
                String name = rs.getString(2);
                String wdate = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                String count = rs.getString(6);

                b = new Board(num, null, name, wdate, title, content, count); // Board 객체 채우기
            }

            con.close(); //****** 왜 닫지?
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public int insert(Board b) { // db 에 insert 시킬 값이 저장되어있는 Board 객체
        int rs = 0; // DB 저장 유무를 확인하기 위한 빈 변수
        try {
            Connection con = util.getConnection();
            String q = "insert into board (pass, name, wdate, title, content, count) values (?, ?, sysdate(), ?, ?, 0)"; // ? 변수를 사용한 재활용 쿼리 => PreparedStatement 사용 예정
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, b.getPass()); // PreparedStatement.setString : insert 하기 위한 쿼리 중 변수에 값을 넣기 위한 메서드
            stat.setString(2, b.getName());
            stat.setString(3, b.getTitle());
            stat.setString(4, b.getContent());
            rs = stat.executeUpdate(); // 준비 상태의 쿼리문 실행

            con.close(); //******
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int delete(String num) {
        int x = 0;
        try {
            String q = "delete from board where num = ?";
            Connection con = util.getConnection();// pool에서 한개 빌려옴
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);// ?에 setting
            x = stat.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
}
