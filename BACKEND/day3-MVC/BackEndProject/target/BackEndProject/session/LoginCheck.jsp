<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-03-22
  Time: 오후 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>세션에 값 저장</h1>
  <%
      String id = request.getParameter("id");
      String pass = request.getParameter("pass");

      //jsp 에선 session 객체가 내장되어 있기 때문에 session 을 불러올 필요가 없다(getSession 안해도됨)
      session.setAttribute("id", id);
      session.setAttribute("pass", pass);

      ArrayList<String> list = new ArrayList<>();
      list.add("red");
      list.add("blue");
      list.add("white");
      list.add("pink");
      list.add("yellow");
      session.setAttribute("list", list);
      //데이터가 저장되는 scope 를 학습하기위한 예제 코드(0321-JSP/JSP 교재 정리 => JSP 기본객체 - 범위 참고)
//      request.setAttribute("xyz", "hello"); //request는 응답이 끝나면 사라짐(forward 인 경우 제외)
//      application.setAttribute("qqq", "123"); //application은 server, 즉 tomcat을 끄지 않는다면 그대로 유지
  %>
<a href="check.jsp">check로 가기</a>
</body>
</html>
