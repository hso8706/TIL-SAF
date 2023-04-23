package com.ssafy.service;

import com.ssafy.dao.UserDao;
import com.ssafy.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserServcie {
    @Autowired
    UserDao dao;
    @Override
    public boolean checkUser(User user, String admin) throws SQLException {
        if (dao.checkUser(user)) {
            if(admin != null) {
                User isAdmin = dao.checkAdmin();
                return user.getUser_id().equals(isAdmin.getUser_id()) && user.getUser_password().equals(isAdmin.getUser_password());
            }
            else return true;
        }

        return false;
    }
}
