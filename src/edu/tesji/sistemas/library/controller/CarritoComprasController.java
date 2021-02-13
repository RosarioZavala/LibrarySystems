package edu.tesji.sistemas.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.CarritoCompras;
import edu.tesji.library.persistence.dao.CarritoComprasDAO;
import edu.tesji.library.utils.SessionAttributes;

@WebServlet (name = "/CarritoComprasController", urlPatterns = { "/carritoCompras"})

public class CarritoComprasController extends HttpServlet {

	private static final long serialVersionUID = 7330356113742109959L;
	private static final Logger log = Logger.getLogger(CarritoComprasController.class);
	
	
	
	public CarritoComprasController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		log.info("#### controller carrito compras" + action);
		String fehaEntrega = request.getParameter("periodoInTXT");
		String fechaCompra = request.getParameter("periodoFinTXT");
		log.info("#### controller carrito compras" + fehaEntrega);
		switch (action) {
		case SessionAttributes.ACTION_INIT:
			log.info("###### Cargando catálogo de Carrito Compras");
			List<CarritoCompras>  list =  loadarritoCompras();
			log.info("Número de registros a cargar:" + list.size() );
			
			request.setAttribute("carritoCompras", list);
			request.getRequestDispatcher("/view/carritoComprasAdmin/carrito_compras_admin.jsp").forward(request, response);
		break;
		default:
			break;
		}
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	doGet(request,response);
}
	private List<CarritoCompras> loadarritoCompras() {
		CarritoComprasDAO dao = new CarritoComprasDAO();
		return dao.selectAllCarritoCompras();
	
	}

}
