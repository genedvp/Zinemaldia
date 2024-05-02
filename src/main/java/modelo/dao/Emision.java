package modelo.dao;

import java.util.Date;

public class Emision {
	
	private int id;
	private int idPelicula;
	private int idSala;
	private Date fecha;
	private Date hora;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
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
