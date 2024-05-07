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
 * Servlet implementation class StorePelicula
 */
@WebServlet("/StorePelicula")
public class StorePelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StorePelicula() {
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
		//recibir datos tarea
		String titulo = request.getParameter("titulo");
		String director = request.getParameter("director");
		String descripcion = request.getParameter("descripcion");
		int fechaProduccion = Integer.parseInt(request.getParameter("fechaProduccion"));	
		
		//almacenar pelicula
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(titulo);
		pelicula.setDirector(director);
		pelicula.setDescripcion(descripcion);
		pelicula.setFechaProduccion(fechaProduccion);
		
		ModeloPelicula mp = new ModeloPelicula();
		mp.insertPelicula(pelicula);
		
		//abrir inicio redirigiendo
		response.sendRedirect("IndexPelicula");
		
	}

}
