package modelo.dao;


public class Usuario {

	private String nombre;
	private String contra;
	private String rol;
	private int registrado;
	private int idUsuario;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getRegistrado() {
		return registrado;
	}

	public void setRegistrado(int registrado) {
		this.registrado = registrado;
	}

	public int getId() {
		return idUsuario;
	}

	public void setId(int id) {
		this.idUsuario = id;
	}

}
