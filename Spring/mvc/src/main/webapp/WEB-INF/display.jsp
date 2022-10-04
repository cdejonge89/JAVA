<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book test</title>
</head>
<body>

	<h2>This renders all books</h2>
	<p><a href="/books/new">Create</a>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Language</th>
				<th>Pages</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="book" items="${books }">
				<tr>
					<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.description}"></c:out>
					<td><c:out value="${book.language}"></c:out></td>
					<td><c:out value="${book.numberOfPages}"></c:out></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>