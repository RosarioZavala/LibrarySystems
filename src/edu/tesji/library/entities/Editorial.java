package edu.tesji.library.entities;

public class Editorial {
private  int idEditorial;
private  String nombreEditorial;
private  String lugarDeImpresion;


public Editorial(int idEditorial, String nombreEditorial, String lugarDeImpresion) {
	super();
	this.idEditorial = idEditorial;
	this.nombreEditorial = nombreEditorial;
	this.lugarDeImpresion = lugarDeImpresion;
}


public int getIdEditorial() {
	return idEditorial;
}


public void setIdEditorial(int idEditorial) {
	this.idEditorial = idEditorial;
}


public String getNombreEditorial() {
	return nombreEditorial;
}


public void setNombreEditorial(String nombreEditorial) {
	this.nombreEditorial = nombreEditorial;
}


public String getLugarDeImpresion() {
	return lugarDeImpresion;
}


public void setLugarDeImpresion(String lugarDeImpresion) {
	this.lugarDeImpresion = lugarDeImpresion;
}


@Override
public String toString() {
	return "Editorial [idEditorial=" + idEditorial + ", nombreEditorial=" + nombreEditorial + ", lugarDeImpresion="
			+ lugarDeImpresion + "]";
}





}
