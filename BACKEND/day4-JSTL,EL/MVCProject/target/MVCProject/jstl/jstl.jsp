<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1부터 시작, 5전에 종료--%>
<c:forEach begin="1" end="5" step="1" var="i">
    ${i}.hello<hr>
</c:forEach>
<br>
<%
    String[] color = {"pin", "green", "yellow"};
//    pageContext.setAttribute("color", color); // String[]로 선언한 color을 바로 전달할 수 없기 때문에 EL에서 호출할 수 있는 Scope에 저장
    request.setAttribute("color", color); // String[]로 선언한 color을 바로 전달할 수 없기 때문에 EL에서 호출할 수 있는 Scope에 저장
//    session.setAttribute("color", color); // String[]로 선언한 color을 바로 전달할 수 없기 때문에 EL에서 호출할 수 있는 Scope에 저장
//    application.setAttribute("color", color); // String[]로 선언한 color을 바로 전달할 수 없기 때문에 EL에서 호출할 수 있는 Scope에 저장
%>
<%--requestScope. 는 생략하더라도 jstl이 자동으로 호출해준다. scope 범위별로 순회하여서 찾음--%>
<c:forEach items="${color}">
    ${c}<br>
</c:forEach>

<%-- set: 변수 선언--%>
<%--<jsp:forward page=""></jsp:forward>--%>
<c:set var="num" value="99"/>
<%--<c:set var="code" value="${m.code}"/>--%>

num : ${num}<br>
code : ${code}<br>
</body>

</html>
