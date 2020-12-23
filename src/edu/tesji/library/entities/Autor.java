package edu.tesji.library.entities;

public class Autor {
	/* Mapeo de atributos de la bd para ser usados en el sistema */
	private int idautor;
	private String claveautor;
	private String nombreCompleto;
	private String nacionalidad;
	
	public Autor(int idautor, String claveautor, String nombreCompleto, String nacionalidad) {
		super();
		this.idautor = idautor;
		this.claveautor = claveautor;
		this.nombreCompleto = nombreCompleto;
		this.nacionalidad = nacionalidad;
	}

	public int getIdautor() {
		return idautor;
	}

	public void setIdautor(int idautor) {
		this.idautor = idautor;
	}

	public String getClaveautor() {
		return claveautor;
	}

	public void setClaveautor(String claveautor) {
		this.claveautor = claveautor;
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
		return "Autor [idautor=" + idautor + ", claveautor=" + claveautor + ", nombreCompleto=" + nombreCompleto
				+ ", nacionalidad=" + nacionalidad + "]";
	}
	
	

	
}
