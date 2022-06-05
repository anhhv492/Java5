<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>New Product</h1>
	<form method="GET" action="/product/detail">
		<p> Name: <input type="text" name="name"/> </p>
		<p> Price: <input type="number" name="price"/> </p>
		<p> Quantity: <input type="number" name="quantity"/> </p>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>