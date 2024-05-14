package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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


	
}
