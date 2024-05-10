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
 * Servlet implementation class StoreUsuario
 */
@WebServlet("/StoreUsuario")
public class StoreUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreUsuario() {
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
		
		//recibir
		String nombre = request.getParameter("nombre");
		String contra = request.getParameter("contra");
		String rol = request.getParameter("rol");
		
		//asignar
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setContra(contra);
		usuario.setRol(rol);
		
		//comprobar que no exista en la bbdd
		
		//guardar en bbdd
		ModeloUsuario mu = new ModeloUsuario();
		mu.insertUsuario(usuario);
		
		//redirigir al index
		response.sendRedirect("IndexUsuario");
		
	}

}
