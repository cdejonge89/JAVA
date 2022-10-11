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
<title>Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
    	<h1>Project Details</h1>
    	<a href="/projects">Back to Dashboard</a>
    	<table>
    		<tr>
    			<td>Project:</td>
    			<td><c:out value="${project.title }"/></td>
    		</tr>
    		<tr>
    			<td>Description:</td>
    			<td><c:out value="${project.description }"/></td>
    		</tr>
    		<tr>
    			<td>Due Date:</td>
    			<td><fmt:formatDate value="${project.dueDate }"/></td>
    		</tr>
    	</table>
    	<form action="/projects/delete/${project.id }" method="post">
			<input type="hidden" name="_method" value="delete">
			<button type="submit">Delete</button>
		</form> 
    	
    </div>
</body>
</html>