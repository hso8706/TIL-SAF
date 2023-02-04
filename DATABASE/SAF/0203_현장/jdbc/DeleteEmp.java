package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
300번 레코드 삭제
*/
public class DeleteEmp {

	public static void main(String[] args) {
		try {			
			String driver = "com.mysql.cj.jdbc.Driver";
			//jdbc url : 
			//jdbc : protocol name, 통신을 위해서는 프로토콜이 필요함
			//mysql : 데이터베이스 이름, DB NAME
			//localhost:3306 : 데이터베이스가 있는 서버, Sever And port num 
			//scottdb : 사용할 데이터베이스 이름
			// ? : 구분자
			// severTimezone=UTC
			// characterEncordong = UTF-8;
			String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
			String user = "scott"; // 계정명
			String password = "tiger"; //pw
			
			String query = "delete from myemp where empid = ?;"; //query 문
			String query2 = "select * from myemp"; //query 문
			
			//1. driver loading 
			Class.forName(driver);
			
			//2. connection create
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3. Statement Create
			PreparedStatement pstat = con.prepareStatement(query);
			pstat.setInt(1, 300);
			pstat.execute();
			
			//4. Query send
			ResultSet rs = pstat.executeQuery(query2);
			
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
