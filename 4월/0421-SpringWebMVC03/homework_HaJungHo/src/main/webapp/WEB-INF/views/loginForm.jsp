<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script
            src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<%@ include file="include/nav.jsp" %>

    <div class="container text-center">
        <h1>Login</h1>
<%--        ${errormsg }--%>
        <form method="post" action="loginProcess">
            <div class="form-group text-left">
                <label for="id">ID:</label>
<%--                <input type="text" class="form-control" name="id" value="${cookie.remem.value}">--%>
                <input type="text" class="form-control" name="id">
            </div>

            <div class="form-group  text-left">
                <label for="pass">Password:</label>
                <input type="password" class="form-control" name="pass">
            </div>

            <!-- <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="remember" name="remember">
                <label class="form-check-label"	for="remember">ID 저장하기</label>
            </div> -->
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="admin" name="admin">
                <label class="form-check-label"	for="admin">Admin Login</label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <br>
        <br>
    </div>

<%@ include file="include/footer.jsp" %>
</body>
</html>