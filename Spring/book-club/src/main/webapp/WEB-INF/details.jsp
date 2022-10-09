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
<title>Book Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1><c:out value="${book.title }"/></h1>
		<a href="/books">Back to the shelves</a>
		
		<c:choose>
			<c:when test="${userId.equals() }">
				<p>You read a book</p>
			</c:when>
			<c:otherwise>
				<p><c:out value="${book.book.userName }"/> read <c:out value="${book.title }"/> by <c:out value="${book.author }"/></p> 
				<p>Here are <c:out value="${book.book.userName }"/>'s thoughts: </p>
				<p><c:out value="${book.thoughts }"/></p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>