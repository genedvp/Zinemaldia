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
 * Servlet implementation class EditPelicula
 */
@WebServlet("/EditSala")
public class EditSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSala() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recibir la id
		int id = Integer.parseInt(request.getParameter("id"));
		
		// conseguir la sala
		ModeloSala ms = new ModeloSala();
		Sala sala = ms.getSala(id);
		
		// enviar peli a la vista
		request.setAttribute("sala", sala);

		// abrir vista
		request.getRequestDispatcher("sala/EditSala.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
