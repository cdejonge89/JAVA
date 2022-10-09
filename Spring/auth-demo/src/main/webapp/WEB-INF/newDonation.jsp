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
<title>New Donation</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<a href="/logout">LogOut</a>
	<div class="newDonation">
	<h1>Welcome, ${userName }</h1>
	
	<h2>Add a Donation</h2>
	<form:form action="/donations/new" method="POST" modelAttribute="newDonation">
		<p>
			<form:label path="itemName">Item Name</form:label>
			<form:input path="itemName"/>
			<form:errors path="itemName" style="color:red"/>
		</p>
		<p>
			<form:label path="quantity">Quantity</form:label>
			<form:input type="number" path="quantity"/>
			<form:errors path="quantity" style="color:red"/>
		</p>
		<form:hidden path="donor" value="${userId }"/>
		<button type="submit">Add</button>
	</form:form>

	</div>
</body>
</html>