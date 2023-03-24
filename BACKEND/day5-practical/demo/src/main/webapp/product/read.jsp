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
    <h2>상품 상세 정보</h2>
    <table class="table table-striped">
        <thead>
        <th>code</th>
        <th>model</th>
        <th>price</th>
        </thead>
        <tbody>
        <tr>
            <td>${p.code}</td>
            <td>${p.model}</td>
            <td>${p.price}</td>
            <td>
            <form  id="deleteForm" action = "delete" method="post">
                <button type="submit" class="btn btn-primary" id="deleteBtn">삭제</button>
            </form>
            </td>
        </tr>
        </tbody>
    </table>

</div>
<%-- 삭제 링크 추가하기 --%>

<%-- 초기화면 링크 추가하기 --%>
<%@ include file="/include/footer.jsp" %>