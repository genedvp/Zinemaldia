package modelo.dao;

public class Sala {

	private int id;
	private String descripcion;
	private int capacidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", descripcion=" + descripcion + ", capacidad=" + capacidad + "]";
	}

}
