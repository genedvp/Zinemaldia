<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel de Control Usuario</title>
<link rel="stylesheet" href="emision/animaciones.css"><link>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
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
	<div class="container-fluid">
		<div class="row">
			<div id="barraLateral" class="d-flex col-2 col-sm-3 col-lg-2 flex-nowrap bg-white flex-sm-column flex-column text-start" max-widht="200px">
				<p class="text-body-dark mt-4 fs-2 sm-p">Panel de Control</p>
				<a href="IndexPelicula" class="text-body-secondary text-decoration-none fs-5 scala">Peliculas
				</a>
				<br>
				<a href="IndexSala" class="text-body-secondary text-decoration-none fs-5 scala">Salas
				</a> 
				<br> 
				<a href="IndexEmision"class="text-body-secondary text-decoration-none fs-5 scala">Emisiones
				</a> 
				<br> 
				<a href="IndexUsuario" class="text-body-secondary text-decoration-none fs-5 fw-medium selecionado">Usuario
				</a>
			</div>
			<div class="flex-column col-7 col-sm-8 col-lg-9 mt-4">
				<div class="m-4">
					<a href="CreateUsuario"> <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="white" class="bi bi-plus-lg" viewBox="0 0 16 16">
	                	<path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2" />
					</a>
				</div>
				<table class="table table-dark table-striped table-hover">
					<thead>
						<tr class="table-active">
							<th scope="col">id</th>
							<th scope="col">usuario</th>
							<th scope="col">Contraseņa</th>
							<th scope="col">Rol</th>
							<th></th>
							<th scope="col">Historial</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuarios}" var="usuario">
							<tr class="table-active">
								<td>${usuario.idUsuario}</td>
								<td>${usuario.correo}</td>
								<td>${usuario.contra}</td>
								<td>${usuario.rol}</td>
								<td>
								<a href="ShowUsuario?id=${usuario.idUsuario}"> <svg
											xmlns="http://www.w3.org/2000/svg" width="25" height="25"
											fill="white" class="bi bi-search" viewBox="0 0 16 16">
											<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" /></svg>
								</a> 
								<a href="EditUsuario?id=${usuario.idUsuario}"> <svg
											xmlns="http://www.w3.org/2000/svg" width="25" height="25"
											fill="white" class="bi bi-pencil" viewBox="0 0 16 16">
  											<path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325" /></svg>
								</a> 
								<a href="DestroyUsuario?id=${usuario.idUsuario}"> <svg
											xmlns="http://www.w3.org/2000/svg" width="25" height="25"
											fill="white" class="bi bi-eraser-fill" viewBox="0 0 16 16">
  											<path d="M8.086 2.207a2 2 0 0 1 2.828 0l3.879 3.879a2 2 0 0 1 0 2.828l-5.5 5.5A2 2 0 0 1 7.879 15H5.12a2 2 0 0 1-1.414-.586l-2.5-2.5a2 2 0 0 1 0-2.828zm.66 11.34L3.453 8.254 1.914 9.793a1 1 0 0 0 0 1.414l2.5 2.5a1 1 0 0 0 .707.293H7.88a1 1 0 0 0 .707-.293z" /></svg>
								</a>
								</td>
								<td><a href="ShowFactura?id=${usuario.idUsuario}" class="text-light"> Ver Facturas</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
		crossorigin="anonymous">
</body>
</html>