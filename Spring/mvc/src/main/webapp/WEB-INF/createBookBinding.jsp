<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Form</title>
</head>
<body>
	<h1>Add a book</h1>
	<form:form method="POST" action="/books/new" modelAttribute="newBook">
		<p>
			<form:label path="title">Title</form:label>
			<form:input path="title"/>
			<form:errors style="color:red" path="title"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:textarea path="description"/>
			<form:errors style="color:red" path="description"/>
		</p>
		<p>
			<form:label path="language">Language</form:label>
			<form:input path="language"/>
			<form:errors style="color:red" path="language"/>
		</p>
		<p>
			<form:label path="numberOfPages">Pages</form:label>
			<form:input type="number" path="numberOfPages"/>
			<form:errors style="color:red" path="numberOfPages"/>
		</p>
		<button type="submit">Add</button>
	</form:form>
 
 </body>
</html>