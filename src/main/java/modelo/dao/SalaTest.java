package modelo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SalaTest {

	private Sala sala;

	@Test
	void testGetId() {
		sala = new Sala();
		
		sala.setId(1);
		
		assertEquals(1, sala.getId());
	}

	@Test
	void testSetId() {
		sala = new Sala();
		
		sala.setId(2);
		
		assertEquals(2, sala.getId());
	}

	@Test
	void testGetDescripcion() {
		sala = new Sala();
		String descripcion = "Sala grande con pantalla 4K";
		
		sala.setDescripcion(descripcion);
		
		assertEquals(descripcion, sala.getDescripcion());
	}

	@Test
	void testSetDescripcion() {
		sala = new Sala();
		String descripcion = "Sala pequeña con sonido envolvente";
		
		sala.setDescripcion(descripcion);
		
		assertEquals(descripcion, sala.getDescripcion());
	}

	@Test
	void testGetCapacidad() {
		sala = new Sala();
		
		int capacidad = 100;
		
		sala.setCapacidad(capacidad);
		
		assertEquals(capacidad, sala.getCapacidad());
	}

	@Test
	void testSetCapacidad() {
		sala = new Sala();
		int capacidad = 200;
		
		sala.setCapacidad(capacidad);
		
		assertEquals(capacidad, sala.getCapacidad());
	}

	@Test
	void testToString() {
		sala = new Sala();
		sala.setId(1);
		sala.setDescripcion("Sala chiquita");
		sala.setCapacidad(100);
		
		String expected = "Sala [id=1, descripcion=Sala chiquita, capacidad=100]";

		assertEquals(expected, sala.toString());
	}
}
