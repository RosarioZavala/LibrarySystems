package edu.tesji.library.entities;

import java.sql.Date;
import java.util.List;

public class CarritoCompras {

	/* Mapeo de los atributos de la tabla */
	private  int idCarritoCompras;
	private  Date fechaCompra;
	private  Date fehaEntrega;
	private  String lugarEntrega;
	private  int idStatus;
	private  String folio;
	private  String nombrecmprador;
	private  List <DetalleCarritoCompras> detalleCCLis;
	
	public CarritoCompras(int idCarritoCompras, Date fechaCompra, Date fehaEntrega, String lugarEntrega, int idStatus,
			String folio, String nombrecmprador) {
		super();
		
		this.idCarritoCompras = idCarritoCompras;
		this.fechaCompra = fechaCompra;
		this.fehaEntrega = fehaEntrega;
		this.lugarEntrega = lugarEntrega;
		this.idStatus = idStatus;
		this.folio = folio;
		this.nombrecmprador = nombrecmprador;
		this.detalleCCLis = detalleCCLis;
	}
	
	public int getIdCarritoCompras() {
		return idCarritoCompras;
	}
	public void setIdCarritoCompras(int idCarritoCompras) {
		this.idCarritoCompras = idCarritoCompras;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public Date getFehaEntrega() {
		return fehaEntrega;
	}
	public void setFehaEntrega(Date fehaEntrega) {
		this.fehaEntrega = fehaEntrega;
	}
	public String getLugarEntrega() {
		return lugarEntrega;
	}
	public void setLugarEntrega(String lugarEntrega) {
		this.lugarEntrega = lugarEntrega;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getNombrecmprador() {
		return nombrecmprador;
	}
	public void setNombrecmprador(String nombrecmprador) {
		this.nombrecmprador = nombrecmprador;
	}
	public List<DetalleCarritoCompras> getDetalleCCLis() {
		return detalleCCLis;
	}
	public void setDetalleCCLis(List<DetalleCarritoCompras> detalleCCLis) {
		this.detalleCCLis = detalleCCLis;
	}
	@Override
	public String toString() {
		return "CarritoCompras [idCarritoCompras=" + idCarritoCompras + ", fechaCompra=" + fechaCompra
				+ ", fehaEntrega=" + fehaEntrega + ", lugarEntrega=" + lugarEntrega + ", idStatus=" + idStatus
				+ ", folio=" + folio + ", nombrecmprador=" + nombrecmprador + ", detalleCCLis=" + detalleCCLis + "]";
	}
	

}
