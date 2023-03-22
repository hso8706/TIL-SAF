<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-03-21
  Time: 오후 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>

<%!
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
    String user = "scott";
    String password = "tigertiger";
    String query = "insert into customer values(?,?,?)";

    public void jspInit() { //jsp용 init
        try {
            Class.forName(driver);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
%>

<html>
<body>
    <%
        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1,request.getParameter("num"));
        pstmt.setString(2,request.getParameter("name"));
        pstmt.setString(3,request.getParameter("address"));

        pstmt.executeUpdate();

        pstmt.close();
        con.close();
        response.sendRedirect("Start.jsp");
    %>
