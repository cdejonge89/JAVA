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
<title>Donation Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<a href="/logout">LogOut</a>
	<a href="/donations">Home</a>
	<div class="container">
		<table>
			<tr>
				<td>Item Name:</td>
				<td>${donation.itemName }</td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td>${donation.quantity }</td>
			</tr>
			<tr>
				<td>Donor Name:</td>
				<td>${donation.donor }</td>
			</tr>
			<tr>
				<td>Contact Donor:</td>
				<td>${donation.donor.email }</td>
			</tr>
		</table>
	</div>
</body>
</html>