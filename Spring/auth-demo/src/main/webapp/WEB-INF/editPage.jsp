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
<title>Edit Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<a href="/logout">LogOut</a>
	<a href="/donations">Home</a>
	<div class="newDonation">
	<h1>Welcome, ${userName }</h1>
	
	<h2>Edit a Donation</h2>
	<form:form action="/donations/edit/${donation.id }" method="POST" modelAttribute="donation">
		<input type="hidden" name="_method" value="put">
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
		<form:hidden path="donor"/>
		<button type="submit">Edit</button>
	</form:form>

	</div>
</body>
</html>