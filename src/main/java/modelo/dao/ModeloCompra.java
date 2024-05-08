package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModeloCompra extends Conector{

	public void insertFactura(Factura factura) {
		
	    try {
	        PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO facturas (id_emision, id_usuario, precio_total, fecha_compra, hora_compra) VALUES (?, ?, ?, ?, ?)");
	        pst.setInt(1, factura.getEmision().getId());
	        pst.setInt(2, factura.getUsuario().getId());
	        pst.setDouble(3, factura.getPrecioTotal());
	        pst.setDate(4, new java.sql.Date(factura.getFecha().getTime()));
	        pst.setTime(5, new java.sql.Time(factura.getHora().getTime()));
	        pst.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	
}
