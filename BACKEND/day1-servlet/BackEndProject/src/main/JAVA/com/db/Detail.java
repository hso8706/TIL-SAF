package com.db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Detail", value = "/Detail")
public class Detail extends HttpServlet {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
    String user = "scott";
    String password = "tigertiger";
    String query = "select num, name, address from customer where num = ?";//쿼리 변경

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            //1.Driver 등록 => doGet 내부에 있으면 요청이 들어올 때마다 실행되기 때문
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //0. param 받기
        String num = request.getParameter("num");

        try {
            //2. Connection 생성 - network 연결 (servlet 과 DB 의 연결 통로)
            //Connection 은 사실 init 에 있어도 되는 부분이지만, 혹시라도 연결이 끊기면 다시는 사용할 수 없기 때문에 doGet에 위치하는게 안전
            Connection con = DriverManager.getConnection(url, user, password);

            //3.Statement  생성
            PreparedStatement stat = con.prepareStatement(query); // 물음표 부분만 빼고 항상 같은 쿼리문일 때 사용

            //3-1. ?에 값 setting
            stat.setString(1, num);

            //4.Query  실행
            ResultSet rs = stat.executeQuery(); //쿼리문은 위에서 사용, 실행할 땐 빈 값 실행

            out.println("<h1>Customer Detail Data</h1>");
            out.println("<table border=1>");

            //5. 결과 처리
            rs.next(); // while은 필요없지만, 제목 줄을 넘기기 위해서
            num = rs.getString(1);
            String name = rs.getString(2);
            String address = rs.getString(3);

            out.println("<tr>");
            out.println("<td>" + num + "</td>");
            out.println("<td>" + name + "</td>");
            out.println("<td>" + address + "</td>");
            out.println("</tr>");

            out.println("</table>");
            out.println("<a href=Start>초기화면</a>");
            //6. 마무리
            rs.close();
            stat.close();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
