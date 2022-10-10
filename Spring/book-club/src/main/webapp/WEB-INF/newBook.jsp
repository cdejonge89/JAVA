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
<title>Add a book</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<body>
 	<div class="container">
 		<div class="header">
 			<a href="/logout">LogOut</a>
 			<a href="/books">Back to the shelves</a>
 		</div>
 		<div class="bookPage">
 			<h1>Add a book to your shelf!</h1>
 		</div>
 		<div>
 			<form:form action="/new/books" method="POST" modelAttribute="newBook">
 				<div>
 					<form:label path="title">Title</form:label>
 					<form:input path="title"/>
 					<form:errors path="title" style="color:DarkRed"/>
 				</div>
 				<div>
 					<form:label path="author">Author</form:label>
 					<form:input path="author"/>
 					<form:errors path="author" style="color:DarkRed"/>
 				</div>
 				<div>
 					<form:label path="thoughts">My thoughts</form:label>
 					<form:textarea path="thoughts"/>
 					<form:errors path="thoughts" style="color:DarkRed"/>
 				</div>
 				<!-- Must include this line so userId can be linked to book -->
 				<form:hidden path="ownBook" value="${userId }"/>
 				<button type="submit">Submit</button>
 			</form:form>
 		</div>
 	</div>
</body>
</html>