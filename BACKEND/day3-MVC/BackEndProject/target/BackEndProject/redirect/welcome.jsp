<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-03-21
  Time: 오후 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome!</h1>
<h3><%= request.getParameter("id") %>님 환영합니다.</h3>
당신의 패스워드는 <%= request.getParameter("pass")%> 입니다.
<hr>
<%= request.getAttribute("xxx")%>
<a href="login.jsp">Go back to first page</a>
</body>
</html>
