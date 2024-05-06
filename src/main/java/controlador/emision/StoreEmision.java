package controlador.emision;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

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
		
		ModeloPelicula mp = new ModeloPelicula();
		ModeloSala ms = new ModeloSala();
		Pelicula pelicula = new Pelicula();
		Sala sala = new Sala();
		
		pelicula = mp.getPelicula(Integer.parseInt(request.getParameter("idPelicula")));
		sala = ms.getSala(Integer.parseInt(request.getParameter("idSala")));
		String fechaString = request.getParameter("fecha");
		String horaString = request.getParameter("hora");
		
		System.out.println(fechaString+" "+horaString);
		
		SimpleDateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fechaHora = new SimpleDateFormat("HH:mm");
		Date fecha = null;
		Date hora = null;
		
		try {
			
			fecha = fechaFormat.parse(fechaString);
			hora = fechaHora.parse(horaString);
			
		} catch (Exception e) {
			System.out.println("error parse fecha/hora");
		}

			Emision emision = new Emision();
			
			emision.setPelicula(pelicula);
			
			emision.setSala(sala);
			
			emision.setFecha(fecha);
			
			emision.setHora(hora);
			
			ModeloEmision me = new ModeloEmision();
			
			me.insertEmision(emision);
			
			response.sendRedirect("emision/IndexEmision");
				
	}

}
