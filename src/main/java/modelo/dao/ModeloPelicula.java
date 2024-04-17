package modelo.dao;

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
	                pelicula.setDescripccion(rs.getString("descripcion"));
	                pelicula.setFechaProduccion(rs.getDate("fecha_produccion"));
	                
	                peliculas.add(pelicula);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        return peliculas;
	    }

	public Pelicula getPelicula() {
		
		Pelicula pelicula = new Pelicula();
		
		return pelicula;
	}
}
