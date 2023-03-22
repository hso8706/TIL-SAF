<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-03-21
  Time: 오후 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
  isErrorPage = "true"로 되어 있으므로 내장 객체 중 exception 객체를 사용할 수 있음.
--%>
    <h1>예외 발생</h1>
    예외 종류: <%= exception.getClass().getName()%><hr> <%-- getName(): 패키지+예외이름, getSimpleName(): 예외이름만 --%>
    예외 메세지: <%= exception.getMessage()%><hr>
    <h2> 숫자를 입력해 주세요!!</h2>

</body>
</html>
