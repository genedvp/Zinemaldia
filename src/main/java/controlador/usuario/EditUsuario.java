package controlador.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloSala;
import modelo.dao.ModeloUsuario;
import modelo.dao.Sala;
import modelo.dao.Usuario;

/**
 * Servlet implementation class EditUsuario
 */
@WebServlet("/EditUsuario")
public class EditUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUsuario() {
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
		ModeloUsuario mu = new ModeloUsuario();
		Usuario usuario = mu.getUsuario(id);
		
		// enviar peli a la vista
		request.setAttribute("Usuario", usuario);

		// abrir vista
		request.getRequestDispatcher("usuario/EditUsuario.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
