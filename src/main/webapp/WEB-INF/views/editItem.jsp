<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Edit Item in Inventory</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel = "stylesheet" href = "/style.css">
</head>

	<body>
	<div class = "container">
				<h2 id = "editItem"> Update item: ${item.name}</h2>
				
				<!-- Commenting out temporarily to figure out what the action needs to be 1/29/19 -->
				<!--  <form class = "form-horizontal" action="/item/{id}/update" method = "post"> -->
				
				<form class = "form-horizontal" action="/item/${item.id}/update" method = "post">
				
			
					<!--  <div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "id">Item id:</label> 
					<input class = "form-control col-sm-8" name="id" placeholder="Enter Id">
					</div>-->
				
					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "name">Item name:</label> 
					<input class = "form-control col-sm-8" name="name" required minlength = "2" placeholder="${item.name}">
					</div>
					
					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "description">Description: </label>
					<input class = "form-control col-sm-8" name="description" placeholder="${item.description}">
					</div>  


					<div class="form-group row">
      				<label class="control-label col-sm-4 text-left" for="quantity">Quantity:</label>
					<input class = "form-control col-sm-8" type = "number" name ="quantity" placeholder = "${item.adminQuantity}">
					</div>
					
					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "price">Price:</label>
					<input class = "form-control col-sm-8" type = "text" name="price" placeholder="${item.price}">
					</div>
					
					<p>
					<button>Edit Item</button>
					</p>
					
				</form>
			</div>
	</body>

</html>