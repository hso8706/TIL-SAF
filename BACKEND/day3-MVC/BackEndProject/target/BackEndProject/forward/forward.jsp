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
    String code = "this is my secret code";
    request.setAttribute("xxx", code); // 추가적으로 request에 정보를 저장하는 방법

    if(id.equals("tommy") && pass.equals("1234")){ // welcome.jsp 로 넘기기
%>  <%-- 파라미터 여러 개 가능 --%>
    <jsp:forward page="welcome.jsp">
        <jsp:param value="<%= id %>" name="id"/>
        <jsp:param value="<%= pass %>" name="pass"/>
    </jsp:forward>
<%} else {%>
    <jsp:forward page="../cookie/login.jsp"/>
<% } %>
</body>
</html>
