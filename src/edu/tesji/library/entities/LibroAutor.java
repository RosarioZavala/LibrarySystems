package edu.tesji.library.entities;

public class LibroAutor {

	private int idLibro;
	private int idAutor;

	/* Constructor */
	public LibroAutor(int idLibro, int idAutor) {
		super();
		this.idLibro = idLibro;
		this.idAutor = idAutor;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	@Override
	public String toString() {
		return "LibroAutor [idLibro=" + idLibro + ", idAutor=" + idAutor + "]";
	}

}
