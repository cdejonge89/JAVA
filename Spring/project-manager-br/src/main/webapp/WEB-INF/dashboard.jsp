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
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="header">
        <h1>Welcome ${userName }</h1>
        <a href="/logout">Logout</a> |
        <a href="/projects/new">Add a project</a>
        
    </div>
    <div class="container">
    	<h3>All projects</h3>
			<table>
				<thead>
					<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="eachProject" items="${ projectList}">
					<c:if test="${eachProject.teamlead.id != userId }">
						<tr>
							<td>
								<a href="/projects/${eachProject.id }">
								<c:out value="${eachProject.title }"/>
								</a>
							</td>
							<td><c:out value="${eachProject.teamlead.userName}"/></td>
							<td><fmt:formatDate value="${eachProject.dueDate}"/></td>
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>
			
			<h3>My Projects</h3>
			<table>
				<thead>
					<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="eachProject" items="${ projectList}">
					<c:if test="${eachProject.teamlead.id.equals(userId) }">
						<tr>
							<td>
								<a href="/projects/${eachProject.id }">
								<c:out value="${eachProject.title }"/>
								</a>
							</td>
							<td><c:out value="${eachProject.teamlead.userName}"/></td>
							<td><fmt:formatDate value="${eachProject.dueDate}"/></td>
							<td><a href="/projects/edit/${eachProject.id }">Edit</a></td>
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>
	</div>
	
</body>
</html>

