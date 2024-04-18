<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD PELICULAS</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	 <div class="container">
            <div class="row">
                <div class="col">
                    <a href="IndexPelicula">Volver</a>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p>Id: ${pelicula.idPelicula}</p>
                    <p>Nombre: ${pelicula.titulo}</p>
                    <p>Director: ${pelicula.director}</p>
                    <p>Descripcion: ${pelicula.descripcion}</p> 
               <!-- <p>Fecha de Producción: ${pelicula.fechaProduccion}</p> -->
                </div>
            </div>
        </div>
    	
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</body>
</html>