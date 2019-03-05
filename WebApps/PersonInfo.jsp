<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.User" %>
<%@ page import="com.dao.StudentDaoClass" %>
<%@ page import="com.entity.Paper" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%
User user = new User();
StudentDaoClass stuDB = new StudentDaoClass();
String cardID = request.getParameter("cardID");
user = stuDB.getUser(cardID);
List<Paper> list = stuDB.getPapers(cardID);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person Info</title>
</head>
<body bgcolor="#FDF5E6">
	<h3 align="right">
		<form action="LogOutServlet">
			<input type="submit" value="Log Out">
		</form>
	</h3>
	<h1 align="center">Person Info</h1>
	<table border=1 align="center">
		<tr bgcolor="FFAD00">
			<th>Information Type
			<th>Value
		<tr>
			<td>card ID
			<td><%= user.getCardID()  %>
		<tr>
			<td>name
			<td><%= user.getName() %>
		<tr>
			<td>gender
			<td><%= user.getSex() %>
		<tr>
			<td>tutor
			<td><%= user.getTutor() %>
		<tr>
			<td>specialty
			<td><%= user.getSpecialty() %>
		<tr>
			<td>paper number
			<td><%= user.getPapers() %>
	</table>
	<br>
	<br>
	<h3 align="center">
		<div>Personal Information Error, Please Click <a href="UpdatePerson.jsp?cardID=<%=cardID%>"> Here</a></div>	
	</h3>
	<h3 align="center">
		<div>Modify Personal Password, Please Click <a href="PwdPersonUpdate.jsp?cardID=<%=cardID%>"> Here</a></div>	
	</h3>
	<br>
	<br>
	<h1 align="center">Papers Info</h1>
	<table border=1 align="center">
		<tr bgcolor="#FFADAA">
			<th>Title</th>
			<th>URL</th>
			<th>Delete</th>
		<%
			Paper paper;
			Iterator<Paper> iter = list.iterator();
			while(iter.hasNext()) {
				paper = iter.next();
		%>
		<tr>
		<td><%=paper.getTitle() %></td>
		<td><%=paper.getURL() %></td>
		<td><a href="RemovePaperServlet?cardID=<%=user.getCardID()%>&title=<%=paper.getTitle()%>">REMOVE</a></td>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<form action="AppendPaperServlet" method="post" align="center">
	card ID: <input type="checkbox" name="cardID" value="<%=cardID %>" checked><%=cardID %><br>
	Title:	<input type="text" name="title" value="Your Titile Here"><br>
	URL: <input type="text" name="url" value="Paper URL Here"><br>
	<input type="reset" value="Reset"><input type="submit" value="Append"><br>
	</form>
	<br>
	<br>
</body>
</html>