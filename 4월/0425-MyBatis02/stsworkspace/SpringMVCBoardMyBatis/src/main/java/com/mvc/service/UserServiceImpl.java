package com.mvc.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mapper.UserMapper;
import com.mvc.vo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper dao;
	

	@Override
	public boolean check(User user)throws Exception {
		String idCheck = dao.check(user);
		
		return idCheck != null;
	}
}
