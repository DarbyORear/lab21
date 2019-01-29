<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Receipt for Order</title>
</head>
<body>

<h2>Thank you for your order!</h2>

<!-- I don't have a controller for this yet, but ${totalsum} needs to take
the unit price of each item in their cart and add it together.
Actually, it should just show the total sum from the userCart page,
which is where the total should be calculated first. -->
<h4>Your total is: this many dollars</h4>
<form action = "/logout"><button>Done</button></form>
<form action = "/user-view"><button>Continue Shopping</button></form>

</body>
</html>