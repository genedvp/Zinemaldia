package controlador.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloUsuario;
import modelo.dao.Usuario;

/**
 * Servlet implementation class UpdateUsuario
 */
@WebServlet("/UpdateUsuario")
public class UpdateUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		//recibir
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		String contra = request.getParameter("contra");
		String rol = request.getParameter("rol");
				
		//asignar
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setCorreo(correo);
		usuario.setContra(contra);
		usuario.setRol(rol);
		
		int id = Integer.parseInt(request.getParameter("id"));
		usuario.setIdUsuario(id);
			
		//guardar en bbdd
		ModeloUsuario mu = new ModeloUsuario();
		mu.updateUsuario(usuario);
				
		//redirigir al index
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
