<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Options</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Coffee Shop Options</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Description</th><th>Quantity</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${items}">
				<tr>
					<td><a href="/items/${item.id}">${item.name}</a></td>
					<td>${item.description}</td>
					<td>${item.quantity}</td>
					<td>${item.price}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>Want to purchase an item? Click the button below to register!</p>
	</div>
	<button><a href = "/registration">Add A Room</a></button>
</body>
</html>