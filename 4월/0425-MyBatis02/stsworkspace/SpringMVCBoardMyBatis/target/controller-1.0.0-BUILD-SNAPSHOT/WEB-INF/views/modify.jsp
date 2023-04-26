<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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
	<img src="resources/image/f2.jpg"/>
		<h1>글수정하기</h1>		
		<jsp:include page="loginCheck.jsp"/>
		<p>
			<form method="post" action="modifyProcess">
			
			<!-- 폼 전송 시 글 번호도 가져가야 수정이 가능하므로 hidden으로 숨겼다가 같이 전송해야 함 -->
				<input type="hidden" name="num" value="${b.num}">
				
				<table class="table table-bordered"><TR>
					<TH>NUM</TH>
					<TD>${b.num}</TD>
					
					<Th>NAME</TH>
					<TD>${b.name}</TD>
				</TR>
				<TR>
					<TH>DATE</TH>
					<TD>${b.wdate }</TD>
					
					<TH>COUNT</TH>
					<TD>${b.count }</TD>
				</TR>
				<TR>
					<TH>PASSWORD</TH>
					<TD COLSPAN=3><input type="password" name="pass" value="${b.pass}"></TD>
				</TR>
				<TR>
					<TH>TITLE</TH>
					<TD COLSPAN=3><input type="text" name="title" value="${b.title}"></TD>
				</TR>
				<TR>
					<TH>CONTENT</TH>
					<TD COLSPAN=3>
					<textarea class="form-control" rows="5" id="content" name="content">${b.content }</textarea>
				</td>
				</div>
				</TR>
			</TABLE>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	 <a href="list">글목록</a> 	 
	  
	  
	<br><br>

	</div>
</body>
</html>






