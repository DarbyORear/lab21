<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Out</title>
<link rel = "stylesheet" href="https://bootswatch.com/4/solar/bootstrap.min.css">
<link rel = "stylesheet" href = "/style.css">
</head>
<body>
<div class = "container">
<h2>Thanks for your purchase, ${user.username}!</h2>
<h4>Your total today was: $${total}0</h4>

<a href = "/logout">Log Out</a>
<a href = "/user-view">Back to Profile</a>
</div>
</body>
</html>