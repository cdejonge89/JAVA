<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<a href="/dashboard">Home</a>
	<form action="/search" method="post">
		<input type="text" name="artist" placeholder="Search Artist"/>
		<input class="button" type="submit" value="New Search"/>
	</form>
	<h1>Songs by Artist: <c:out value="${artist}"/></h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="artist" items="${songs}">
				<tr>
					<td><c:out value="${artist.title }"/></td>
					<td><c:out value="${artist.rating }"/></td>
					<td>
						<form action="/songs/delete/${artist.id }" method="post">
						<input type="hidden" name="_method" value="delete">
						<button type="submit">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>