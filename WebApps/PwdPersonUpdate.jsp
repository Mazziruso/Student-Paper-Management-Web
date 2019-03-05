<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal Password Modification</title>
</head>
<body>
	<h3 align="right">
		<form action="LogOutServlet">
			<input type="submit" value="Log Out">
		</form>
	</h3>
	<h1 align="center">
		<form action="PwdUpdateServlet" method="post">
		Card ID: <input type="checkbox" name="cardID" value="<%=request.getParameter("cardID")%>" checked><%=request.getParameter("cardID")%><br>
		Old Password: <input type="password" name="oldPwd" value=""><br>
		New Password: <input type="password" name="newPwd" value=""><br>
		<input type="reset" value="Reset"> <input type="submit" value="Submit">
		</form>
	</h1>
	<h4 align="center" style="color:red">${tip}</h4>
</body>
</html>