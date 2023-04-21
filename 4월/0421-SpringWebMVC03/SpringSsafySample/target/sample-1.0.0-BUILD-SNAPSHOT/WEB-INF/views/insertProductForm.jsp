<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<%@ include file="include/nav.jsp" %>

<div class="container text-center">
    <h1>제품 등록</h1>
    <img src="resources/image/laptopshop.jpg" />
    <form action="insertProductProcess" method="post">
        <div class="form-group text-left">
            <label for="code">code:</label>
            <input type="text"	class="form-control" name="code">
        </div>

        <div class="form-group text-left">
            <label for="model">model:</label>
            <input type="text"	class="form-control" name="model">
        </div>
        <div class="form-group text-left">
            <label for="price">price:</label>
            <input type="text"	class="form-control" name="price">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <br><br>
</div>

<%@ include file="include/footer.jsp" %>
</body>
</html>