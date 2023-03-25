package com.ssafy.homework.dao;

import com.ssafy.homework.util.DBUtil;
import com.ssafy.homework.vo.Board;

import java.sql.*;
import java.util.ArrayList;

public class BoardDAOImpl implements BoardDAO{
    DBUtil dbUtil;

    public BoardDAOImpl() {
        dbUtil = DBUtil.getInstance();
    }

    @Override
    public ArrayList<Board> selectAll() {
        ArrayList<Board> list = new ArrayList<>();
        try {
            Connection con = dbUtil.getConnection();
            Statement stat = con.createStatement();
            String q = "select num, name, wdate, title, count from board order by num desc";
            ResultSet rs = stat.executeQuery(q);

            while(rs.next()){
                String num = rs.getString(1);
                String name = rs.getString(2);
                String wdate = rs.getString(3);
                String title = rs.getString(4);
                String count = rs.getString(5);

                Board b = new Board(num, null, name, wdate, title, null, count);
                list.add(b);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void countUp(String num) {
        int rs = -1;
        try {
            Connection con = dbUtil.getConnection();
            String q = "update board set count = count + 1 where num = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);
            rs = stat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Board selectOne(String num) {
        Board result = null;
        try {
            Connection con = dbUtil.getConnection();
            String q = "select num, name, wdate, title, content, count from board where num = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                num = rs.getString(1);
                String name = rs.getString(2);
                String wdate = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                String count = rs.getString(6);

                result = new Board(num, null, name, wdate, title, content, count);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int insert(Board board) {
        int rs = -1;
        try {
            Connection con = dbUtil.getConnection();
            String q = "insert into board (pass, name, wdate, title, content, count) values (?, ?, sysdate(), ?, ?, 0)";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, board.getPass());
            stat.setString(2, board.getName());
            stat.setString(3, board.getTitle());
            stat.setString(4, board.getContent());
            rs = stat.executeUpdate();

            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public int delete(String num) {
        int rs = -1;
        try {
            Connection con = dbUtil.getConnection();
            String q = "delete from board where num = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);
            rs = stat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
