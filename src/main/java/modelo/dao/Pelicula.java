package modelo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Pelicula {

	private int id;
	private String titulo;
	private String director;
	private String descripcion;
	private int fechaProduccion;

	/*
	 * Aqui podriamos meter el nombre de los actores o como alternativa hacer una
	 * clase, para especificar ademas que es: si es actor, productor
	 */

	public int getIdPelicula() {
		return id;
	}

	public void setIdPelicula(int idPelicula) {
		this.id = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getFechaProduccion() {
		return fechaProduccion;
	}

	public void setFechaProduccion(int fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}


}