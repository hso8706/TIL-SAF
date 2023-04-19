package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.util.DBUtil;
import com.mvc.vo.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	DataSource ds; //import java.sql.Connection
	// 미리 생성된 Connection Pool에서 빌려오는 개념, 반납 필수

	@Override
	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = new ArrayList<>();

		try {
			Connection con = util.getConnection();
			Statement stat = con.createStatement();
			String q = "select num, name, wdate, title, count from board order by num desc";
			ResultSet rs = stat.executeQuery(q);

			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				String count = rs.getString(5);

				Board b = new Board(num, null, name, wdate, title, null, count);
				list.add(b);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Board selectOne(String num) {
		Board b = null;
		try {
			Connection con = util.getConnection();
			String q = "select num, name, wdate, title, content, count from board where num = ?";
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);
			ResultSet rs = stat.executeQuery();

			if (rs.next()) {
				num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				String content = rs.getString(5);
				String count = rs.getString(6);
				b = new Board(num, null, name, wdate, title, content, count);
			}
			con.close(); // *****
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public int insert(Board b) {
		int x = 0;
		try {
			Connection con = util.getConnection();// pool�뿉�꽌 �븳媛� 鍮뚮젮�샂
			String q = "insert into board(pass,name,wdate,title,content,count)" + " values(?,?,sysdate(),?,?,0)";

			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, b.getPass());
			stat.setString(2, b.getName());
			stat.setString(3, b.getTitle());
			stat.setString(4, b.getContent());

			x = stat.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int delete(String num) {
		int x = 0;
		try {
			String q = "delete from board where num = ?";
			Connection con = util.getConnection();// pool�뿉�꽌 �븳媛� 鍮뚮젮�샂
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);// ?�뿉 setting
			x = stat.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int countUp(String num) {
		int x = 0;
		try {
			String q = "update board set count = count + 1 where num = ?";
			Connection con = util.getConnection();// pool�뿉�꽌 �븳媛� 鍮뚮젮�샂
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);// ?�뿉 setting
			x = stat.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;		
	}

}
