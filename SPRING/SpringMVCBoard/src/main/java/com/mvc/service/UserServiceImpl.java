package com.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.UserDAO;
import com.mvc.dao.UserDAOImpl;
import com.mvc.vo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO udao;

	@Override
	public boolean check(User user) {		
		return udao.check(user);
	}
}
