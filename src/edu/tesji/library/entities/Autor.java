package edu.tesji.library.entities;

public class Autor {
	/* Mapeo de atributos de la bd para ser usados en el sistema */
	private int idautor;
	private String nombreCompleto;
	private String nacionalidad;

	public Autor(int idautor, String nombreCompleto, String nacionalidad) {
		super();
		this.idautor = idautor;
		this.nombreCompleto = nombreCompleto;
		this.nacionalidad = nacionalidad;
	}

	/* Generación de getters y setters(Se devuelve o asigna un valor) */
	public int getIdautor() {
		return idautor;
	}

	public void setIdautor(int idautor) {
		this.idautor = idautor;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Author [idautor=" + idautor + ", nombrecompleto=" + nombreCompleto + ", nacionalidad=" + nacionalidad
				+ "]";
	}

}
