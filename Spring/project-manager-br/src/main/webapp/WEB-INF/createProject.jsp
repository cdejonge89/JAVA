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
<title>Create Project</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
 		<div class="bookPage">
 			<h1>Create a project</h1>
 		</div>
 		<div>
 			<form:form action="/projects/new" method="POST" modelAttribute="newProject">
 				<div>
 					<form:label path="title">Title</form:label>
 					<form:input path="title"/>
 					<form:errors path="title" style="color:DarkRed"/>
 				</div>
 				<div>
 					<form:label path="description">Description</form:label>
 				</div>
 					<form:textarea path="description"/>
 					<form:errors path="description" style="color:DarkRed"/>
 				
 				<div>
 					<form:label path="dueDate">Due Date</form:label>
 					<form:input type="date" path="dueDate"/>
 					<form:errors path="dueDate" style="color:DarkRed"/>
 				</div>
 				<!-- Must include this line so userId can be linked to book -->
 				<form:hidden path="teamlead" value="${userId }"/>
 				<button type="submit">Submit</button>
 			</form:form>
 			<a href="/projects">Cancel</a>
 		</div>
 	</div>
</body>
</html>