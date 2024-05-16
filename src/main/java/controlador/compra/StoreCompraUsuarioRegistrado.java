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
 * Servlet implementation class StoreCompraUsuarioRegistrado
 */
@WebServlet("/StoreCompraUsuarioRegistrado")
public class StoreCompraUsuarioRegistrado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCompraUsuarioRegistrado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idEmision = Integer.parseInt(request.getParameter("idEmision"));
		String correo = request.getParameter("correo");
		String contra = request.getParameter("contra");
		
		ModeloEmision me = new ModeloEmision();
		Emision emision = me.getEmision(idEmision);
		System.out.println(emision.toString());
		
		//comprobar que exista en la bbdd
		ModeloUsuario mu = new ModeloUsuario();
		ArrayList<Usuario> usuarios = mu.getTodos();
		Usuario usuario = new Usuario();
		
		usuario.setCorreo(correo);
		usuario.setContra(contra);
		
		Usuario usuarioComprobado = new Usuario();
		
		// Verificar datos de inicio de sesión
		boolean usuarioExistente = false;

		for (Usuario usuarioBbdd : usuarios) {
			
		    if (usuarioBbdd.getCorreo().equalsIgnoreCase(correo) && usuarioBbdd.getContra().equalsIgnoreCase(contra)) {
		        // Los datos de inicio de sesión coinciden con un usuario en la base de datos
		    	
		        usuarioExistente = true;
		        usuarioComprobado = mu.getUsuario(usuarioBbdd.getIdUsuario());
		        
		        break; //No es necesario seguir
		    }
		}
		if (usuarioExistente) {
			
	        ModeloCompra mc = new ModeloCompra();
	        
	    	Factura factura = new Factura();
	    	factura.setEmision(emision);
	    	factura.setUsuario(usuarioComprobado);
	    	
	    	// Obtener la fecha y hora actual
	    	Date fechaActual = new Date();
	    	Timestamp horaActual = new Timestamp(System.currentTimeMillis());

	    	// Establecer la fecha y hora actual en el objeto factura
	    	factura.setFecha(fechaActual);
	    	factura.setHora(horaActual);
	    	
	    	mc.insertFactura(factura);
	    	
	    	response.sendRedirect("usuario/CompraEmision?msg=CompraStored");
	
		} else {
			
		    // Los datos de inicio de sesión no coinciden con ningún usuario en la base de datos
			response.sendRedirect("usuario/CompraEmision?msg=CompraNotStored");
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
