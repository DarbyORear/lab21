<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updated Cart</title>
</head>
<body>
<h1>${cartItem.itemName} has been added to your shopping cart.</h1>
	<p>Here are all the items in your cart so far: </p>
	
		  		<table class="table table-bordered table-hover">
			<thead>
				<tr id = "table-headers">
					<th>Name</th><th>Price Per Unit</th><th>Quantity</th><th>Delete</th>
				</tr>
			</thead>
			<tbody id = "table-body">
				<c:forEach var="myCartItem" items="${cart}">
			<tr>
					<td>${myCartItem.itemName}</td>
					<td>$${myCartItem.unitPrice}0</td>
					<td>${myCartItem.itemQuantity}</td>
					<td><a href = "#">Delete</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
		<p></p>
		Keep shopping?
		<p></p>
		</div>
		
		
			  		<table class="table table-bordered table-hover">
			<thead>
				<tr id = "table-headers">
					<th>Name</th><th>Description</th><th>Price Per Unit</th><th>Quantity</th><th>Add to Cart</th>
				</tr>
			</thead>
			<tbody id = "table-body">
				<c:forEach var="myitem" items="${items}">
			<tr>
					<td>${myitem.name}</td>
					<td>${myitem.description}</td>
					<td>$${myitem.price}0</td>
					<td><input type = "number" value = "${myitem.quantity}"></td>
					<td><a href = "/add-to-cart/${myitem.id}">Add Item</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action = "/logout"><button>Logout</button></form>
		
	



</body>
</html>