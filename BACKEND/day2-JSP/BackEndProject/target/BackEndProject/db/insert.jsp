<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
</head>
<body>
<h1>Add Customer</h1>
<form action="insertProcess.jsp" method="post">
num: <input type="text" name="num"><br>
name: <input type="text" name="name"><br>
address: <input type="text" name="address"><br>
<input type="submit" value="send">
</form>
</body>
</html>