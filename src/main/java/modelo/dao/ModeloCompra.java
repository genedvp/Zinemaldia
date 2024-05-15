package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ModeloCompra extends Conector{

	public void insertFactura(Factura factura) {
		
	    try {
	        PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO facturas (id_emision, id_usuario, fecha_compra, hora_compra) VALUES (?, ?, ?, ?)");
	        pst.setInt(1, factura.getEmision().getId());
	        pst.setInt(2, factura.getUsuario().getId());
	        //pst.setDouble(3, factura.getPrecioTotal());
	        
            // Formatear la fecha en el formato yyyy-MM-dd
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = dateFormat.format(factura.getFecha());
	        pst.setString(3, fechaFormateada);
	        
	        // Formatear la hora en el formato hh:mm
            SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
            String horaFormateada = horaFormat.format(factura.getHora());
	        pst.setString(4, horaFormateada);
	        
	        pst.execute();
	        System.out.println("factura "+factura.toString()+" insertada");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
    public ArrayList<Factura> getTodas() {
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM facturas");
            while (rs.next()) {
                Factura factura = new Factura();
                factura.setId(rs.getInt("id_factura"));
                factura.setFecha(rs.getDate("fecha_compra"));
                factura.setHora(rs.getTime("hora_compra"));
                factura.setEmision(getEmisionById(rs.getInt("id_emision")));
                factura.setUsuario(getUsuarioById(rs.getInt("id_usuario")));
                facturas.add(factura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facturas;
    }

    public Factura getFactura(int idFactura) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM facturas WHERE id_factura=?");
            pst.setInt(1, idFactura);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Factura factura = new Factura();
                factura.setId(rs.getInt("id_factura"));
                factura.setFecha(rs.getDate("fecha_compra"));
                factura.setHora(rs.getTime("hora_compra"));
                factura.setEmision(getEmisionById(rs.getInt("id_emision")));
                factura.setUsuario(getUsuarioById(rs.getInt("id_usuario")));
                return factura;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteFactura(int id) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM facturas WHERE id_factura=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int updateFactura(Factura factura) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE facturas SET id_emision = ?, id_usuario = ?, fecha_compra = ?, hora_compra = ? WHERE id_factura = ?");
            pst.setInt(1, factura.getEmision().getId());
            pst.setInt(2, factura.getUsuario().getId());
            
            // Formatear la fecha en el formato yyyy-MM-dd
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = dateFormat.format(factura.getFecha());
            pst.setString(3, fechaFormateada);
            
            // Formatear la hora en el formato HH:mm
            SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
            String horaFormateada = horaFormat.format(factura.getHora());
            pst.setString(4, horaFormateada);
            
            pst.setInt(5, factura.getId());
            
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private Emision getEmisionById(int idEmision) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM emisiones WHERE id_emision=?");
            pst.setInt(1, idEmision);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Emision emision = new Emision();
                emision.setId(rs.getInt("id_emision"));
                // Completar con otros atributos de Emision
                return emision;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Usuario getUsuarioById(int idUsuario) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM usuarios WHERE id_usuario=?");
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                // Completar con otros atributos de Usuario
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

