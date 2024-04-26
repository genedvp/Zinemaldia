package controlador.sala;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloSala;
import modelo.dao.Sala;

/**
 * Servlet implementation class StorePelicula
 */
@WebServlet("/StoreSala")
public class StoreSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreSala() {
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
		//recibir datos sala
		String descripcion = request.getParameter("descripcion");
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		
		//almacenar sala
		Sala sala = new Sala();
		sala.setCapacidad(capacidad);
		sala.setDescripcion(descripcion);
		
		ModeloSala ms = new ModeloSala();
		ms.insertSala(sala);
		
		//abrir inicio redirigiendo
		response.sendRedirect("IndexSala");
		
	}

}
