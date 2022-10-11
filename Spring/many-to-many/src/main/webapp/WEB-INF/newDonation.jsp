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
<title>Create Donation</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<body>
 	<div class="container">
 		<div class="header">
 			<a href="/logout">LogOut</a>
 			<a href="/donations">Back to donations</a>
 		</div>
 		<div class="bookPage">
 			<h1>Create a Donation</h1>
 		</div>
 		<div>
 			<form:form action="/donations/process" method="POST" modelAttribute="newDonation">
 				<div>
 					<form:label path="itemName">Item Name</form:label>
					<form:input path="itemName"/>
					<form:errors style="color:red" path="itemName"/>
 				</div>
 				<div>
 					<form:label path="quantity">Quantity</form:label>
					<form:input tyep="number" path="quantity"/>
					<form:errors style="color:red" path="quantity"/>
 				</div>
 				<!-- Must include this line so userId can be linked to book -->
 				<form:hidden path="donor" value="${userId }"/>
 				<form:errors style="color:red" path="donor"/><!-- 
 				 --><button type="submit">Submit</button>
 			</form:form>
 		</div>
 	</div>
</body>
</html>