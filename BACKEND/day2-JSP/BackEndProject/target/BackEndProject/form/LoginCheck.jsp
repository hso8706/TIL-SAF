<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-03-21
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login Check</h1>
<%
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
%>
<h1>Welcome, <%= id %>!!!</h1>
your password is...<%= pass %>
</body>
</html>