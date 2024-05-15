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
	                pelicula.setId(rs.getInt("id_pelicula"));
	                pelicula.setTitulo(rs.getString("titulo"));
	                pelicula.setDirector(rs.getString("director"));
	                pelicula.setDescripcion(rs.getString("descripcion"));
	                pelicula.setFechaProduccion(rs.getInt("fecha_produccion"));
	                
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
				pelicula.setId(rs.getInt("id_pelicula"));
			    pelicula.setTitulo(rs.getString("titulo"));
			    pelicula.setDirector(rs.getString("director"));
			    pelicula.setDescripcion(rs.getString("descripcion"));
         		pelicula.setFechaProduccion(rs.getInt("fecha_produccion"));
			    
			    return pelicula;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deletePelicula(int id) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM peliculas WHERE id_pelicula=?");
	         pst.setInt(1, id);
	         pst.execute();
	         return true;
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	     }
	}

	public int updatePelicula(Pelicula pelicula) {
	     try {
	         PreparedStatement pst = this.conexion.prepareStatement("UPDATE peliculas SET titulo = ?, director = ?, descripcion = ?, fecha_produccion = ? WHERE id_pelicula = ?");
	         
	         pst.setString(1, pelicula.getTitulo());
	         pst.setString(2, pelicula.getDirector());
	         pst.setString(3, pelicula.getDescripcion());
	         pst.setInt(4, pelicula.getFechaProduccion()); 
	         pst.setInt(5, pelicula.getId());
	        
	         return pst.executeUpdate();
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return 0;
	     }
	}
	
	 public void insertPelicula(Pelicula pelicula) {
		    try {
		        PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO peliculas (titulo, director, descripcion, fecha_produccion) VALUES (?, ?, ?, ?)");
		        pst.setString(1, pelicula.getTitulo());
		        pst.setString(2, pelicula.getDirector());
		        pst.setString(3, pelicula.getDescripcion());
		        pst.setInt(4, pelicula.getFechaProduccion()); 
		        pst.execute();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

	public boolean tieneEmision(int idPelicula) {
		
		try {
		PreparedStatement pst = this.conexion.prepareStatement("SELECT id_pelicula FROM emisiones WHERE id_pelicula=?");
        pst.setInt(1, idPelicula);
        ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Pelicula pelicula = new Pelicula();
				pelicula.setId(rs.getInt("id_pelicula"));
			    return true;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

