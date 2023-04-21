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
            <th>번호</th>
            <th>제품 코드</th>
            <th>제품명</th>
            <th>가격</th>
            <th>상세보기</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list }" var="p">
            <tr>
                <td>${p.num }</td>
                <td>${p.code }</td>
                <td>${p.model }</td>
                <td>${p.price }</td>
                <td><a href="read?code=${p.code }">자세히 보기</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<%@ include file="include/footer.jsp" %>
</body>
</html>
