<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Register</title>
	<link rel = "stylesheet" href = "/style.css">
	<link rel = "stylesheet" href="https://bootswatch.com/4/solar/bootstrap.min.css">
	
</head>

	<body>
	<div class = "container">
				<h2 id = "registration-heading"> Please fill out the form to register.</h2>
				
				<form class = "form-horizontal" action="/practiceform" method = "post">
				
					<div class = "form-group row">
					<label id = "nameid" class = "control-label col-sm-4 text-left" for = "firstname">First Name:</label> 
					<input class = "form-control col-sm-8" id = "firstname" name="firstname" required minlength = "2"/ placeholder="Enter First Name">
					</div>
					
					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "lastname">Last Name: </label>
					<input class = "form-control col-sm-8" id = "lastname" name="lastname" required/ placeholder="Enter Last Name">
					</div>  


					<div class="form-group row">
      				<label class="control-label col-sm-4 text-left" for="email">Email:</label>
					<input class = "form-control col-sm-8" type = "email" id = "email" placeholder = "Enter email" name = "email">
					</div>
					
					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "phonenum">Phone Number:</label>
					<input class = "form-control col-sm-8" name="phonenum" required/ placeholder="###-###-####">
					</div>

					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "password">Password:</label>
					<input class = "form-control col-sm-8" name="password" type= "password" required minlength = "8"/ placeholder="Enter Password">
					</div>
					
					 <div class="form-group">        
      					<div class="col-sm-offset-2 col-sm-10">
        				<div class="checkbox">
         				 <label><input type="checkbox" name="remember"> Remember me</label>
       				 </div>
     				 </div>
     				 </div>
					
					<p>
					<button>Sign Up</button>
					</p>
					
					
				</form>
			</div>
	</body>

</html>