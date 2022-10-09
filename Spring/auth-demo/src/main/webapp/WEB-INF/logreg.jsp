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
<title>Donation</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="left">
			<h1>Register</h1>
			<form:form action="/register" method="POST" modelAttribute="newUser">
				<p>
					<form:label path="userName">User Name:</form:label>
					<form:input path="userName"/>
				</p>
					<form:errors style="color:red" path="userName"/>
				
				<p>
					<form:label path="email">Email:</form:label>
					<form:input path="email"/>
				</p>
					<form:errors style="color:red" path="email"/>
				
				<p>
					<form:label path="password">Password:</form:label>
					<form:input type="password" path="password"/>
				</p>
					<form:errors style="color:red" path="password"/>
				
				<p>
					<form:label path="confirm">Confirm Password:</form:label>
					<form:input type="password" path="confirm"/>
				</p>
					<form:errors style="color:red" path="confirm"/>
				
				<button type="submit">Register</button>
				</form:form>
			</div>
			
			<div class="right">
				<h1>Login</h1>
				<form:form action="/login" method="POST" modelAttribute="newLogin">
					<p>
						<form:label path="email">Email:</form:label>
						<form:input path="email"/>
					</p>
						<form:errors style="color:red" path="email"/>
					
					<p>
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
					</p>
						<form:errors style="color:red" path="password"/>
					<button type="submit">Login</button>
				</form:form>
			</div>
			
		

	</div>

</body>
</html>