<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Login::</title>
</head>

<body>

	<br>
	<div class="container card bg-light border-info">
		<h1>Login</h1>
			<hr>
	<h2>Ingreso al sistema</h2>
	
		<form action="/usuario/login" method="post">
			<label for="username">Nombre:</label>
			<input type="text" class="form-control" name="username" placeholder="Ingresa tu nombre">
			<br>
			<label for="password">Password:</label>
			<input type="password" class="form-control" name="password" placeholder="Ingresa tu password">
			<br>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
			<input type="submit" class="btn btn-primary" value= "Ingresar">
		</form>
		


	</div>

</body>

</html>