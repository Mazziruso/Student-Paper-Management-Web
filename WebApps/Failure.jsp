<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My JSP 'index.jsp' starting page</title>
</head>
<body>
	<h1 align="center">Failure</h1>
	<!--Back to Last Page-->
	<script type="text/javascript">setTimeout("history.go(-1)", 1000);  </script>
</body>
</html>