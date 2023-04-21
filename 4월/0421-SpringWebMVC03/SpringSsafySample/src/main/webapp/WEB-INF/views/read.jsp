<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<%@ include file="include/nav.jsp" %>

<%-- 페이지만의 내용 --%>
<div class="container p-4">

    <table class="table table-striped">
        <thead>
        <tr>
            <th>제품 이미지</th>
            <th>제품 코드</th>
            <th>제품명</th>
            <th>가격</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><img src="resources/image/${p.code }.jpg"></td>
            <td>${p.code }</td>
            <td>${p.model }</td>
            <td>${p.price }</td>
        </tr>
        </tbody>
    </table>

</div>

<%@ include file="include/footer.jsp" %>
</body>
</html>
