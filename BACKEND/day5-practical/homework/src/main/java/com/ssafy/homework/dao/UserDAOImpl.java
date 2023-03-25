package com.ssafy.homework.dao;

import com.ssafy.homework.util.DBUtil;
import com.ssafy.homework.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    DBUtil util;

    public UserDAOImpl() {
        util = DBUtil.getInstance();
    }

    @Override
    public boolean check(User user) {
        // 로그인 정보가 DB에 저장된 정보와 매칭하는지 확인
        boolean flag = false;

        try {
            Connection con = util.getConnection();
            String q = "select id from user where id = ? and pw = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, user.getId());
            stat.setString(2, user.getPw());

            ResultSet rs = stat.executeQuery(); //select

            if(rs.next()) flag = true; // 로그인 정보와 db 정보가 매칭된 경우 rs 가 존재
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
}
