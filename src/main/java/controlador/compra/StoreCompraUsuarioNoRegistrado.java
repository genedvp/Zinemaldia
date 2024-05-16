package controlador.compra;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.Emision;
import modelo.dao.Factura;
import modelo.dao.ModeloCompra;
import modelo.dao.ModeloEmision;
import modelo.dao.ModeloUsuario;
import modelo.dao.Usuario;

/**
 * Servlet implementation class StoreCompra
 */
@WebServlet("/StoreCompraUsuarioNoRegistrado")
public class StoreCompraUsuarioNoRegistrado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreCompraUsuarioNoRegistrado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtener emision según el id que se obtiene
		ModeloEmision me = new ModeloEmision();
		Emision emision = new Emision();
		int idEmision = Integer.parseInt(request.getParameter("idEmision"));
		emision = me.getEmision(idEmision);

		// recibir datos del jsp
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		String contra = request.getParameter("contra");
		String rol = request.getParameter("rol");

		// Verificar que el correo no está utilizado
		ModeloUsuario mu = new ModeloUsuario();

		boolean existe = mu.usuarioExiste(correo);

		if (!existe) { 

			// asignar a usuario
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellidos(apellidos);
			usuario.setCorreo(correo);
			usuario.setContra(contra);
			usuario.setRol(rol);
			
			mu.insertUsuario(usuario);
			
			usuario.setIdUsuario(mu.obtenerIdCreado(usuario));
			
			System.out.println(usuario.toString());
			System.out.println(emision.toString());
			
			ModeloCompra mc = new ModeloCompra();
	    	Factura factura = new Factura();
	    	factura.setEmision(emision);
	    	factura.setUsuario(usuario);
	    	
	    	// Obtener la fecha y hora actual
	    	Date fechaActual = new Date();
	    	Timestamp horaActual = new Timestamp(System.currentTimeMillis());

	    	// Establecer la fecha y hora actual en el objeto factura
	    	factura.setFecha(fechaActual);
	    	factura.setHora(horaActual);
	    	
	    	mc.insertFactura(factura);
	    	
	    	response.sendRedirect("usuario/CompraEmision?msg=CompraStored");
	    	
		} else {
			
			response.sendRedirect("usuario/CompraEmision?msg=CompraNotStored");
		}

	}

}
