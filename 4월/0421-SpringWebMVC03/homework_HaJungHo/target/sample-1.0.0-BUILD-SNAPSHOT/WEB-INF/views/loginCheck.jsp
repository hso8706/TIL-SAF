<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script
          src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script
          src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class = "text-light">
  <%-- 로그인 안한 경우 --%>
  <c:if test="${empty user && empty admin}">
    <a href="loginForm" class="text-light">로그인</a>
  </c:if>

  <%-- 로그인 한 경우 --%>
  <c:if test="${!empty admin}">
    관리자(${user.user_id}) 님, 환영합니다.
<%--    <a href="#" class="text-info">관리하기</a>--%>
    <a href="logout" class="text-danger">로그아웃</a>
  </c:if>

  <c:if test="${!empty user && empty admin}">
    ${user.user_id} 님, 환영합니다.
    <a href="logout" class="text-danger">로그아웃</a>
  </c:if>
</div>
</body>
</html>