package controlador.compra;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.Emision;
import modelo.dao.Factura;
import modelo.dao.ModeloCompra;
import modelo.dao.ModeloEmision;
import modelo.dao.Usuario;

/**
 * Servlet implementation class StoreCompra
 */
@WebServlet("/StoreCompra")
public class StoreCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//obtener emision
	ModeloEmision me = new ModeloEmision();
	Emision emision = new Emision();
	int id = Integer.parseInt(request.getParameter("id"));
	emision = me.getEmision(id);

	Usuario usuario = new Usuario();
	// RECORDAR pedir usuario desde compra.jsp
	
	Factura factura = new Factura();
	factura.setEmision(emision);
	factura.setUsuario(usuario);
	factura.setFecha(null);
	factura.setHora(null);
	factura.setPrecioTotal(null);
	
	ModeloCompra mc = new ModeloCompra();
	mc.insertFactura(factura);
	
	response.sendRedirect("CompraEmision");

	}

}
