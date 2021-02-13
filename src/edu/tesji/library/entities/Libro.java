package edu.tesji.library.entities;

import java.math.BigDecimal;

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
	private int idAutor;
	private int idEditorial;
	private String autor;
	private String editorial;

	public Libro() {
		// empty constructor
	}
	
	public Libro(int idLibro, String titulo, String isbn, String descripcion, String paginas, BigDecimal precioVenta,
			BigDecimal precioCompra, int inventario, boolean status, int idAutor,
			int idEditorial) {
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
		this.idAutor = idAutor;
		this.idEditorial = idEditorial;
	}
	
	public Libro(int idLibro, String titulo, String isbn, String descripcion, String paginas, BigDecimal precioVenta,
			BigDecimal precioCompra, int inventario, boolean status, int idAutor,
			int idEditorial, String autor, String editorial) {
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
		this.idAutor = idAutor;
		this.idEditorial = idEditorial;
		this.autor = autor;
		this.editorial = editorial;
	}
	public Libro(int idLibro, String titulo, String isbn, String descripcion, BigDecimal precioVenta,
			int inventario, boolean status,int idAutor,
			int idEditorial, String autor, String editorial) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.isbn = isbn;
		this.descripcion = descripcion;
		this.precioVenta = precioVenta;
		this.inventario = inventario;
		this.status = status;
		this.idAutor = idAutor;
		this.idEditorial = idEditorial;
		this.autor = autor;
		this.editorial = editorial;
	}
	/**
	 * noa airve para buscar en la pantalla del cliente, por titulo, autor o editorial
	 * @param titulo
	 * @param autor
	 * @param editorial
	 */
	public Libro(String tituloAutorEditorialFilter) {
		super();
		this.titulo = tituloAutorEditorialFilter;
		this.autor = tituloAutorEditorialFilter;
		this.editorial = tituloAutorEditorialFilter;
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

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", isbn=" + isbn + ", descripcion=" + descripcion
				+ ", paginas=" + paginas + ", precioVenta=" + precioVenta + ", precioCompra=" + precioCompra
				+ ", inventario=" + inventario + ", status=" + status + ", idAutor=" + idAutor
				+ ", idEditorial=" + idEditorial + ", autor=" + autor + ", editorial=" + editorial + "]";
	}

}