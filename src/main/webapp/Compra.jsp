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
<body class="bg-dark bg-gradient">
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
	<c:if test="${msg=='CompraStored'}">
		<div class="alert alert-success alert-dismissible fade show" role="alert">
			<strong>�Enhorabuena!</strong> �Tu compra ha sido realizada exitosamente!
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
    </c:if>
    <c:if test="${msg=='CompraNotStored'}">
	    <div class="alert alert-danger alert-dismissible fade show" role="alert">
			<strong>error</strong> �Tu compra NO se ha podido realizar!
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
   	 </c:if>
	<div class="row">
		<div class="text-center bg-white text-dark">
	    		<p class="display-2">DONOSTIA ZINEMALDIA</p>
		</div>
	</div>
	<div id="carouselExampleIndicators" class="carousel slide">
	  <div class="carousel-indicators">
		    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
		    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
		    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
	  </div>
	  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="img/carrusel_1.jpg" class="d-block w-100" alt="carrusel_1">
		    </div>
	    <div class="carousel-item">
	      	<img src="img/carrusel_2.jpg" class="d-block w-100" alt="carrusel_2">
	    </div>
	    <div class="carousel-item">
	      	<img src="img/carrusel_3.jpg" class="d-block w-100" alt="carrusel_3">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Anterior</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Siguiente</span>
	  </button>
	</div>
	<div class="text-center bg-white text-dark">
	    <p class="display-3">CARTELERA</p>	    
	</div>
	<div class="container">
	    <div class="row">
	        <c:forEach items="${emisiones}" var="emision" varStatus="loop">
	            <div class="col-md-6 mb-4 d-flex justify-content-center">
	                <div class="card mt-4" style="width: 100%; max-width: 800px;">
	                    <div class="row g-0">
	                        <div class="col">
	                            <img src="img/img${loop.index}.jpg" style="height:300px" class="img-fluid rounded-start" alt="imagen${loop.index}">
	                        </div>
	                        <div class="col">
	                            <div class="card-body">
	                                <h5 class="card-title">${emision.pelicula.titulo}</h5>
	                                <p class="card-text">${emision.pelicula.descripcion}</p>
	                                <p class="card-text"><small class="text-body-secondary">${emision.fecha}</small></p>
	                                <p class="card-text"><small class="text-body-secondary">${emision.hora}</small></p>
	                                <button type="button" class="btn btn-danger bg-gradient" data-bs-toggle="modal" data-bs-target="#exampleModal${loop.index}">Comprar</button>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <!-- Modal -->
	            <div class="modal fade" id="exampleModal${loop.index}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmaci�n de Compra</h1>
	                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	                        </div>
	                        <div class="nav nav-tabs" id="myTab${loop.index}" role="tablist">
	                            <button class="nav-link active" id="home-tab${loop.index}" data-bs-toggle="tab" data-bs-target="#home-tab-pane${loop.index}" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">Iniciar Sesi�n</button>
	                            <button class="nav-link" id="profile-tab${loop.index}" data-bs-toggle="tab" data-bs-target="#profile-tab-pane${loop.index}" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">Registrarse</button>
	                        </div>
	                        <div class="tab-content m-3" id="myTabContent${loop.index}">
	                            <div class="tab-pane fade show active" id="home-tab-pane${loop.index}" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
	                                <form action="StoreCompraUsuarioRegistrado" method="POST">
	                                    <input type="hidden" value="${emision.id}" name="idEmision" />
	                                    <div class="mb-3">
	                                        <label for="exampleInputEmail1" class="form-label">Correo Electr�nico</label>
	                                        <input type="email" class="form-control" id="correo" name="correo" aria-describedby="emailHelp">
	                                        <div id="emailHelp" class="form-text">ejemplo@ejemplocorreo.com</div>
	                                    </div>
	                                    <div class="mb-3">
	                                        <label for="exampleInputPassword1" class="form-label">Contrase�a</label>
	                                        <input type="password" class="form-control" id="contra" name="contra">
	                                    </div>
	                                    <div class="modal-footer">
	                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	                                        <button type="submit" class="btn btn-danger bg-gradient">Comprar</button>
	                                    </div>
	                                </form>
	                            </div>
	                            <div class="tab-pane fade" id="profile-tab-pane${loop.index}" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
	                                <form action="StoreCompraUsuarioNoRegistrado" method="POST">
	                                    <input type="hidden" value="${emision.id}" name="idEmision" />
	                                    <p class="mt-3">Nombre:</p>
	                                    <input type="text" class="form-control" name="nombre" value="${usuario.nombre}" />
	                                    <p class="mt-3">Apellidos:</p>
	                                    <input type="text" class="form-control" name="apellidos" value="${usuario.apellidos}" />
	                                    <p class="mt-3">Correo Electr�nico</p>
	                                    <input type="email" class="form-control" id="contra" name="correo" value="${usuario.correo}" />
	                                    <div id="emailHelp" class="form-text">ejemplo@ejemplocorreo.com</div>
	                                    <p class="mt-3">Contrase�a:</p>
	                                    <input type="password" class="form-control" name="contra" value="${usuario.contra}" />
	                                    <p class="mt-3">Rol:</p>
	                                    <select class="form-select" id="inputRol" name="rol">
	                                        <option value="usuario" ${usuario.rol.equals("usuario") ? "selected" : ""}>Usuario</option>
	                                        <option value="administrador" ${usuario.rol.equals("administrador") ? "selected" : ""}>Administrador</option>
	                                    </select>
	                                    <div class="modal-footer">
	                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	                                        <button type="submit" class="btn btn-danger bg-gradient">Comprar</button>
	                                    </div>
	                                </form>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </c:forEach>
	    </div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>