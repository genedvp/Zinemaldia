package controlador.emision;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.Emision;
import modelo.dao.ModeloEmision;
import modelo.dao.ModeloPelicula;
import modelo.dao.ModeloSala;
import modelo.dao.Pelicula;
import modelo.dao.Sala;

/**
 * Servlet implementation class EditEmision
 */
@WebServlet("/EditEmision")
public class EditEmision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ModeloEmision me = new ModeloEmision();
		Emision emision = me.getEmision(id);
		
		ModeloSala ms = new ModeloSala();
		ArrayList<Sala> salas = ms.getTodas();
		
		ModeloPelicula mp = new ModeloPelicula();
		ArrayList<Pelicula> peliculas = mp.getTodos();
		
		request.setAttribute("peliculas", peliculas);
		request.setAttribute("salas", salas);
		request.setAttribute("emision", emision);
		
		request.getRequestDispatcher("emision/EditEmision.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
