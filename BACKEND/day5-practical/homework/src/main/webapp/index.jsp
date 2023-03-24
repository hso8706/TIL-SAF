<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--redirect url : 컨텍스트 경로에 추가로 지정할 경로 설정, 패키지 경로를 주면 해당 파일을 바로 열고, 명칭을 주어 frontcontrooler 가 받게 하는 방법이 있음.--%>
<%--redirect context : 컨텍스트 경로를 작성, 생략 가능--%>
<c:redirect url="home"></c:redirect>
<%--    <h1>Board Test</h1>--%>
<%--    <a href="list">리스트 목록</a>&nbsp;&nbsp;&nbsp;--%>
<%--    <a href="insertForm">리스트 추가</a>--%>


</body>
</html>
