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
<title>Donation full spring</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<a href="/logout">LogOut</a>
	<div class="container">
		<div class="body">
			<h1>Welcome, ${userName }</h1>
			<a href="/donations/new">Add a new donation</a>
			
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Item Name</th>
				<th>Quantity</th>
				<th>Donor</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachDonation" items="${donationList }">
				<tr>
					<td>${eachDonation.id }</td>
					<td>
						<a href="/donations/${eachDonation.id }">
						${eachDonation.itemName }
						</a>
					</td>
					<td>${eachDonation.quantity }</td>
					<td><c:out value="${eachDonation.donor.userName}"/></td>
					<!-- Logic to ensure only user looged in can edit their donations -->
					<c:choose>
						<c:when test="${userId.equals(eachDonation.donor.id) }">
							<td>
								<a href="/donations/edit/${eachDonation.id }">Edit</a>
								<form action="/donations/delete/${eachDonation.id }" method="POST">
									<input type="hidden" name="_method" value="delete"/>
									<button type="submit">Delete</button>
								</form>
							</td>
						</c:when>
						<c:otherwise>
							<td></td>
							<td></td>
						</c:otherwise>
					</c:choose>
					
				</tr>
				
			</c:forEach>
		</tbody>
	</table>
		</div>
	</div>

</body>
</html>