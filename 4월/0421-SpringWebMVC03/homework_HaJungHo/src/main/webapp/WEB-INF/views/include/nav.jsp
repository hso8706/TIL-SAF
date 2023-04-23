<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 부트스트랩 사용을 위한 코드 --%>
<!-- CSS only -->
<link rel="stylesheet"
	  href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark d-flex justify-space-between">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="index">홈</a></li>
		<li class="nav-item"><a class="nav-link" href="productList">상품 목록</a></li>
		<c:if test="${!empty admin}">
			<li class="nav-item"><a class="nav-link" href="insertProductForm">상품 정보 등록</a></li>
		</c:if>
	</ul>
	<div>
		<jsp:include page="loginCheck.jsp"/>
<%--		<a class="nav-link" href="loginForm">로그인</a>--%>
	</div>
</nav>