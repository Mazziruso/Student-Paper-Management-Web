<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dao.StudentDaoClass" %>
<%@ page import="com.entity.User" %>
<%
	StudentDaoClass stuDB = new StudentDaoClass();
	String cardID = request.getParameter("cardID");
	User u = stuDB.getUser(cardID);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Information</title>
</head>
<body>
<h1 align="center">Fill Blank</h1>
<table width="600" border="1" cellpadding="0">
	<tr>
		<th>Card ID</th>
		<th>Name</th>
		<th>Gender</th>
		<th>Tutor</th>
		<th>Specialty</th>
		<th>Papers</th>
		<th>Del/Upd</th>
	</tr>
	<form action="UpdateServlet" method="post">
		<tr>
			<td><input type="text" name="cardID" value="<%=u.getCardID() %>"></td>
			<td><input type="text" name="name" value="<%=u.getName() %>"></td>
			<td><input type="text" name="sex" value="<%=u.getSex() %>"></td>
			<td><input type="text" name="tutor" value="<%=u.getTutor() %>"></td>
			<td><input type="text" name="specialty" value="<%=u.getSpecialty() %>"></td>
			<td><input type="text" name="papers" value="<%=u.getPapers() %>"></td>
			<td><a href="DeleteServlet?cardID=<%=u.getCardID() %>">Delete</a><input type="submit" value="Update"></td>
		</tr>
	</form>
</table>
</body>
</html>