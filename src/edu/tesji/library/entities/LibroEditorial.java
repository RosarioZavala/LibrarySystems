package edu.tesji.library.entities;

public class LibroEditorial {
	private int idLibro;
	private int idEditorial;

	public LibroEditorial(int idLibro, int idEditorial) {
		super();
		this.idLibro = idLibro;
		this.idEditorial = idEditorial;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	@Override
	public String toString() {
		return "LibroEditorial [idLibro=" + idLibro + ", idEditorial=" + idEditorial + "]";
	}

}
