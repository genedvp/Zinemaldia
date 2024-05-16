package modelo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PeliculaTest {

	private Pelicula pelicula;

	@Test
	void testGetId() {
		pelicula = new Pelicula();
		
		pelicula.setId(1);
		assertEquals(1, pelicula.getId());
	}

	@Test
	void testSetId() {
		pelicula = new Pelicula();
		
		pelicula.setId(2);
		assertEquals(2, pelicula.getId());
	}

	@Test
	void testGetTitulo() {
		pelicula = new Pelicula();
		String titulo = "Inception";
		
		pelicula.setTitulo(titulo);
		assertEquals(titulo, pelicula.getTitulo());
	}

	@Test
	void testSetTitulo() {
		pelicula = new Pelicula();
		String titulo = "Interstellar";
		
		pelicula.setTitulo(titulo);
		assertEquals(titulo, pelicula.getTitulo());
	}

	@Test
	void testGetDirector() {
		pelicula = new Pelicula();
		String director = "Christopher Nolan";
		
		pelicula.setDirector(director);
		assertEquals(director, pelicula.getDirector());
	}

	@Test
	void testSetDirector() {
		pelicula = new Pelicula();
		String director = "Quentin Tarantino";
		
		pelicula.setDirector(director);
		assertEquals(director, pelicula.getDirector());
	}

	@Test
	void testGetDescripcion() {
		pelicula = new Pelicula();
		String descripcion = "A mind-bending thriller about dream infiltration.";
		
		pelicula.setDescripcion(descripcion);
		assertEquals(descripcion, pelicula.getDescripcion());
	}

	@Test
	void testSetDescripcion() {
		pelicula = new Pelicula();
		String descripcion = "A journey through space and time to save humanity.";
		
		pelicula.setDescripcion(descripcion);
		assertEquals(descripcion, pelicula.getDescripcion());
	}

	@Test
	void testGetFechaProduccion() {
		pelicula = new Pelicula();
		int fechaProduccion = 2010;
		
		pelicula.setFechaProduccion(fechaProduccion);
		assertEquals(fechaProduccion, pelicula.getFechaProduccion());
	}

	@Test
	void testSetFechaProduccion() {
		pelicula = new Pelicula();
		int fechaProduccion = 2014;
		
		pelicula.setFechaProduccion(fechaProduccion);
		assertEquals(fechaProduccion, pelicula.getFechaProduccion());
	}

	@Test
	void testToString() {
		pelicula = new Pelicula();
		pelicula.setId(1);
		pelicula.setTitulo("Inception");
		pelicula.setDirector("Christopher Nolan");
		pelicula.setDescripcion("A mind-bending thriller about dream infiltration.");
		pelicula.setFechaProduccion(2010);
		
		String expected = "Pelicula [id=1, titulo=Inception, director=Christopher Nolan, descripcion=A mind-bending thriller about dream infiltration., fechaProduccion=2010]";
		assertEquals(expected, pelicula.toString());
	}
}
