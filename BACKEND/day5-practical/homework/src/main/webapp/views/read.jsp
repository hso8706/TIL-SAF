<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<div class="container text-center">
	<img src="image/f2.jpg"/>
		<h1>글읽기</h1>
		<p>
			<table class="table table-bordered"><TR>

				<TH>NUM</TH>
				<TD>${board.num}</TD> <!--BoardController에서 board라는 이름으로 requset에 담아 보낸 값-->

				<Th>NAME</TH>
				<TD>${board.name}</TD>
			</TR>
			<TR>
				<TH>DATE</TH>
				<TD>${board.wdate}</TD>

				<TH>COUNT</TH>
				<TD>${board.count}</TD>
			</TR>
			<TR>
				<TH>TITLE</TH>
				<TD COLSPAN=3>${board.title}</TD>
			</TR>
			<TR>
				<TH>CONTENT</TH>
				<TD COLSPAN=3>
				<textarea readonly class="form-control" rows="5" id="comment" name="comment">
					${board.content}
				</textarea>
			</td>
			</TR>
		</TABLE>
	 <a href="list">글목록</a>

	<br><br>

	</div>
</body>
</html>






