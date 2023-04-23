package com.ssafy.dao;

import com.ssafy.vo.User;

import java.sql.SQLException;

public interface UserDao {
    boolean checkUser(User user) throws SQLException;

    User checkAdmin() throws SQLException;
}
