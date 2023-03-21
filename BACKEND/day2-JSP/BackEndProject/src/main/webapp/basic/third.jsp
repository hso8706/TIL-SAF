<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-03-21
  Time: 오후 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
  int count = 100; // member field;
%>
count : <%= ++count %> <hr>

<%
  int num = 100; // doGet() 에 포함되는 영역
%>
num : <%= ++num%>
</body>
</html>
