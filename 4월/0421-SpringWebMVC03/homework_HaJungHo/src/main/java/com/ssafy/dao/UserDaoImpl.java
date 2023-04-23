package com.ssafy.dao;

import com.ssafy.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    DataSource ds;
    @Override
    public boolean checkUser(User user) throws SQLException {
        boolean flag = false;

        Connection con = ds.getConnection();
        String q = "select user_id from members where user_id = ? and user_password = ?";
        PreparedStatement stat = con.prepareStatement(q);
        stat.setString(1, user.getUser_id());
        stat.setString(2, user.getUser_password());

        ResultSet rs = stat.executeQuery();
        if (rs.next()) flag = true;

        con.close();

        return flag;
    }

    @Override
    public User checkAdmin() throws SQLException {
        Connection con = ds.getConnection();
        String q = "select user_id, user_password from members where user_id = 'admin' and user_password = '1234'";
        PreparedStatement stat = con.prepareStatement(q);
        ResultSet rs = stat.executeQuery();
        rs.next();
        String admin_id = rs.getString(1);
        String admin_password = rs.getString(2);
        return new User(admin_id, admin_password);
    }
}
