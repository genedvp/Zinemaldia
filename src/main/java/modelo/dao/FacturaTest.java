package modelo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class FacturaTest {

	private Factura factura;
	private Usuario usuario;
	private Emision emision;
	private Date fecha;
	private Date hora;
	
	@Test
	void testGetId() {
		factura = new Factura();
		
		factura.setId(1);
		assertEquals(1, factura.getId());
	}

	@Test
	void testSetId() {
		factura = new Factura();
		
		factura.setId(2);
		assertEquals(2, factura.getId());
	}

	@Test
	void testGetUsuario() {
		usuario = new Usuario();
		factura = new Factura();
		
		factura.setUsuario(usuario);
		assertEquals(usuario, factura.getUsuario());
	}

	@Test
	void testSetUsuario() {
		usuario = new Usuario();
		factura = new Factura();
		
		factura.setUsuario(usuario);
		assertEquals(usuario, factura.getUsuario());
	}

	@Test
	void testGetEmision() {
		emision = new Emision();
		factura = new Factura();
		
		factura.setEmision(emision);
		assertEquals(emision, factura.getEmision());
	}

	@Test
	void testSetEmision() {
		emision = new Emision();
		factura = new Factura();
		
		factura.setEmision(emision);
		assertEquals(emision, factura.getEmision());
	}

	@Test
	void testGetPrecioTotal() {
		factura = new Factura();
		Double precioTotal = 50.0;
		
		factura.setPrecioTotal(precioTotal);
		assertEquals(precioTotal, factura.getPrecioTotal());
	}

	@Test
	void testSetPrecioTotal() {
		factura = new Factura();
		Double precioTotal = 75.0;
		
		factura.setPrecioTotal(precioTotal);
		assertEquals(precioTotal, factura.getPrecioTotal());
	}

	@Test
	void testGetFecha() {
		factura = new Factura();
		fecha = new Date();
		
		factura.setFecha(fecha);
		assertEquals(fecha, factura.getFecha());
	}

	@Test
	void testSetFecha() {
		fecha = new Date();
		factura = new Factura();
		
		factura.setFecha(fecha);
		assertEquals(fecha, factura.getFecha());
	}

	@Test
	void testGetHora() {
		hora = new Date();
		factura = new Factura();
		
		factura.setHora(hora);
		assertEquals(hora, factura.getHora());
	}

	@Test
	void testSetHora() {
		hora = new Date();
		factura = new Factura();
		
		factura.setHora(hora);
		assertEquals(hora, factura.getHora());
	}

	@Test
	void testToString() {
		
		factura = new Factura();
		usuario = new Usuario();
		emision = new Emision();
		fecha = new Date();
		hora = new Date();
		
		factura.setId(1);
		factura.setUsuario(usuario);
		factura.setEmision(emision);
		factura.setPrecioTotal(100.0);
		factura.setFecha(fecha);
		factura.setHora(hora);
		String expected = "Factura [id=1, usuario=" + usuario + ", emision=" + emision + ", precioTotal=100.0, fecha=" + fecha + ", hora=" + hora + "]";
		assertEquals(expected, factura.toString());
	}
}

