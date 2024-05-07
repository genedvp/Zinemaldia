<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compra de Entradas</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<body class="bg-dark">
<header>
		<nav class="navbar bg-black">
			<div class="container-fluid">
				<a class="navbar-brand" href="IndexPelicula">
					<img src="img\Logo_zinemaldia.png" alt="Logo" width="68"
					height="50" class="d-inline-block align-text-top">
				</a>
			</div>
		</nav>
	</header>
<form action="StoreCompra" method="POST">
<c:forEach items="${emisiones}" var="emision" varStatus="loop">
<!-- peliculas  --> 
<div class="row">
<div class="col">
</div>
<div class="col">
<div class="card mt-4" style="max-width: 540px;">
  <div class="row g-0">
    <div class="col-md-4">
     <img src="img\img${loop.index}.jpg" class="img-fluid rounded-start" alt="imagen${loop.index}"> 
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">${emision.pelicula.titulo}</h5>
        <p class="card-text">${emision.pelicula.descripcion}</p>
        <p class="card-text"><small class="text-body-secondary">${emision.fecha}</small></p>
        <p class="card-text"><small class="text-body-secondary">${emision.hora}</small></p>
		<input type="submit" value="Comprar" name="Comprar"
		class="btn btn-secondary btn-block">      
      </div>
    </div>
  </div>
</div>
</div>
<div class="col">
</div>
</div>
</c:forEach >
</form>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
		crossorigin="anonymous">
</body>
</html>