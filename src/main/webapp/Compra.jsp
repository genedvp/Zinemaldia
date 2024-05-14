<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compra de Entradas</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
	<div class="row m-3">
		<div class=" text-center text-light">
			<blockquote class="blockquote">
	    		<p class="h3">Festival de Cine de San Sebastian</p>
	  		</blockquote>
		<div class="blockquote-footer m-2">
			<p> En euskera Zinemaldia significa el tiempo de cine, un tiempo que ya no se circunscribe exclusivamente al evento de nueve dias que San Sebastian acoge en septiembre. <cite title="Source Title">Donostiako Zinemaldia</cite></p>
		</div>
		</div>
	</div>
	<c:forEach items="${emisiones}" var="emision" varStatus="loop">
	<!-- emisiones peliculas TARJETAS  --> 
	<div class="row">
		<div class="col-2"></div>
			<div class="col-8 mb-4 d-flex justify-content-center">
				<div class="card mt-4" style="width: 100%; max-width: 800px; height: 100%; max-height:600px">
			  		<div class="row g-0">
			    		<div class="col"><img src="img/img${loop.index}.jpg"  style="height:300px" class="img-fluid rounded-start" alt="imagen${loop.index}"></div>
			    			<div class="col">
			       				<div class="card-body ">
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
		<div class="col-2"></div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal${loop.index}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<h1 class="modal-title fs-5" id="exampleModalLabel">Confirmacion de Compra</h1>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	     		</div>
	     		<div class="nav nav-tabs" id="myTab${loop.index}" role="tablist">
	   			<button class="nav-link active" id="home-tab${loop.index}" data-bs-toggle="tab" data-bs-target="#home-tab-pane${loop.index}" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">Iniciar Sesion</button>
	    		<button class="nav-link" id="profile-tab${loop.index}" data-bs-toggle="tab" data-bs-target="#profile-tab-pane${loop.index}" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">Registrarse</button>
				</div>
	  	 		<div class="tab-content m-3" id="myTabContent${loop.index}">
					<div class="tab-pane fade show active" id="home-tab-pane${loop.index}" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
							<form action="StoreCompraUsuarioRegistrado" method="POST">
							      	<input type="hidden" value="${emision.id}" name="idEmision"/>
							  		<div class="mb-3">
							    		<label for="exampleInputEmail1" class="form-label">Correo Electronico</label>
							    		<input type="email" class="form-control" id="correo" name="correo" aria-describedby="emailHelp">
							   			<div id="emailHelp" class="form-text">ejemplo@ejemplocorreo.com</div>
							  		</div>
							 		<div class="mb-3">
							    		<label for="exampleInputPassword1" class="form-label">Contraseñaa</label>
							    		<input type="password" class="form-control" id="contra" name="contra">
							  		</div>
							  		<div class="modal-footer">
				        			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
				       				<button type="submit" class="btn btn-secondary">Comprar</button>
				     				</div>
							</form>
					</div>
			      	<div class="tab-pane fade" id="profile-tab-pane${loop.index}" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
			      			<form action="StoreCompraUsuarioNoRegistrado" method="POST">
						      	<input type="hidden" value="${emision.id}" name="idEmision"/>
								
								<p class="mt-3">Nombre:</p>
								<input type="text" class="form-control" name="nombre"
									value="${usuario.nombre}" />
									
								<p class="mt-3">Apellidos:</p>
								<input type="text" class="form-control" name="apellidos"
									value="${usuario.apellidos}" />
								
								<p class="mt-3">Correo Electronico</p>
								<input type="email" class="form-control" id="contra" name="correo" 
									value="${usuario.correo}"/>
								<div id="emailHelp" class="form-text">ejemplo@ejemplocorreo.com</div>
									
								<p class="mt-3">Contrasena:</p>
								<input type="password" class="form-control" name="contra"
									value="${usuario.contra}" /> 
								
								<p class="mt-3">Rol:</p>
								<select class="form-select" id="inputRol" name="rol">
			    					<option value="usuario" ${usuario.rol.equals("usuario") ? "selected" : ""}>Usuario</option>
			    					<option value="administrador" ${usuario.rol.equals("administrador") ? "selected" : ""}>Administrador</option>
								</select>
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