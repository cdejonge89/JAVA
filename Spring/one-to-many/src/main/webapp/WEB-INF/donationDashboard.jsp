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
<title>Donation Board</title>
</head>
<body>
	<h1>1:n Donations (one to many)</h1>
	<p>
		<a href="/users/new">Create a new user</a>
		<a href="/donations/new">Create a new donation</a>
	</p>
	
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
					<td>${eachDonation.donor.username}</td>
					<td>
						<a href="/donations/edit/${eachDonation.id }">Edit</a>
						<form action="/donations/delete/${eachDonation.id }" method="post">
							<input type="hidden" name="_method" value="delete">
							<button type="submit">Delete</button>
						</form> 
					</td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>
	
	<h2>Users</h2>
	<table>
		<thead>
			<tr>
				<th>Username</th>
				<th>Email</th>
				<th>Number of Donations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachUser" items="${userList }">
				<tr>
					<td>
						<a href="/users/${eachUser.id }">
						<c:out value="${eachUser.username }"/>
						</a>
					</td>
					<td><c:out value="${eachUser.email }"/></td>
					<td> ${eachUser.sentDonations.size() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>