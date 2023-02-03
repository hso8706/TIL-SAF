package com.jdbc.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//DAO : DB에 접근하여 CRUD 작업을 하는 객체
public class CustomerDAO implements CustomerService{
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tigertiger";
	String query = "";
	
	public CustomerDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	@Override
	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		try {
			Statement stat = con.createStatement();
			query = "select num, name, address from customer";
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer findByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Customer p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int num, String address) {
		// TODO Auto-generated method stub
		return 0;
	}

}
