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
<title>Books Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="bookPage">
			<h1>Welcome, ${userName }</h1>
			<a href="/logout">Logout </a>
			<a href="/books/new">+ Add a book to my shelf</a>
		</div>
		<div class="body">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Title/th>
						<th>Author Name</th>
						<th>Posted By</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="books" items="${ bookList}">
						<tr>
							<td><c:out value="${books.id }"/></td>
							<td>
								<a href="/books/details/${books.id }">
								<c:out value="${books.title }"/>
								</a>
							</td>
							<td><c:out value="${books.author }"/></td>
							<td><c:out value="${books.book.userName }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>