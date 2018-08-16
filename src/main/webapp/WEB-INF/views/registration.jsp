<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h2>Please fill out the form to register.</h2>
	<!-- Form action determines the next URL path -->
	<form action="/summary">
		<p>
			First Name: <input name="firstname"/>
		</p>
		<p>
			Last Name: <input name="lastname"/>
		</p>
		<p>
			Email: <input name="email"/>
		</p>
		<p>
			Phone Number: <input name="phonenum"/>
		</p>
		<p>
			Password: <input name="password"/>
		</p>	
		<p>
			<button>Register</button>
		</p>
	
	</form>

</body>
</html>