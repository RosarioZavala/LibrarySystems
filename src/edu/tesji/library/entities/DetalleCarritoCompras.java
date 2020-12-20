package edu.tesji.library.entities;

import java.math.BigDecimal;

public class DetalleCarritoCompras {
	
	private  int idDetalleCarritoCompras;
	private  int idCarritoCompras;
	private  int idLibro;
	private  int cantidad;
	private  BigDecimal precioUnitarioVenta;
	private  BigDecimal precioUnitarioCompra;
	
	
	public DetalleCarritoCompras(int idDetalleCarritoCompras, int idCarritoCompras, int idLibro, int cantidad,
			BigDecimal precioUnitarioVenta, BigDecimal precioUnitarioCompra) {
		super();
		this.idDetalleCarritoCompras = idDetalleCarritoCompras;
		this.idCarritoCompras = idCarritoCompras;
		this.idLibro = idLibro;
		this.cantidad = cantidad;
		this.precioUnitarioVenta = precioUnitarioVenta;
		this.precioUnitarioCompra = precioUnitarioCompra;
	}
	public int getIdDetalleCarritoCompras() {
		return idDetalleCarritoCompras;
	}
	public void setIdDetalleCarritoCompras(int idDetalleCarritoCompras) {
		this.idDetalleCarritoCompras = idDetalleCarritoCompras;
	}
	public int getIdCarritoCompras() {
		return idCarritoCompras;
	}
	public void setIdCarritoCompras(int idCarritoCompras) {
		this.idCarritoCompras = idCarritoCompras;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioUnitarioVenta() {
		return precioUnitarioVenta;
	}
	public void setPrecioUnitarioVenta(BigDecimal precioUnitarioVenta) {
		this.precioUnitarioVenta = precioUnitarioVenta;
	}
	public BigDecimal getPrecioUnitarioCompra() {
		return precioUnitarioCompra;
	}
	public void setPrecioUnitarioCompra(BigDecimal precioUnitarioCompra) {
		this.precioUnitarioCompra = precioUnitarioCompra;
	}
	
	@Override
	public String toString() {
		return "DetalleCarritoCompras [idDetalleCarritoCompras=" + idDetalleCarritoCompras + ", idCarritoCompras="
				+ idCarritoCompras + ", idLibro=" + idLibro + ", cantidad=" + cantidad + ", precioUnitarioVenta="
				+ precioUnitarioVenta + ", precioUnitarioCompra=" + precioUnitarioCompra + "]";
	}
	
}
