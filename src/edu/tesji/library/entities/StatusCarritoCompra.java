package edu.tesji.library.entities;

import java.util.HashMap;
import java.util.Map;

public enum StatusCarritoCompra {

	LISTO_PARA_ENTREGAR(1, "LISTO_PARA_ENTREGAR"),
	ENTREGADO(2, "ENTREGADO"),
	NO_ENTREGADO(3, "NO ENTREGADO");
	
	private static final Map<Integer, StatusCarritoCompra> BY_IDSTATUS = new HashMap<>();
	private static final Map<String, StatusCarritoCompra> BY_DESCRIPCION = new HashMap<>();
	
	static {
		for (StatusCarritoCompra sc : values()) {
			BY_IDSTATUS.put(sc.idStatus, sc);
			BY_DESCRIPCION.put(sc.descripcion, sc);
		}
	}

	public final int idStatus;
	public final String descripcion;
	
	private StatusCarritoCompra(int idStatus, String descripcion) {
		this.idStatus = idStatus;
		this.descripcion = descripcion;
	}

	public static StatusCarritoCompra valueOfIdStatus(int idStatus) {
		return BY_IDSTATUS.get(idStatus);
	}

	public static StatusCarritoCompra valueOfDescription(String descripcion) {
		return BY_DESCRIPCION.get(descripcion);
	}
	
}
