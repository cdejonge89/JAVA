<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Form</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<body>
	<h1>Review Result</h1>
	<table>
		<tr>	
			<td>Product</td>
			<td><c:out value="${product }" /></td>
		</tr>
		<tr>	
			<td>Rating</td>
			<td><c:out value="${rating }" /></td>
		</tr>
		<tr>	
			<td>comment</td>
			<td><c:out value="${comments }" /></td>
		</tr>
	</table>
</body>
</html>