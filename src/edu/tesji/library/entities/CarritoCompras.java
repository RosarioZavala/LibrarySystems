package edu.tesji.library.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {

	/* Mapeo de los atributos de la tabla */
	private int idCarritoCompras;
	private Date fechaCompra;
	private Date fehaEntrega;
	private String lugarEntrega;
	private StatusCarritoCompra status;
	private String folio;
	private String nombrecomprador;
	private List<DetalleCarritoCompras> detalleCCLis;

	public CarritoCompras(int idCarritoCompras, Date fechaCompra, Date fehaEntrega, String lugarEntrega
			, StatusCarritoCompra status, String folio, String nombrecomprador) {
		super();

		this.idCarritoCompras = idCarritoCompras;
		this.fechaCompra = fechaCompra;
		this.fehaEntrega = fehaEntrega;
		this.lugarEntrega = lugarEntrega;
		this.setStatus(status);
		this.folio = folio;
		this.nombrecomprador = nombrecomprador;
		this.detalleCCLis = new ArrayList<DetalleCarritoCompras>();
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

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getNombrecomprador() {
		return nombrecomprador;
	}

	public void setNombrecomprador(String nombrecmprador) {
		this.nombrecomprador = nombrecmprador;
	}

	public List<DetalleCarritoCompras> getDetalleCCLis() {
		return detalleCCLis;
	}

	public void setDetalleCCLis(List<DetalleCarritoCompras> detalleCCLis) {
		this.detalleCCLis = detalleCCLis;
	}

	public StatusCarritoCompra getStatus() {
		return status;
	}

	public void setStatus(StatusCarritoCompra status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CarritoCompras [idCarritoCompras=" + idCarritoCompras + ", fechaCompra=" + fechaCompra
				+ ", fehaEntrega=" + fehaEntrega + ", lugarEntrega=" + lugarEntrega + ", status=" + status
				+ ", folio=" + folio + ", nombrecmprador=" + nombrecomprador + ", detalleCCLis=" + detalleCCLis + "]";
	}

}
