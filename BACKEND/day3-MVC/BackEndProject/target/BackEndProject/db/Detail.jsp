<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ page import="java.sql.*" %>

<%!
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC&characterEncoding=UTF-8";
    String user = "scott";
    String password = "tigertiger";
    String query = "select num, name, address from customer where num = ?";

    public void jspInit(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    String num;
%>
    <html><body>
    <%
            num = request.getParameter("num");
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stat = con.prepareStatement(query);
            stat.setString(1, num);
            ResultSet rs = stat.executeQuery();
    %>
            <h1>Customer Detail Data</h1>
            <table border=1>

    <%
            rs.next();
            num = rs.getString(1);
            String name = rs.getString(2);
            String address = rs.getString(3);
    %>

            <tr>
            <td> <%=num%> </td>
            <td> <%=name%> </td>
            <td> <%=address%> </td>
            </tr>

            </table>
            <a href=Start.jsp>초기화면</a>"
    <%
            rs.close();
            stat.close();
            con.close();
    %>