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
    //클라이언트에서 들어오는 데이터 전처리
    request.setCharacterEncoding("utf-8");

    String id = request.getParameter("id");
    String pass = request.getParameter("pass");

    if(id.equals("tommy") && pass.equals("1234")) { // welcome.jsp 로 넘기기
        response.sendRedirect("welcome.jsp");
    }
    else {
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>