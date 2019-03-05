<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.entity.Administrator" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
List<User> list = (List<User>) request.getAttribute("stuAll");
List<String> admin_list = (List<String>) request.getAttribute("adminAll");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath %>">
<title>All Students Page</title>
</head>
<body>
<h3 align="right">
		<form action="LogOutServlet">
			<input type="submit" value="Log Out">
		</form>
</h3>
<h1 align="center">Student</h1>
<table width="600" border="1" cellpadding="0" align="center">
	<tr>
		<th>Card ID</th>
		<th>Name</th>
		<th>Gender</th>
		<th>Tutor</th>
		<th>Specialty</th>
		<th>Papers</th>
		<th>Delete/Update</th>
	</tr>
	<% for(User u:list) { %>
	<form action="UpdateServlet" method="post">
		<tr>
			<td align="center"><input type="text" name="cardID" value="<%=u.getCardID() %>"></td>
			<td align="center"><input type="text" name="name" value="<%=u.getName() %>"></td>
			<td align="center"><input type="text" name="gender" value="<%=u.getSex() %>"></td>
			<td align="center"><input type="text" name="tutor" value="<%=u.getTutor() %>"></td>
			<td align="center"><input type="text" name="specialty" value="<%=u.getSpecialty() %>"></td>
			<td align="center"><input type="text" name="papers" value="<%=u.getPapers() %>"></td>
			<td align="center"><a href="DeleteServlet?cardID=<%=u.getCardID() %>">Delete</a> <input type="submit" value="Update"></td>
		</tr>
	</form>
	<% } %>
</table>
<br>
<br>
<h1 align="center">Administrator</h1>
<table width="300" border="1" cellpadding="0" align="center">
	<tr>
		<th>name</th>
	</tr>
	<% for(String adminName : admin_list) { %>
	<tr>
		<td align="center"><%=adminName %></td>
	</tr>
	<% } %>
</table>
</body>
</html>