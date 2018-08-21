<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>blah</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel = "stylesheet" href = "/style.css">
</head>
<body>


<div class="container">
  <h2>Choose Your Coffee</h2>
  <h3>Flavor options:</h3>
  <h5>Vanilla Mocha Caramel Mint</h5>
  <form class="form-horizontal" action="/index">
    <div class="form-group row">
      <label class="control-label col-sm-4" for="email">Cappuccino</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="flavorcap" placeholder="Enter flavor">
      </div>
       <div class="col-sm-4">
        <input type="number" class="form-control" id="numcap" placeholder="How many?">
      </div>
    </div>
    <div class="form-group row">
      <label class="control-label col-sm-4" for="email">Latte</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="flavorlatte" placeholder="Enter flavor">
      </div>
       <div class="col-sm-4">
        <input type="number" class="form-control" id="numlatte" placeholder="How many?">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>


</body>
</html>