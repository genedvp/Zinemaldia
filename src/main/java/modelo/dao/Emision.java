package modelo.dao;

import java.util.Date;

public class Emision {
	
	private int id;
	private Pelicula pelicula;
	private Sala sala;
	private Date fecha;
	private Date hora;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}
	
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public Sala getSala() {
		return sala;
	}
	
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getHora() {
		return hora;
	}
	
	public void setHora(Date hora) {
		this.hora = hora;
	}
}

