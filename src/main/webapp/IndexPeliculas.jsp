<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD peliculas</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container text-center">
  		<div class="row justify-content-md-center">
    		<div class="col col-lg-2">
      			<a href="createPelicula">Crear</a>
    		</div>
    		           <table class="table">
                        <thead>
                          <tr>
                            <th scope="">id</th>
                            <th scope="col">titulo</th>
                            <th scope="col">director</th>
                            <th scope="col">descripcion</th>
                            <th scope="col">fecha de produccion</th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${peliculas}" var="pelicula">
                          <tr>
                            <td>${pelicula.idPelicula}</td>
                            <td>${pelicula.titulo}</td>
                            <td>${pelicula.director}</td>
                            <td>${pelicula.descripcion}</td>
                            <td>${pelicula.fechaProduccion}</td>
                            <td>
                            	<a href="ShowPelicula?id=${pelicula.id}">Ver</a>
                            	<a href="EditPelicula?id=${pelicula.id}">Modificar</a>
                            	<a href="DestroyPelicula?id=${pelicula.id}">Eliminar</a>                            	
                            </td>
                          </tr>
                          </c:forEach>
                          
                        </tbody>
                      </table>
  		</div>
	</div>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</body>
</html>