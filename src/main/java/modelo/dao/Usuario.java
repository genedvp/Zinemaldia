package modelo.dao;


public class Usuario {

	private String nombre;
	private String apellidos;
	private String correo;
	private String contra;
	private String rol;
	private int registrado;
	private int idUsuario;
	
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

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

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", contra=" + contra
				+ ", rol=" + rol + ", registrado=" + registrado + ", idUsuario=" + idUsuario + "]";
	}

}
