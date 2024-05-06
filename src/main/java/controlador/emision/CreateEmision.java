package controlador.emision;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloPelicula;
import modelo.dao.ModeloSala;
import modelo.dao.Pelicula;
import modelo.dao.Sala;

/**
 * Servlet implementation class CreateEmision
 */
@WebServlet("/CreateEmision")
public class CreateEmision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ModeloPelicula mp = new ModeloPelicula();
		ModeloSala ms = new ModeloSala();
		
		ArrayList<Pelicula> peliculas = mp.getTodos();
		ArrayList<Sala> salas = ms.getTodas();
		
		request.setAttribute("peliculas", peliculas);
		request.setAttribute("salas", salas);
		
		request.getRequestDispatcher("emision/CreateEmision.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
