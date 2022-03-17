<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style> 
input[type=text], input[type=password], select {
  width: 40%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=submit] {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="Login" method="post">
		Enter employee id: <input type="text" name="uname"><br>
		Enter password: <input type="password" name="pass"><br>
		<input type="submit" value="login">
		<a href="Signup.jsp">Back to Signup</a> 
	</form>
</body>
</html>