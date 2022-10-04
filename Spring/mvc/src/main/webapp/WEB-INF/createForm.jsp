<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book test</title>
</head>
<body>
	<h1>Create form</h1>
	<form method="POST" action="/books/create/process">
		<div>
			<label>Title</label>
			<input type="text" name="title" />
		</div>
		<div>
			<label>Description</label>
			<textarea name="description" ></textarea>
		</div>
		<div>
			<label>Language</label>
			<input type="text" name="language" />
		</div>
		<div>
			<label>Pages</label>
			<input type="number" name="numOfPages" />
		</div>
		<button type="submit">Create</button>
	</form>

</body>
</html>