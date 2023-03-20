package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//main 함수가 있는 프로그램
// Start가 현재 프로그램을 servlet으로 만든 것
public class JdbcMySQL {

	public static void main(String[] args) throws Exception{
		String driver = "com.mysql.cj.jdbc.Driver";
	
		//jdbc url
		//jdbc:protocol name, mysql:db이름. localhost:db server 주소. 3306:port, scott:schema 이름
		String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
		//String url = "jdbc:mysql://localhost:3306/scottdb";
		
		String user = "scott";
		String password = "tigertiger";
		
		String query = "select empid, fname, phone from emp";
		
		//1.Driver 등록
		Class.forName(driver);	
		
		//2. Connection 생성 - network 연결
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3.Statement  생성
		Statement stat = con.createStatement();
		
		//4.Query  실행
		ResultSet rs = stat.executeQuery(query);
		
		//5. 결과 처리
		while(rs.next()) {
			String num = rs.getString(1);
			String name = rs.getString(2);
			String address = rs.getString(3);
			
			System.out.println(num + "--" + name + "--" + address);
		}
		
		//6. 마무리
		rs.close();
		stat.close();
		con.close();
		
	}

}

/*
 * JDBC 작업 순서
 * 1. Driver Loading
 * 2. DB 연결 (Connection 생성)
 * 3. Statement 생성 SQL 실행 준비
 *   3-1. SQL 작성.
 *   3-2. Statement 생성 (Statement, PreparedStatement)
 * 4. SQL 실행
 *   4-1. I, U, D
 *      int x = stmt.execteUpdate(sql);
 *   	int x = pstmt.executeUpdate();
 *   4-2. S
 *      ResultSet rs = pstmt.executeQuery();
 *      rs.next() [단독, if, while]
 *      값얻기 : rs.getString()
 *            rs.getInt() 등등등....
 * 5. DB 연결 종료 : 연결 역순으로 종료, finally, AutoCloseable, try-with-resource (JDK7이상)
 * 	if(rs != null)
 *    		rs.close()
 *  	if(pstmt != null)
 *  		pstmt.close();
 *  	if(conn != null)
 *  		conn.close();
 */














