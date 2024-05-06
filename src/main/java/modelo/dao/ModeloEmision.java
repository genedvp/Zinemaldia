package modelo.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

	public class ModeloEmision extends Conector {
	   
		ModeloPelicula mp = new ModeloPelicula();
	    ModeloSala ms = new ModeloSala();
		
	    public ArrayList<Emision> getTodas() {
	        ArrayList<Emision> emisiones = new ArrayList<>();

	        try {
	            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM emisiones");
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                Emision emision = new Emision();
	                
	                emision.setId(rs.getInt("id_emision"));
	                emision.setPelicula(mp.getPelicula(rs.getInt("id_pelicula")));
	                emision.setSala(ms.getSala(rs.getInt("id_sala")));
	                emision.setFecha(rs.getDate("fecha"));
	                emision.setHora(rs.getTime("hora"));

	                emisiones.add(emision);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        return emisiones;
	    }

	    public Emision getEmision(int idEmision) {
	        try {
	            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM emisiones WHERE id_emision=?");
	            pst.setInt(1, idEmision);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                Emision emision = new Emision();
	                emision.setId(rs.getInt("id_emision"));
	                emision.setPelicula(mp.getPelicula(rs.getInt("id_pelicula")));
	                emision.setSala(ms.getSala(rs.getInt("id_sala")));
	                emision.setFecha(rs.getDate("fecha"));
	                emision.setHora(rs.getTime("hora"));

	                return emision;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public boolean deleteEmision(int id) {
	        try {
	            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM emisiones WHERE id_emision=?");
	            pst.setInt(1, id);
	            pst.execute();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public int updateEmision(Emision emision) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE emisiones SET id_pelicula = ?, id_sala = ?, fecha = ?, hora = ? WHERE id_emision = ?");

            pst.setInt(1, emision.getPelicula().getId());
            pst.setInt(2, emision.getSala().getId());

            // Convertir la fecha y la hora al tipo de datos correcto para la base de datos
            java.sql.Date fechaSql = new java.sql.Date(emision.getFecha().getTime());
            pst.setDate(3, fechaSql);

            java.sql.Time horaSql = new java.sql.Time(emision.getHora().getTime());
            pst.setTime(4, horaSql);

            pst.setInt(5, emision.getId());

            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

	    public void insertEmision(Emision emision) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO emisiones (id_pelicula, id_sala, fecha, hora) VALUES (?, ?, ?, ?)");
            pst.setInt(1, emision.getPelicula().getId());
            pst.setInt(2, emision.getSala().getId());
            
            // Formatear la fecha en el formato yyyy-MM-dd
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = dateFormat.format(emision.getFecha());
            pst.setString(3, fechaFormateada);
            
            // Formatear la hora en el formato hh:mm
            SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
            String horaFormateada = horaFormat.format(emision.getHora());
            pst.setString(4, horaFormateada);

            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
