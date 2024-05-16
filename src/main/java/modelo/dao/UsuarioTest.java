package modelo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	private Usuario usuario;

	@Test
	void testGetNombre() {
		
		usuario = new Usuario();
		
		String nombre = "Pedro";
		usuario.setNombre(nombre);
		
		assertEquals(nombre, usuario.getNombre());
	}

	@Test
	void testSetNombre() {
		
		usuario = new Usuario();
		
		String nombre = "Génesis";
		usuario.setNombre(nombre);
		
		assertEquals(nombre, usuario.getNombre());
	}

	@Test
	void testGetApellidos() {
		
		usuario = new Usuario();
		
		String apellidos = "Elisa";
		usuario.setApellidos(apellidos);
		assertEquals(apellidos, usuario.getApellidos());
	}

	@Test
	void testSetApellidos() {
		
		usuario = new Usuario();
		
		String apellidos = "Pérez";
		usuario.setApellidos(apellidos);
		
		assertEquals(apellidos, usuario.getApellidos());
	}

	@Test
	void testGetCorreo() {
		
		usuario = new Usuario();
		
		String correo = "jose@plaiaundi.com";
		usuario.setCorreo(correo);
		
		assertEquals(correo, usuario.getCorreo());
	}

	@Test
	void testSetCorreo() {
		
		usuario = new Usuario();
		
		String correo = "gene@gmail.com";
		usuario.setCorreo(correo);
		
		assertEquals(correo, usuario.getCorreo());
	}

	@Test
	void testGetContra() {
		
		usuario = new Usuario();
		
		String contra = "1324";
		usuario.setContra(contra);
		
		assertEquals(contra, usuario.getContra());
	}

	@Test
	void testSetContra() {
		
		usuario = new Usuario();
		
		String contra = "abeljhndlsdfi878";
		usuario.setContra(contra);
		
		assertEquals(contra, usuario.getContra());
	}

	@Test
	void testGetRol() {
		usuario = new Usuario();
		
		String rol = "administrador";
		usuario.setRol(rol);
		
		assertEquals(rol, usuario.getRol());
	}

	@Test
	void testSetRol() {
		usuario = new Usuario();
		
		String rol = "usuario";
		usuario.setRol(rol);
		
		assertEquals(rol, usuario.getRol());
	}

	@Test
	void testGetRegistrado() {
		usuario = new Usuario();
		
		int registrado = 1;
		usuario.setRegistrado(registrado);
		
		assertEquals(registrado, usuario.getRegistrado());
	}

	@Test
	void testSetRegistrado() {
		usuario = new Usuario();
		
		int registrado = 0;
		usuario.setRegistrado(registrado);
		
		assertEquals(registrado, usuario.getRegistrado());
	}

	@Test
	void testGetIdUsuario() {
		usuario = new Usuario();
		
		int idUsuario = 12345;
		usuario.setIdUsuario(idUsuario);
		
		assertEquals(idUsuario, usuario.getIdUsuario());
	}

	@Test
	void testSetIdUsuario() {
		usuario = new Usuario();
		
		int idUsuario = 67890;
		usuario.setIdUsuario(idUsuario);
		
		assertEquals(idUsuario, usuario.getIdUsuario());
	}

	@Test
	void testToString() {
		
		usuario = new Usuario();
		
		usuario.setNombre("John");
		usuario.setApellidos("Doe");
		usuario.setCorreo("john@example.com");
		usuario.setContra("password123");
		usuario.setRol("admin");
		usuario.setRegistrado(1);
		usuario.setIdUsuario(12345);

		String expected = "Usuario [nombre=John, apellidos=Doe, correo=john@example.com, contra=password123, rol=admin, registrado=1, idUsuario=12345]";
		
		assertEquals(expected, usuario.toString());
	}
}