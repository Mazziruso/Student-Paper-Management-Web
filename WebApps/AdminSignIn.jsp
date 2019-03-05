<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator Sign In</title>
</head>
<body align="center">
	<form action="AdminSignInServlet" method="post" style="padding-top:-700px;">
	NAME: <input type="text" name="name" value="${name}"><br><br>
	PASSWORD: <input type="password" name="pwd" value=""><br><br>
				<input type="submit" value="Sign In" name="SignIn"><input type="reset" value="Reset"><br>
	</form>
	${tip}
</body>
</html>