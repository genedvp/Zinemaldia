package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloSala extends Conector{

    public ArrayList<Sala> getTodas() {
        ArrayList<Sala> salas = new ArrayList<>();

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM salas");
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setId(rs.getInt("id_sala"));
                sala.setDescripcion(rs.getString("descripcion"));
                sala.setCapacidad(rs.getInt("capacidad"));
                salas.add(sala);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return salas;
    }

    public Sala getSala(int id) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM salas WHERE id_sala = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Sala sala = new Sala();
                sala.setId(rs.getInt("id_sala"));
                sala.setDescripcion(rs.getString("descripcion"));
                sala.setCapacidad(rs.getInt("capacidad"));
                return sala;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteSala(int id) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM salas WHERE id_sala = ?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int updateSala(Sala sala) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE salas SET descripcion = ?, capacidad = ? WHERE id_sala = ?");
            pst.setString(1, sala.getDescripcion());
            pst.setInt(2, sala.getCapacidad());
            pst.setInt(3, sala.getId());
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void insertSala(Sala sala) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO salas (descripcion, capacidad) VALUES (?, ?)");
            pst.setString(1, sala.getDescripcion());
            pst.setInt(2, sala.getCapacidad());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
