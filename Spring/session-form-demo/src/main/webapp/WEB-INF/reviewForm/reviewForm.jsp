<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Form</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<body>
	<h1>Review Form</h1>
	<form method="POST" action="/process/review">
	<div>
		<label>Product</label>
		<input type="text" name="product" />
	</div>
	<div>
		<label>Rating</label>
		<input type="number" name="rating" />
	</div>
	<div>
		<label>Comments</label>
		<textarea name="comments"></textarea>
	</div>
	<button type="submit">Submit</button>
	</form>
</body>
</html>