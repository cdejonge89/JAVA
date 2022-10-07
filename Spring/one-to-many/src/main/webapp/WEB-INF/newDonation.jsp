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
	<h1>Create a donation</h1>
	<form:form action="/donations/process" method="POST" modelAttribute="newDonation">
		<p>
			<form:label path="itemName">Item Name</form:label>
			<form:input path="itemName"/>
			<form:errors style="color:red" path="itemName"/>
		</p>
		<p>
			<form:label path="quantity">Quantity</form:label>
			<form:input tyep="number" path="quantity"/>
			<form:errors style="color:red" path="quantity"/>
		</p>
		<p>
			<form:label path="donor"> Pick a donor </form:label>
		</p>
			<form:select path="donor">
				<c:forEach var="eachUser" items="${userList}">
					<form:option value="${eachUser.id }">${eachUser.username } - ${eachUser.email }</form:option>
				</c:forEach>
			</form:select>
				
			<form:errors style="color:red" path="donor"/>
			<button type="submit">Submit</button>
	</form:form>
</body>
</html>