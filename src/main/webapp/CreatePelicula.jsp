<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Pelicula</title>
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
                    <form action="StorePelicula" method="POST">
                    	<input type="hidden" name="idPelicula" value="${pelicula.idPelicula}"/>
						Titulo: <input type="text" name="titulo" value="${pelicula.titulo}"/>
						Director: <input type="text" name="director" value="${pelicula.director}"/>
						Descripcion: <input type="text" name="descripcion" value="${pelicula.descripcion}"/>
				 <!--   Fecha de Producción: <input type="text" name="fechaProduccion" value="${pelicula.fechaProduccion}"/>  -->
						<input type="submit" value="Guardar" name="Guardar">
					</form>
                </div>
            </div>
        </div>
</body>
</html>