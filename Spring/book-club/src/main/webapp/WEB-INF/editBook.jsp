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
<title>Edit Book</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<body>
 	<div class="container">
 		<div class="header">
 			<a href="/logout">LogOut</a>
 			<a href="/books">Back to the shelves</a>
 		</div>
 		<div class="bookPage">
 			<h1>Edit your book</h1>
 		</div>
 		<div>
 			<form:form method="POST" modelAttribute="book" action="/books/edit/${book.id }"  >
 				<input type="hidden" name="_method" value="put">
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
 				<!-- this line must exist as to not delete the user who created the book -->
 				<form:hidden path="ownBook"/>
 				<button type="submit">Submit</button>
 			</form:form>
 		</div>
 	</div>
</body>
</html>