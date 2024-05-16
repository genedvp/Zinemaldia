package modelo.dao;

import java.util.Date;

public class Factura {
	
	private int id;
	private Usuario usuario;
	private Emision emision;
	private Double precioTotal;
	private Date fecha;
	private Date hora;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Emision getEmision() {
		return emision;
	}
	public void setEmision(Emision emision) {
		this.emision = emision;
	}
	public Double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", usuario=" + usuario + ", emision=" + emision + ", precioTotal=" + precioTotal
				+ ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
}
