package com.mvc.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.UserDAO;
import com.mvc.vo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO udao;	
	

	@Override
	public boolean check(User user)throws Exception {		
		return udao.check(user);
	}
}
