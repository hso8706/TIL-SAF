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
    <form action="LoginCheck.jsp" method="post" id="f">
        <fieldset> <!-- 하나의 집합으로 묶어주는 선 태그-->
            <legend>로그인</legend> <!-- 필드셋의 이름이 되는 부분 -->
            USER NAME: <input type="text" name="id" id="id"/><br /> <!--name 선언은 welcome.jsp로 보낼 때 구분하기 위한 용도-->
            USER PASSWORD: <input type="password" name="pass" id="pass"/><br /><!--id 선언은 js 내에서 구분하고 접근하기 위한 용도-->
            <input type="reset" value="취소" />
            <input type="submit" value="로그인"/> <!--기존에 있던 submit은 validation 불가-->
        </fieldset>
    </form>
</body>
</html>
