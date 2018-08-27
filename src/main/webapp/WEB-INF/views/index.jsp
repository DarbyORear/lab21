<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoffeeShop</title>
<link rel = "stylesheet" href = "/style.css">
</head>
<body>
	<div class = "div">
	<h1>Welcome to the Java Bean!</h1>
		<p id = "attentiongrab"> Get gourmet coffee delivered straight to your door </p>
	<img id = "coffee" src = "/images/coffeecupimage.jpg"/>
	</div>
	
		<div class="container">
		<h3>Coffee Shop Options</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Description</th><th>Quantity</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
	<!-- The forEach loops through all the items and prints them out -->
	<!-- Where do the {items} come from? the controller. -->
				<c:forEach var="myitem" items="${items}">
					
				<tr>
					<td><a href="/index/${myitem.id}">${myitem.name}</a></td>
					<td>${myitem.description}</td>
					<td>${myitem.quantity}</td>
					<td>${myitem.price}</td>
					<td><a href ="/item/${myitem.id}/delete">Delete Item</a></td>
					<td><a href ="/item/${myitem.id}/update">Edit Item</a></td>
				</tr>

				</c:forEach>
			</tbody>
		</table>
		<button><a href ="/add-item">Add Item</a></button>
		
		<p>Click the button below to sign up!</p>
	</div>
	<button><a href = "/register">Create Account</a></button>
</body>
</html>