<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In/Register Page</title>
</head>
<body align="center">
	<form action="SignInServlet" method="post" style="padding-top:-700px;">
	CARD ID: <input type="text" name="cardID" value="${cardID}"><br><br>
	PASSWORD: <input type="password" name="pwd" value=""><br><br>
				<input type="submit" value="Sign In" name="SignIn"><input type="reset" value="Reset"><br>
	</form>
	${tip}
</body>
</html>