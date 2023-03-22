<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-03-21
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form Test</h1>
<form action="../CookieTest" method="post" id="f"> <!-- servlet(CookieTest)로 처리-->
    <fieldset>
        <legend>로그인!!</legend>
        id: <input type="text" name="id"> <br>
        pwd: <input type="password" name="pass">
        <input type="submit" value="로그인">
    </fieldset>
</form>
</body>
</html>
