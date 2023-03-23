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
        ArrayList<Board> list = new ArrayList<>(); //

        try {
            Connection con = util.getConnection();
            Statement stat = con.createStatement();
            String q = "select num, name, wdate, title, count from board order by num desc";
            ResultSet rs = stat.executeQuery(q);

            while (rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
                String wdate = rs.getString(3);
                String title = rs.getString(4);
                String count = rs.getString(5);

                Board b = new Board(num, null, name, wdate, title, null, count);
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int countUp(String num) {
        int x = 0;
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
    public Board selectOne(String num) {
        Board b = null;

        int rss = 0;
        try {
            Connection con = util.getConnection();
            String q = "select num, name, wdate, title, content, count from board where num = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);
            ResultSet rs = stat.executeQuery();

            if(rs.next()) {
                num = rs.getString(1);
                String name = rs.getString(2);
                String wdate = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                String count = rs.getString(6);

                b = new Board(num, null, name, wdate, title, content, count);
            }

            con.close(); //******
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public int insert(Board b) {
        int rs = 0;
        try {
            Connection con = util.getConnection();
            String q = "insert into board (pass, name, wdate, title, content, count) values (?, ?, sysdate(), ?, ?, 0)";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, b.getPass());
            stat.setString(2, b.getName());
            stat.setString(3, b.getTitle());
            stat.setString(4, b.getContent());
            rs = stat.executeUpdate();

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
