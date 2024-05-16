package modelo.dao;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", director=" + director + ", descripcion=" + descripcion
				+ ", fechaProduccion=" + fechaProduccion + "]";
	}


}