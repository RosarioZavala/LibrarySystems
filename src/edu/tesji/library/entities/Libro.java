package edu.tesji.library.entities;

import java.math.BigDecimal;

public class Libro {
	private int idLibro;
	private String isbn;
	private String descripcion;
	private String paginas;
	private BigDecimal precioVenta;
	private BigDecimal precioCompra;
	private int inventario;
	private boolean status;

	public Libro(int idLibro, String isbn, String descripcion, String paginas, BigDecimal precioVenta,
			BigDecimal precioCompra, int inventario, boolean status) {
		super();
		this.idLibro = idLibro;
		this.isbn = isbn;
		this.descripcion = descripcion;
		this.paginas = paginas;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
		this.inventario = inventario;
		this.status = status;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", isbn=" + isbn + ", descripcion=" + descripcion + ", paginas=" + paginas
				+ ", precioVenta=" + precioVenta + ", precioCompra=" + precioCompra + ", inventario=" + inventario
				+ ", status=" + status + "]";
	}

}
