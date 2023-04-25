package com.mvc.mapper;

import java.sql.SQLException;

import com.mvc.vo.User;

public interface UserMapper {

	String check(User user)throws SQLException;

}
