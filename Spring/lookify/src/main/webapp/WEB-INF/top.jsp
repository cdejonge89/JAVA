<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Ten Songs</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Top Ten Songs</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Rating</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
			<c:forEach var="song" items="${songs}">
				<tr>
					<td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
					<td><c:out value="${song.rating}"></c:out></td>
					<td><a href="/delete/${song.id}">delete</a></td>
				</tr>	
			</c:forEach>
	    </tbody>
	</table>
	
</body>
</html>