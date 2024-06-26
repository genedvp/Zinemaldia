package controlador.pelicula;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloPelicula;
import modelo.dao.Pelicula;

/**
 * Servlet implementation class EditPelicula
 */
@WebServlet("/EditPelicula")
public class EditPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recibir la id
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		
		// conseguir la peli
		ModeloPelicula mp = new ModeloPelicula();
		Pelicula pelicula = mp.getPelicula(idPelicula);
		
		// enviar peli a la vista
		request.setAttribute("pelicula", pelicula);

		// abrir vista
		request.getRequestDispatcher("pelicula/EditPelicula.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
