package com.mvc.service;

import com.mvc.dao.UserDAO;
import com.mvc.dao.UserDAOImpl;
import com.mvc.vo.User;

public class UserServiceImpl implements UserService{
	UserDAO udao;
	
	public UserServiceImpl(){
		udao = new UserDAOImpl();
	}

	@Override
	public boolean check(User user) {		
		return udao.check(user);
	}
}
