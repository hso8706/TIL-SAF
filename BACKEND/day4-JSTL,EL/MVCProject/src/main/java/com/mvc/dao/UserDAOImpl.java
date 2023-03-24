package com.mvc.dao;

import com.mvc.util.DBUtil;
import com.mvc.vo.User;

public class UserDAOImpl implements UserDAO {

    private DBUtil util;

    public UserDAOImpl() {
        util = DBUtil.getInstance();
    }

    @Override
    public boolean check(User user) {
        return false;
    }
}
