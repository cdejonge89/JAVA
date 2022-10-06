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
<title>Edit</title>
</head>
<body>
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		    <input type="hidden" name="_method" value="put">
				<p>
			<form:label path="name">Language</form:label>
			<form:input path="name" />
			<form:errors style="color:red" path="name" />
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:input path="creator" />
			<form:errors style="color:red" path="creator" />
		</p>
		<p>
			<form:label path="version">Version</form:label>
			<form:input type="number" path="version" />
			<form:errors style="color:red" path="version" />
		</p>
		<button type="submit">Update</button>
	</form:form>

	<a href="/languages">Dashboard</a>
</body>
</html>