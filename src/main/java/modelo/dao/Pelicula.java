package modelo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Pelicula {

	private int idPelicula;
	private String titulo;
	private String director;
	private String descripcion;
	private Date fechaProduccion;

	/*
	 * Aqui podriamos meter el nombre de los actores o como alternativa hacer una
	 * clase, para especificar ademas que es: si es actor, productor
	 */
	private ArrayList<String> reparto = new ArrayList<String>();

	SimpleDateFormat fmdt = new SimpleDateFormat("dd/MM/yyyy");

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
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

	public Date getFechaProduccion() {
		return fechaProduccion;
	}

	public void setFechaProduccion(Date fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}

	public ArrayList<String> getReparto() {
		return reparto;
	}

	public void setReparto(ArrayList<String> reparto) {
		this.reparto = reparto;
	}



}