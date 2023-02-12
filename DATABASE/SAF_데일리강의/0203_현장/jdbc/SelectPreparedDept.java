package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectPreparedDept {

	public static void main(String[] args) {
		try {			
			String driver = "com.mysql.cj.jdbc.Driver";
			//jdbc url : 
			//jdbc : mysql(protocol name) :  통신을 위해서는 프로토콜이 필요함
			//mysql : 데이터베이스 이름, DB NAME
			//localhost:3306(Sever : port num) : 데이터베이스가 있는 서버  
			//scottdb : 사용할 데이터베이스 이름
			// ? : 구분자
			// severTimezone=UTC
			// characterEncordong = UTF-8;
			String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
			String user = "scott"; // 계정명
			String password = "tiger"; //pw
			
			String query = "select empid, name, phone, jobid, deptid "
					+ "from myemp where deptid = ?"; //query 문
			//String query = "select empid, name, phone from myemp"; //query 문
			
			//1. driver loading 
			Class.forName(driver);
			
			//2. connection create
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3. Statement Create
			//Statement stat = con.createStatement();
			PreparedStatement pstat = con.prepareStatement(query);
			
			//3.1 ? 에 값 setting
			pstat.setString(1, "20");
			
			//4. Query send
			ResultSet rs = pstat.executeQuery();
			
			//5. reslut processing
			while(rs.next()) {
				String empid = rs.getString(1); 
				String name = rs.getString(2); 
				String phone = rs.getString(3); 
				String jobid = rs.getString(4); 
				String deptid = rs.getString(5);
				System.out.printf("%s\t|\t%20s\t|\t%15s\t|\t%10s\t|\t%s\n",
                        empid, name, phone, jobid, deptid);
			}
			
			//6. close
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
