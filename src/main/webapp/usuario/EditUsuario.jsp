<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Usuario</title>
</head>
<body class="bg-dark">
	<header>
		<nav class="navbar bg-black">
			<div class="container-fluid">
				<a class="navbar-brand" href="IndexUsuario">
					<img src="img\Logo_zinemaldia.png" alt="Logo" width="68"
					height="50" class="d-inline-block align-text-top">
				</a>
			</div>
		</nav>
	</header>
		<div class="container">
		<div class="row mt-4">
			<div class="col">
				<a href="IndexUsuario"> <svg xmlns="http://www.w3.org/2000/svg"
						width="25" height="25" fill="white" class="bi bi-box-arrow-left"
						viewBox="0 0 16 16">
  					<path fill-rule="evenodd"
							d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0z" />
  					<path fill-rule="evenodd"
							d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708z" />
					</svg>
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col text-light">
				<form action="UpdateUsuario" method="POST">
				
	                <input type="hidden" name="id" value=${usuario.id}/>
	                <br>
	                <p class="mt-3">Nombre:</p>
	                <input type="text" class="form-control" name="nombre" value="${usuario.nombre}" />
	                <br>
	                <p class="mt-3">Apellidos:</p>
	                <input type="text" class="form-control" name="apellidos" value="${usuario.apellidos}" />
	                <br>
	                <p class="mt-3">Correo Electrónico</p>
	                <input type="email" class="form-control" id="contra" name="correo" value="${usuario.correo}" />
	                <div id="emailHelp" class="form-text text-light">ejemplo@ejemplocorreo.com</div>
	                <br>
	                <p class="mt-3">Contraseña:</p>
	                <input type="password" class="form-control" name="contra" value="${usuario.contra}" />
	                <br>
	                <p class="mt-3">Rol:</p>
	                <select class="form-select" id="inputRol" name="rol">
	                	<option value="usuario" ${usuario.rol.equals("usuario") ? "selected" : ""}>Usuario</option>
	                	<option value="administrador" ${usuario.rol.equals("administrador") ? "selected" : ""}>Administrador</option>
	                </select>
	                <br>
	                <button type="submit" class="btn btn-danger bg-gradient">Guardar</button>
				</form>
			</div>
			<div class="col"></div>
			<div class="col"></div>
		</div>
	</div>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
		crossorigin="anonymous">
</body>
</html>