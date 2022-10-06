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
<title>Languages</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="language" items="${langList }">
				<tr>
					<td>
						<a href="/languages/${language.id }">
							<c:out value="${language.name }"/>
						</a>
					</td>
					<td><c:out value="${language.creator }"/></td>
					<td><c:out value="${language.version }"/></td>
					<td>
						<a href="/languages/${language.id }/edit">Edit</a>
						<form action="/languages/${language.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					    </form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h1>Add a Language</h1>
	<form:form method="POST" action="/process/add" 
			modelAttribute="newLanguage">
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

		<button type="submit"> Submit</button>
	</form:form>
	
</body>
</html>