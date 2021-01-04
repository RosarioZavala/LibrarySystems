package edu.tesji.sistemas.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.DetalleCarritoCompras;
import edu.tesji.library.utils.SessionAttributes;

@WebServlet(name="/DetalleCarritoComprasController", urlPatterns = { "/DetalleCarritoCompras"})
public class DetalleCarritoComprasController {

	private static final  Logger log = Logger.getLogger(DetalleCarritoComprasController.class);
	
	public DetalleCarritoComprasController() {
		super();
	

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		log.info("####Controller Detalle Carrito Compras " + action);
		
		
		switch (action) {
		case SessionAttributes.ACTION_INIT:
			log.info("Cargando Catálogo de Detalle Carrito Compras...");
			List<DetalleCarritoCompras> list = loadDetalleCarritoCompras();
			log.info("Número de registros a cargar" + list.size());
			
			request.setAttribute("detalleCarritoCompras", list);

		}
	}

	private List<DetalleCarritoCompras> loadDetalleCarritoCompras() {
		// TODO Auto-generated method stub
		return null;
	}
}
