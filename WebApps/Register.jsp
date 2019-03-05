<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Register Start Page</title>
</head>
<body>
	<h1>Please Fill in the Blank</h1>
	<form action="RegisterServlet" method="post" style="padding-top:-700px;">
		CARD ID: <input name="cardID" type="text" value="<%=request.getAttribute("cardID") %>"><br><br>
		USER NAME: <input name="name" type="text"><br><br>
		PASSWARD: <input name="pwd" type="password"><br><br>
		CONFIRM PASSWARD: <input name="pwd_c" type="password"><br><br>
		GENDER: <input type="radio" name="sex" value="Male" checked>Male
			<input type="radio" name="sex" value="Female">Female<br><br>
		TUTOR: <input type="text" name="tutor"><br><br>
		SPECIALTY: 
		<select name="specialty">
			<option value="Communication">Communication</option>
			<option value="SignalProcessing">Signal Processing</option>
			<option value="Microwave">Microwave</option>
			<option value="Security">Security</option>
			<option value="Circuit">Circuit</option>
			<option value="MicroChip">Micro Chip</option>
			<option value="Network">Network</option>
			<option value="Computer">Computer</option>
			<option value="Software">Software</option>
		</select><br>
		<input type="reset" value="Reset"><input type="submit" value="Register">
	</form>
</body>
</html>