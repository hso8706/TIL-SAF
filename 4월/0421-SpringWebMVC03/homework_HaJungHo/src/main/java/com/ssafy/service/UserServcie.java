package com.ssafy.service;

import com.ssafy.vo.User;

import java.sql.SQLException;

public interface UserServcie {
    boolean checkUser(User user, String admin) throws SQLException;
}
