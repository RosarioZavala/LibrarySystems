package edu.tesji.sistemas.library.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.Libro;
import edu.tesji.library.persistence.dao.LibroDAO;
import edu.tesji.library.utils.SessionAttributes;

@WebServlet(name = "DetalleLibroController", urlPatterns = { "/detalleLibro" })
public class DetalleLibroController extends HttpServlet {

	private static final long serialVersionUID = 913424453695395559L;
	private static final Logger LOG = Logger.getLogger(DetalleLibroController.class);

	public DetalleLibroController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		LOG.info("##### controller detalle libro:" + action);

		switch (action) {
		case SessionAttributes.ACTION_INIT:
			String idLibroForSeeDetail = request.getParameter("idLibroForSeeDetail");
			LOG.info("idLibroForSeeDetail " + idLibroForSeeDetail);
			
			Libro libroFilter = new Libro();
			libroFilter.setIdLibro(Integer.parseInt(idLibroForSeeDetail));
			LOG.info("##### controller detalleLibro: " + action);
			LOG.info("##### libroFilter autor: " + libroFilter.getIdLibro());

			List<Libro> libroList = getDetalleLibro(libroFilter);
			LOG.info("libroList.size " + libroList.size());

			request.setAttribute("detalleLibro", libroList.get(0));
			request.getRequestDispatcher("/view/viewClient/detalleLibro.jsp").forward(request, response);
			break;
		
		
			case SessionAttributes.ACTION_SAVE:
//				String titulo = request.getParameter("tituloLibroTXT");
//				String isbn = request.getParameter(ISBNLibroTXT)
//				String autor = request
//				String descripcion =
//				
//				String total = request.getParameter("totalTXT"); 
//				String cantidad = request.getParameter("cantidadTXT");
//				String precio = request.getParameter("precioTXT");
//				Strig
//			
		
				break;
				default:
				
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	private List<Libro> getDetalleLibro(Libro libroToFind) {
		LibroDAO dao = new LibroDAO();
		return dao.selectLibroForCliente(libroToFind);
	}
}
