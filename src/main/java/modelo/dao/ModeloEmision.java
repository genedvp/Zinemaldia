package modelo.dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class ModeloEmision extends Conector {

    public ArrayList<Emision> getTodas() {
        ArrayList<Emision> emisiones = new ArrayList<>();

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM emisiones");
            while (rs.next()) {
                Emision emision = new Emision();
                emision.setId(rs.getInt("id_emision"));
                emision.setIdPelicula(rs.getInt("id_pelicula"));
                emision.setIdSala(rs.getInt("id_sala"));
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
                emision.setIdPelicula(rs.getInt("id_pelicula"));
                emision.setIdSala(rs.getInt("id_sala"));
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

            pst.setInt(1, emision.getIdPelicula());
            pst.setInt(2, emision.getIdSala());
            pst.setDate(3, (Date) emision.getFecha());
            pst.setTime(4, (Time) emision.getHora());
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
            pst.setInt(1, emision.getIdPelicula());
            pst.setInt(2, emision.getIdSala());
            pst.setDate(3, (Date) emision.getFecha());
            pst.setTime(4, (Time) emision.getHora());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
