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
<title>Insert title here</title>
</head>
<body>
	<a href="/dashboard">Home</a>
	<form:form method="POST" action="/process/add" modelAttribute="newSong">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title"/>
			<form:errors style="color:red" path="title"/>
		</p>
		<p>
			<form:label path="artist">Artist:</form:label>
			<form:input path="artist"/>
			<form:errors style="color:red" path="artist"/>
		</p>
		<p>
			<form:label path="rating">Rating:</form:label>
			<form:input type="number" path="rating"/>
			<form:errors style="color:red" path="rating"/>
		</p>
		<button type="submit">Add Song</button>
	</form:form>
</body>
</html>