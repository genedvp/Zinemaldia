package controlador.emision;

import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.Emision;
import modelo.dao.ModeloEmision;

/**
 * Servlet implementation class StoreEmision
 */
@WebServlet("/StoreEmision")
public class StoreEmision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreEmision() {
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
		
		int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
		int idSala = Integer.parseInt(request.getParameter("idSala"));
		SimpleDateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fechaHora = new SimpleDateFormat("HH:mm");
		String obtenerFecha = request.getParameter("fecha");
		String obtenerHora = request.getParameter("hora");
		
		try {
			
			Date fecha = fechaFormat.parse(obtenerFecha);
			Date hora = fechaHora.parse(obtenerHora);
			Emision emision = new Emision();
			emision.setIdPelicula(idPelicula);
			emision.setIdSala(idSala);
			emision.setFecha(fecha);
			emision.setHora(hora);
			ModeloEmision me = new ModeloEmision();
			me.insertEmision(emision);
			
		} catch (ParseException e) {
			System.out.println("error al parsear fecha/hora para guardar emision");
			e.printStackTrace();
		}
		response.sendRedirect("pelicula/IndexPelicula");
				
	}

}
