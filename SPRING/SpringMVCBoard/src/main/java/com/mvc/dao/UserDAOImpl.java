package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.vo.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	DataSource ds;

	@Override
	public boolean check(User user) {
		boolean flag = false;
		try {
			Connection con = ds.getConnection();// pool에서 connection 빌려옴
			String q = "select id from user where id = ? and pw = ?";
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, user.getId());
			stat.setString(2, user.getPw());
			
			ResultSet rs = stat.executeQuery();			
			
			if(rs.next()) flag = true;
			con.close();//pool 반납
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}






