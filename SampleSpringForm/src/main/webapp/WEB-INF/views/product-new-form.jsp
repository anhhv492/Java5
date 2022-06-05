<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>New Product Spring Form</h1>
	<form:form method="GET" modelAttribute="product"
		action="/product/detail-form">
		<p> Name: 
			<input type="text" name="name"/> 
		</p>
		<p> Price: 
			<input type="number" name="price"/> 
		</p>
		<p> Quantity: 
			<input type="number" name="quantity"/> 
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>