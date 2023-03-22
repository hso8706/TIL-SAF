<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ page import="java.sql.*" %>

<%!
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
    String user = "scott";
    String password = "tigertiger";
    String query = "select num, name from customer";

    public void jspInit() {
        try {
            //1.Driver 등록 => doGet 내부에 있으면 요청이 들어올 때마다 실행되기 때문
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
%>
        <html><body>
        <%
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
        %>

            <h1>Customer Data</h1>
            <table border=1>

        <%
            while(rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
        %>
                <tr>
                <td>  <%= num %>  </td>
                <td><a href=Detail.jsp?num=<%=num%>><%=name%></a></td>
                <tr>
        <%    }%>
            </table>
        <a href=insert.jsp>새고객 추가</a>
        <%
            rs.close();
            stat.close();
            con.close();
        %>
