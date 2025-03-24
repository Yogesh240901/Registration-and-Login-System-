<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>
<form action="LoginController" name="LoginForm" method="post" onsubmit="return validate()">
UserName : <input type="text" name = "txt_user"><br><br>
Password : <input type="password" name = "txt_pass"><br><br>
<input type = "submit" name = "btn_login" value = "login">
<h3>You don't have an account? <a href="Register.jsp">Register</a></h3>
</form>
</body>
</html>