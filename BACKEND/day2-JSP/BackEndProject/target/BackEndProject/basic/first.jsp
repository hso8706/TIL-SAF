<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-03-21
  Time: 오후 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page info="this is my first jsp" %>
<%@ page import="java.util.ArrayList, java.sql.Connection" %> <%-- jsp는 임포트 필수--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>First Page</h1>
    <%@include file="in.jsp"%>

    <h2>this is another text</h2> <%-- 정적 include, 지시어를 사용한 include --%>
    <%@include file="in.jsp"%>

    <h3>this is happy</h3>  <%-- 동적 include, jsp tag를 사용한 include --%>
    <jsp:include page="happy.jsp"/>
    <!-- 이것은 html 주석 --> <%-- 개발자 모드 source에 남아있는 것 확인 --%>
    <%-- 이것은 jsp 주석 --%>
</body>
</html>
