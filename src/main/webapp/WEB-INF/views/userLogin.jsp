<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
	<link rel = "stylesheet" href = "/style.css">
	<link rel = "stylesheet" href="https://bootswatch.com/4/solar/bootstrap.min.css">
</head>
<body>
<div class = "container">
<h3 id = "enterLogin">Please enter your username and password to continue.</h3>
<form action = "/user-verify" class = "form-horizontal">

		<div class = "form-group row">
					<label id = "nameid" class = "control-label col-sm-4 text-left" for = "username">Username:</label> 
					<input class = "form-control col-sm-8" id = "username" name="username" minlength = "2" placeholder="Enter Username">
					</div>
					
					<div class = "form-group row">
					<label class = "control-label col-sm-4 text-left" for = "password">Password: </label>
					<input class = "form-control col-sm-8" id = "password" name="password" placeholder="Enter Password">
					</div>  
<button class = "btn btn-tertiary" id = "btn-login2">Login</button>
</form>
</div>
</body>
</html>