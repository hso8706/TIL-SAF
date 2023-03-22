<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>세션에서 값 꺼내기</h1>
  <%
    String id = (String) session.getAttribute("id");
    String pass = (String) session.getAttribute("pass");
    ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
  %>
  <h3>안녕하세요? <%=id %>!</h3>
  패스워드는 <%=pass %> 입니다.<hr>

  <h3>list 내용</h3>
  <% for (String color: list) { %>
    <%= color %>
  <% } %>
</body>
</html>
