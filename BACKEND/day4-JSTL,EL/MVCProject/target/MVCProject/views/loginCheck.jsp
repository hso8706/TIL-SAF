<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 로그인 안 한 경우--%>
<c:if test="${empty user}">
    <a href="loginForm">로그인</a>
</c:if>

<%-- 로그인 한 경우--%>
<c:if test="${!empty user}">
    ${user.id}님, 환영합니다.
    <a href="logout">로그인</a>
</c:if>
</body>
</html>
