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
 * Servlet implementation class UpdatePelicula
 */
@WebServlet("/UpdateSala")
public class UpdateSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSala() {
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
		// Recibir datos de la sala
		int idSala = Integer.parseInt(request.getParameter("idSala"));
		String descripcion = request.getParameter("descripcion");
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));

		// Guardar sala en la base de datos
		Sala sala = new Sala();
		sala.setId(idSala);
		sala.setDescripcion(descripcion);
		sala.setCapacidad(capacidad);

		ModeloSala ms = new ModeloSala();
		ms.updateSala(sala);

		// Redirigir a la página de inicio de salas
		response.sendRedirect("sala/IndexSala");

		
	}

}
