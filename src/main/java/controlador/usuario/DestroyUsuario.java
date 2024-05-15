package controlador.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloSala;
import modelo.dao.ModeloUsuario;

/**
 * Servlet implementation class DestroyUsuario
 */
@WebServlet("/DestroyUsuario")
public class DestroyUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroyUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir id
		int idUsuario = Integer.parseInt(request.getParameter("id"));
		
		//eliminar sala
		ModeloUsuario mu = new ModeloUsuario();
		mu.deleteUsuario(idUsuario);
		
		//volver al index
		response.sendRedirect("IndexUsuario");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
