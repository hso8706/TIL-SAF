package com.db;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "Start", value = "/Start")
public class Start extends HttpServlet {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
    String user = "scott";
    String password = "tigertiger";
    String query = "select num, name from customer";

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

        try{
            //2. Connection 생성 - network 연결 (servlet 과 DB 의 연결 통로)
            //Connection 은 사실 init 에 있어도 되는 부분이지만, 혹시라도 연결이 끊기면 다시는 사용할 수 없기 때문에 doGet에 위치하는게 안전
            Connection con = DriverManager.getConnection(url, user, password);

            //3.Statement  생성
            Statement stat = con.createStatement();

            //4.Query  실행
            ResultSet rs = stat.executeQuery(query);
            out.println("<h1>Customer Data</h1>");
            out.println("<table border=1>");

            //5. 결과 처리
            while(rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
//                String address = rs.getString(3);

                out.println("<tr>");
                out.println("<td>" + num + "</td>");
                out.println("<td><a href=Detail?num=" + num + ">" + name + "</a></td>"); // 이름을 통해 새로운 servlet server 실행
                out.println("<tr>");
            }

            out.println("</table>");
            //6. 마무리
            rs.close();
            stat.close();
            con.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
