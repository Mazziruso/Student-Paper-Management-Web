<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path +"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success PAGE</title>
</head>
<body align="center">
	<h3 align="right">
		<form action="LogOutServlet">
			<input type="submit" value="Log Out">
		</form>
	</h3>
	<br>
	<br>
	${userName} <br>
	<a href="PersonInfo.jsp?cardID=${cardID}">Back to Person Page</a>
	<!--Back to Person Page Automatically-->
	<script type="text/javascript">
		function jumpURL() {
			window.location.href="PersonInfo.jsp?cardID=${cardID}";
		}
		setTimeout(jumpURL,2000);
	</script>
</body>
</html>