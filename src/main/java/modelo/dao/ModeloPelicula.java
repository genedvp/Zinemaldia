package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ModeloPelicula extends Conector{

	public ArrayList<Pelicula> getTodos() {
	        ArrayList<Pelicula> peliculas = new ArrayList<>();

	        try {
	            Statement st = conexion.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM peliculas");
	            while (rs.next()) {
	                Pelicula pelicula = new Pelicula();
	                pelicula.setIdPelicula(rs.getInt("id_pelicula"));
	                pelicula.setTitulo(rs.getString("titulo"));
	                pelicula.setDirector(rs.getString("director"));
	                pelicula.setDescripcion(rs.getString("descripcion"));
//	                pelicula.setFechaProduccion(rs.getDate("fecha_produccion"));
	                
	                peliculas.add(pelicula);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        return peliculas;
	    }

	public Pelicula getPelicula(int idPelicula) {
		
		try {
		PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM peliculas WHERE id_pelicula=?");
        pst.setInt(1, idPelicula);
        ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Pelicula pelicula = new Pelicula();
				pelicula.setIdPelicula(rs.getInt("id_pelicula"));
			    pelicula.setTitulo(rs.getString("titulo"));
			    pelicula.setDirector(rs.getString("director"));
			    pelicula.setDescripcion(rs.getString("descripcion"));
//          pelicula.setFechaProduccion(rs.getDate("fecha_produccion"));
			    
			    return pelicula;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

