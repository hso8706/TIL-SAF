<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/include/head.jsp" %>
</head>
<body>
<%@ include file="/include/nav.jsp" %>

<%-- 페이지만의 내용 --%>
<div class="container p-4">
    <h2>상품 목록</h2>
    <table class="table table-striped">
        <thead>
            <th>code</th>
            <th>model</th>
            <th>price</th>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.code}</td>
                    <td><a href="read?code=${p.code}">${p.model}</a></td>
                    <td>${p.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</div>
<%-- 새상품 등록 링크 추가하기 --%>

<%@ include file="/include/footer.jsp" %>