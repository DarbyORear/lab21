<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoffeeShop</title>
<link rel = "stylesheet" href = "/style.css">
<link rel = "stylesheet" href="https://bootswatch.com/4/solar/bootstrap.min.css">
</head>
<body>
	<div class = "container">
	<div class = "intro-stuff">
	<h1>Welcome to the Java Bean!</h1>
		<p id = "attentiongrab"> Get gourmet coffee delivered straight to your door </p>
	<img id = "coffee" src = "/images/coffeecupimage.jpg"/>
	</div>
	
		<div class="menu">
		<p></p>
		<h3>Menu</h3>
		<table class="table table-bordered table-hover">
			<thead>
				<tr id = "table-headers">
					<th>Name</th><th>Description</th><th>Quantity</th><th>Price</th><th>Delete</th><th>Edit</th>
				</tr>
			</thead>
			<tbody id = "table-body">
				<c:forEach var="myitem" items="${items}">
					
		  	<tr>
					<td>${myitem.name}</td>
					<td>${myitem.description}</td>
					<td><input type = "number" value = ""></td>
					<td>$${myitem.price}0</td>
					<td><a href ="/item/${myitem.id}/delete">Delete Item</a></td>
				<!-- <td><a href ="/item/${myitem.id}/update">Edit Item</a></td> -->
					<td><a href ="/edit-item/${myitem.id}">Edit Item</a></td>
					
				</tr>
		
			
		<!--  	<tr>
					<td>${myitem.name}</td>
					<td>${myitem.description}</td>
					<td>$${myitem.price}0</td>
				</tr>
-->
				</c:forEach>
			</tbody>
		</table>
		
		<a href = "/add-item" class = "btn btn-tertiary inline" id = "btn-login3">Add Item</a>
		<a href = "/" class = "btn btn-tertiary inline" id = "btn-login3">Home</a>
	
		
	</div>
</div>
</body>
</html>