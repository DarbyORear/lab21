<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoffeeShop: Home</title>
<link rel = "stylesheet" href="https://bootswatch.com/4/solar/bootstrap.min.css">
<link rel = "stylesheet" href = "/style.css">


</head>
<body>
	<div class = "container" id = "indexpg">
	<h5>Please note that this website is for demonstration purposes only and is not a functioning e-commerce site.</h5>
	<div class = "intro-stuff">
	<h1>Welcome to the Java Bean!</h1>
		<p id = "attentiongrab"> Get gourmet coffee delivered straight to your door </p>
	<img id = "coffee" src = "/images/coffeecupimage.jpg"/>
	</div>
	
		<div class="container">
		<p></p>
		<h3>Menu</h3>
		<table class="table table-bordered table-hover">
			<thead>
				<tr id = "table-headers">
					<th>Name</th><th>Description</th><th>Price</th>
				</tr>
			</thead>
			<tbody id = "table-body">
				<c:forEach var="myitem" items="${items}">
			
			<tr>
					<td>${myitem.name}</td>
					<td>${myitem.description}</td>
					<td>$${myitem.price}0</td>
				</tr>

				</c:forEach>
			</tbody>
		</table>
	<div class = "login-buttons" class = "text-center">
			<a href = "/user-login" class = "btn btn-tertiary" id = "btn-login1">Login</a>
			<a href = "/admin-login" class = "btn btn-tertiary" id = "btn-login2">Admin Login</a>
		<div id = "click-text">
		<p>Don't have an account yet?<br/>
		Click the button below to sign up!</p>
		</div>
	
				<a href = "/register" class = "btn btn-tertiary" id = "btn-login3">Create Account</a>
			</div>
	</div>
</div>
</body>
</html>