<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="header">
		<a href="/songs/create">Add New</a>
		<a href="/search/topTen">Top Songs</a>
	    <form action="/search" method="post">
			<input type="text" name="artist" placeholder="Search Artist"/>
			<input class="button" type="submit" value="Submit"/>
		</form>
	</div>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachSong" items="${songList}">
					<tr>
						<td>
							<a href="/songs/details/${eachSong.id}">
							<c:out value="${eachSong.title}"></c:out>
							</a>
						</td>
						<td><c:out value="${eachSong.rating }"/></td>
						<td>
							<form action="/songs/delete/${eachSong.id }" method="post">
							<input type="hidden" name="_method" value="delete">
							<button type="submit">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</body>
</html>