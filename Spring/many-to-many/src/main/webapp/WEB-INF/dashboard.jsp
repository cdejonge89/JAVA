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
<title>Donations Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="bookPage">
			<!-- User Name is accessible through session, make sure to pass session in controller mapping -->
			<h1>Welcome, ${userName }</h1>
			<a href="/logout">Logout </a>
			<a href="/donations/new">+ Add a new donation</a>
		</div>
		<div class="body">
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
							<td>${eachDonation.donor.userName}</td>
							
								<c:choose>
									<c:when test="${userId.equals(eachDonation.donor.id)}">
										<td>
											<a href="/donations/edit/${eachDonation.id }">Edit</a>
											<form action="/donations/delete/${eachDonation.id }" method="post">
												<input type="hidden" name="_method" value="delete">
												<button type="submit">Delete</button>
											</form> 
										</td>
									</c:when>
									<c:when test="${eachDonation.receivers.contains(loggedUser) }">
										<td>
										<form method="POST" action="donations/${eachDonation.id }/return">
											<input type="hidden" name="_method" value="put">
											<button type="submit" style="background-color:DarkGoldenRod">Return</button>
										</form>
										</td>
									</c:when>
									<c:otherwise>
										<td>
										<form method="POST" action="donations/${eachDonation.id }/receive">
											<input type="hidden" name="_method" value="put">
											<button type="submit" style="background-color:orange">Receive</button>
										</form>
										</td>
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