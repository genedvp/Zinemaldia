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

<div class="row mt-4">
	<div class="col-1">
	</div>
		<div class="col-11">
		<h3 class="text-light fw-bold">Cartelera Zinemaldia 2024</h3>
	</div>
</div>
<c:forEach items="${emisiones}" var="emision" varStatus="loop">
	<!-- emisiones peliculas TARJETAS  --> 
	<div class="row">
		<div class="col-4">
		</div>
		<div class="col-8">
			<div class="card mt-4" style="max-width: 540px;">
			  <div class="row g-0">
			    <div class="col">
			     <img src="img\img${loop.index}.jpg" class="img-fluid rounded-start" alt="imagen${loop.index}"> 
			    </div>
			    <div class="col">
			       <div class="card-body">
			        	 <h5 class="card-title">${emision.pelicula.titulo}</h5>
			       		 <p class="card-text">${emision.pelicula.descripcion}</p>
			       		 <p class="card-text"><small class="text-body-secondary">${emision.fecha}</small></p>
			     		 <p class="card-text"><small class="text-body-secondary">${emision.hora}</small></p>
						 <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal${loop.index}">Comprar</button>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
		<div class="col">
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal${loop.index}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmación de Compra</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="nav nav-tabs" id="myTab" role="tablist">
	   			<button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">Iniciar Sesión</button>
	    		<button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">Registrarse</button>
		</div>
	  	 <div class="tab-content m-3" id="myTabContent">
				       <div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
					      	<form action="StoreCompra" method="POST">
						      	<input type="hidden" value="${emision.id}" name="idEmision"/>
						  		<div class="mb-3">
						    		<label for="exampleInputEmail1" class="form-label">Correo Electrónico</label>
						    		<input type="email" class="form-control" id="correo" name="correo" aria-describedby="emailHelp">
						   			<div id="emailHelp" class="form-text">ejemplo@ejemplocorreo.com</div>
						  		</div>
						 		<div class="mb-3">
						    		<label for="exampleInputPassword1" class="form-label">Contraseña</label>
						    		<input type="password" class="form-control" id="contra" name="contra">
						  		</div>
						  		<div class="modal-footer">
			        			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			       				<button type="submit" class="btn btn-secondary">Comprar</button>
			     				</div>
							</form>
						</div>
			      	<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
			      			<form action="StoreCompra" method="POST">
						      	<input type="hidden" value="${emision.id}" name="idEmision"/>
						  		<input type="hidden" name="id" 
									value="${usuario.id}" />
								
								<p class="mt-3">Nombre:</p>
								<input type="text" class="form-control" name="nombre"
									value="${usuario.nombre}" />
									
								<p class="mt-3">Contraseña:</p>
								<input type="text" class="form-control" name="contra"
									value="${usuario.contra}" /> 
								
								<p class="mt-3">Rol:</p>
								<select class="form-select" id="inputRol" name="rol">
			    					<option value="usuario" ${usuario.rol.equals("usuario") ? "selected" : ""}>Usuario</option>
			    					<option value="administrador" ${usuario.rol.equals("administrador") ? "selected" : ""}>Administrador</option>
								</select>
									<input type="submit"
									value="Guardar" name="Guardar"
									class="btn btn-secondary btn-block mt-4">
								<div class="modal-footer">
			        			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			       				<button type="submit" class="btn btn-secondary">Comprar</button>
			     				</div>
							</form>
				  </div>
			</div>
		</div>
	  </div>
	</div>
</c:forEach >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>