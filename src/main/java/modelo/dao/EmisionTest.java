package modelo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class EmisionTest {
	
	private Emision emision;
	private Pelicula pelicula;
	private Sala sala;
	private Date fecha;
	private Date hora;
	
	@Test
	void testGetId() {
		emision = new Emision();
		
		emision.setId(654);
		assertEquals(654, emision.getId());
	}

	@Test
	void testSetId() {
		emision = new Emision();
		
		emision.setId(2);
		assertEquals(2, emision.getId());
	}

	@Test
	void testGetPelicula() {
		pelicula = new Pelicula();
		emision = new Emision();
		
		emision.setPelicula(pelicula);
		assertEquals(pelicula, emision.getPelicula());
	}

	@Test
	void testSetPelicula() {
		emision = new Emision();
		pelicula = new Pelicula();
		
		emision.setPelicula(pelicula);
		assertEquals(pelicula, emision.getPelicula());
	}

	@Test
	void testGetSala() {
		sala = new Sala();
		emision = new Emision();
		
		emision.setSala(sala);
		assertEquals(sala, emision.getSala());
	}

	@Test
	void testSetSala() {
		sala = new Sala();
		emision = new Emision();
		
		emision.setSala(sala);
		assertEquals(sala, emision.getSala());
	}

	@Test
	void testGetFecha() {
		emision = new Emision();
		fecha = new Date();
		
		emision.setFecha(fecha);
		assertEquals(fecha, emision.getFecha());
	}

	@Test
	void testSetFecha() {
		fecha = new Date();
		emision = new Emision();
		
		emision.setFecha(fecha);
		assertEquals(fecha, emision.getFecha());
	}

	@Test
	void testGetHora() {
		hora = new Date();
		emision = new Emision();
		
		emision.setHora(hora);
		assertEquals(hora, emision.getHora());
	}

	@Test
	void testSetHora() {
		hora = new Date();
		emision = new Emision();
		
		emision.setHora(hora);
		assertEquals(hora, emision.getHora());
	}

	@Test
	void testToString() {
		emision = new Emision();
		
		emision.setId(1);
		emision.setPelicula(pelicula);
		emision.setSala(sala);
		emision.setFecha(fecha);
		emision.setHora(hora);
		String expected = "Emision [id=1, pelicula=" + pelicula + ", sala=" + sala + ", fecha=" + fecha + ", hora=" + hora + "]";
		assertEquals(expected, emision.toString());
		
	}
}
