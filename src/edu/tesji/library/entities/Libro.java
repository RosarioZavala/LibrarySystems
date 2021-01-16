package edu.tesji.library.entities;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;

import org.xml.sax.InputSource;



public class Libro {
	private int idLibro;
	private String titulo;
	private String isbn;
	private String descripcion;
	private String paginas;
	private BigDecimal precioVenta;
	private BigDecimal precioCompra;
	private int inventario;
	private boolean status;
	private InputStream portada;
	
	public Libro(int idLibro, String titulo, String isbn, String descripcion, String paginas, BigDecimal precioVenta,
			BigDecimal precioCompra, int inventario, boolean status, InputStream portada) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.isbn = isbn;
		this.descripcion = descripcion;
		this.paginas = paginas;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
		this.inventario = inventario;
		this.status = status;
		this.portada = portada;
		
		
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public InputStream getPortada() {
		return portada;
	}

	public void setPortada(InputStream portada) {
		this.portada = portada;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", isbn=" + isbn + ", descripcion=" + descripcion
				+ ", paginas=" + paginas + ", precioVenta=" + precioVenta + ", precioCompra=" + precioCompra
				+ ", inventario=" + inventario + ", status=" + status + ", portada=" + portada + "]";
	}
	
	
	
	
	
	}