<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 로그인 안한 경우 --%>
<c:if test="${empty user && empty admin}">
	<a href="loginForm">로그인</a>
</c:if>

<%-- 로그인 한 경우 --%>
<c:if test="${!empty admin}">
	관리자(${user.id}) 님, 환영합니다.
	<a href="#">관리하기</a>	
	<a href="logout">로그아웃</a>
</c:if> 

<c:if test="${!empty user && empty admin}">
	${user.id} 님, 환영합니다.
	<a href="logout">로그아웃</a>
</c:if>

</body>
</html>