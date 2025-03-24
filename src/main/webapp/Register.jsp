<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Register</h2>
<form action="RegisterController" method="post" onsubmit="return validate();">
FirstName : <input type = "text" name = "text_firstname" id="fname"><br><br>
LastName : <input type = "text" name = "text_lastname" id="lname"><br><br>
UserName : <input type = "text" name = "text_username" id="uname"><br><br>
Password : <input type = "password" name = "text_password" id="password"><br><br>
<input type = "submit" value="Register">
<h3>You have a already an account <a href="Login.jsp">Login</a></h3>
</form>
</body>
</html>