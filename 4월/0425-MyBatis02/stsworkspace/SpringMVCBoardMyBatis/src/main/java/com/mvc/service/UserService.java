package com.mvc.service;

import java.sql.SQLException;

import com.mvc.vo.User;

public interface UserService {
	boolean check(User user)throws Exception;
}
