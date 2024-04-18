package controlador.pelicula;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloPelicula;

/**
 * Servlet implementation class DestroyPelicula
 */
@WebServlet("/DestroyPelicula")
public class DestroyPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroyPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//recibir id
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		
		//eliminar peli
		ModeloPelicula mp = new ModeloPelicula();
		mp.deletePelicula(idPelicula);
		
		//volver al index
		response.sendRedirect("IndexPelicula");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
