<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Venta::</title>
</head>

<body>
	<div class="container">
	<h1>Ventas</h1>
			<hr>
	<h2>Informar Ventas</h2>
		<form:form method="post" action="/venta/login" modelAttribute="venta">
			<input type="hidden" name="_method" value="put">
			<form:label path="comprador" class="col-sm-2 col-form-label">Comprador:</form:label>
			<form:input type="text" path="comprador" class="form-control"/>
			<br>
			<form:label path="codigo" class="col-sm-2 col-form-label">Codigo:</form:label>
			<form:input type="text" path="codigo" class="form-control"/>
			<br>
			
					
			<a href="/venta" class="btn btn-success" role="button" data-bs-toggle="button">Limpiar</a>
			<input type="submit" class="btn btn-primary" value="Submit">

		</form:form>
	
		<br>
		<hr>
		<h2>Crear ventas</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Comprador</th>
		      <th scope="col">Codigo</th>
		      <th scope="col-2">Acciones</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${listaVentas}" var="venta" >
			    <tr>
			      <th scope="row">${venta.getId()}</th>
			      <td>${venta.getComprador()}</td>
			      <td>${Venta.getCodigo()}</td>
			      <td>
			      <a href="/venta/${venta.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
			      
			      </td>
			      <td>
				      <form action="/venta/eliminar" method="get">
				      	<input type="hidden" name="id" value="${id.getId()}">
				      	<input class="btn btn-danger" type="submit" value="Eliminar">
				      </form>
			      </td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
</body>

</html>