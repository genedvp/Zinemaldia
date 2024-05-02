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

/**
 * Servlet implementation class IndexEmision
 */
@WebServlet("/IndexEmision")
public class IndexEmision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexEmision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloEmision me = new ModeloEmision();
		
		ArrayList<Emision> emisiones = me.getTodas();
		
		request.setAttribute("emisiones", emisiones);
		
		request.getRequestDispatcher("emision/IndexEmision.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
