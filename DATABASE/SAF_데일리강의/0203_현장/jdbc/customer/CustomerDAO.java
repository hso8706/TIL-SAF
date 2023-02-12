package com.jdbc.customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//DAO(Data Access Object) : db파일에 접근해 Crud 작업을 하는 객체
import java.util.List;

import jdk.nashorn.internal.ir.CatchNode;

public class CustomerDAO extends Customer implements CustomerService{
	//db작없에 필요한 내용.
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
	private String user = "scott"; // 계정명
	private String password = "tiger"; //pw
	private String query="";
	Customer ct = new Customer();
	public CustomerDAO(){
		try {
			Class.forName(driver);	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	@Override
	public List<Customer> selectAll() {
		List<Customer> list = new ArrayList<>();
		query="select * from customer;";
		Connection con = getConnection();
		try {
			Statement stat = con.createStatement();
			stat.executeUpdate(query);
			con.close();
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				String num = rs.getString(1); 
				String name = rs.getString(2); 
				String address = rs.getString(3); 
				System.out.printf("%s\t|\t%10s\t|\t%15s\t\n",
                        num, name, address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer findByNum(String num) {
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
