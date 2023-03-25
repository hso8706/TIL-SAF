package com.ssafy.homework.service;

import com.ssafy.homework.dao.UserDAO;
import com.ssafy.homework.dao.UserDAOImpl;
import com.ssafy.homework.vo.User;

public class UserServiceImpl implements UserService{
    UserDAO udao;

    public UserServiceImpl() {
        udao = new UserDAOImpl();
    }

    @Override
    public boolean check(User user) {
        return udao.check(user);
    }
}
