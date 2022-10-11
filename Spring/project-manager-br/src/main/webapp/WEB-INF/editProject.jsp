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
<title>Edit Project</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
 		<div class="bookPage">
 			<h1>Edit Project</h1>
 		</div>
 		<div>
 			<form:form method="POST" modelAttribute="project" action="/projects/edit/${project.id }"  >
 				<input type="hidden" name="_method" value="put">
 				<div>
 					<form:label path="title">Title</form:label>
 					<form:input path="title"/>
 					<form:errors path="title" style="color:DarkRed"/>
 				</div>
 				<div>
 					<form:label path="description">Descritption</form:label>
 					<form:input path="description"/>
 					<form:errors path="description" style="color:DarkRed"/>
 				</div>
 				<div>
 					<form:label path="dueDate">Due Date</form:label>
 					<form:input type="date" path="dueDate"/>
 					<form:errors path="dueDate" style="color:DarkRed"/>
 				</div>
 				<!-- this line must exist as to not delete the user who created the book -->
 				<form:hidden path="teamlead"/>
 				<button type="submit">Submit</button>
 			</form:form>
 		</div>
 	</div>
</body>
</html>