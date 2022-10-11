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
<title>Login page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<div class="container">
	
		<div class="header">
			<h1 style="color:RebeccaPurple">Book Club</h1>
			<h3>A place for friends to share thoughts on books</h3>
		</div>
		
		<div class="body">
		
			<div class="left">
				<h2>Register</h2>
				<form:form action="/register" method="POST" modelAttribute="newUser">
					<div>
						<form:label path="userName">Name</form:label>
						<form:input path="userName"/>
						<form:errors style="color:DarkRed" path="userName"/>
					</div>
					<div>
						<form:label path="email">Email</form:label>
						<form:input path="email"/>
						<form:errors style="color:DarkRed" path="email"/>
					</div>
					<div>
						<form:label path="password">Password</form:label>
						<form:input type="password" path="password"/>
						<form:errors style="color:DarkRed" path="password"/>
					</div>
					<div>
						<form:label path="confirm">Confirm Password</form:label>
						<form:input type="password" path="confirm"/>
						<form:errors style="color:DarkRed" path="confirm"/>
					</div>
					<button type="submit">Register</button>
				</form:form>
			</div>
			
 			<div class="right">
				<h2>Login</h2>
				<form:form action="/login" method="POST" modelAttribute="newLogin">
					<div>
						<form:label path="email">Email</form:label>
						<form:input path="email"/>
						<form:errors path="email" style="color:DarkRed"/>
					</div>
					<div>
						<form:label path="password">Password</form:label>
						<form:input type="password" path="password"/>
						<form:errors path="password" style="color:DarkRed"/>
					</div>
					<button type="submit">LogIn</button>
				</form:form>
			</div> 
		</div>

	</div>

</body>
</html>
