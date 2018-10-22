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
				<h2 id = "editItem"> Choose an item and update.</h2>
				
				<form class = "form-horizontal" action="/submit-item" method = "post">
			
					<!--  <div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "id">Item id:</label> 
					<input class = "form-control col-sm-8" name="id" placeholder="Enter Id">
					</div>-->
				
					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "name">Item name:</label> 
					<input class = "form-control col-sm-8" name="name" required minlength = "2"/ placeholder="Enter Item Name">
					</div>
					
					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "description">Description: </label>
					<input class = "form-control col-sm-8" name="description" required/ placeholder="Enter description">
					</div>  


					<div class="form-group row">
      				<label class="control-label col-sm-4 text-left" for="quantity">Quantity:</label>
					<input class = "form-control col-sm-8" type = "number" name = "quantity">
					</div>
					
					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "price">Price:</label>
					<input class = "form-control col-sm-8" type = "text" name="price" required/ placeholder="price">
					</div>
					
					 <div class="form-group">
      					<div class="col-sm-offset-2 col-sm-10">
        				<div class="checkbox">
         				 <label><input type="checkbox" name="remember"> Remember me</label>
       				 </div>
     				 </div>
     				 </div>
					
					<p>
					<button a href = "/submit-item">Add Item</button>
					</p>
					
					
				</form>
			</div>
	</body>

</html>