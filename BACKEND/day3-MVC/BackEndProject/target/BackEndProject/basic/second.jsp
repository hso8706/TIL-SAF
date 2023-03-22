<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-03-21
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
      int num = 99; // member field로 들어감
      public String hello(String name){
        return name + ", welcome!!!";
      }
    %>
    <%
      if (num > 100) {
    %>
    <h1>big number!!!</h1>
    <%} else { %>
    <h3>small number!!!</h3>
    <% }%>
    <hr>
    hello() 호출: <%= hello("kim") %>
</body>
</html>
