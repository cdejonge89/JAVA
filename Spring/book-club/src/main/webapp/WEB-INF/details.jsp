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
		<!-- .book is coming from model  -->
		<h1><c:out value="${book.title }"/></h1>
		<a href="/books">Back to the shelves</a>
		
		<c:choose>
			<!-- only show this block if the userId from user model equals boook id from book model  -->
			<c:when test="${userId.equals(book.book.id) }">
				<p>You read <c:out value="${book.title }"/> by <c:out value="${book.author }"/> </p>
				<p>Here are your thoughts: </p>
				<p><c:out value="${book.thoughts }"/></p>
				<a href="/books/edit/${book.id }">Edit</a>
				<form action="/donations/delete/${book.id }" method="post">
					<input type="hidden" name="_method" value="delete">
					<button type="submit">Delete</button>
				</form> 
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