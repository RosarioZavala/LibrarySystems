package edu.tesji.sistemas.library.controller;

import java.io.IOException;
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

@WebServlet(name = "LibroClienController", urlPatterns = { "/libro" })

public class LibroClienController extends HttpServlet {

	private static final long serialVersionUID = 3372047242788579126L;
	private static final Logger LOG = Logger.getLogger(LibroClienController.class);

	public LibroClienController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String action = request.getParameter("action");
		LOG.info("##### controller ClienteLibro: " + action);
		String idLibroForSeeDetail = request.getParameter("idLibroForSeeDetail");
		

		switch (action) {

		case SessionAttributes.ACTION_INIT:
			loadLibros(request);
			request.getRequestDispatcher("/view/viewClient/inicioCliente.jsp").forward(request, response);
			break;


		case SessionAttributes.ACTION_FIND:
			String tituloAutorEditorialFilter = request.getParameter("buscarTXT").trim();
			Libro libroFilter = new	Libro(tituloAutorEditorialFilter);
			LOG.info("Buscando registro" + libroFilter.toString());
			List<Libro> listaFindL = findRegistro(libroFilter);
			request.setAttribute("libros", listaFindL);
			request.getRequestDispatcher("/view/viewClient/inicioCliente.jsp").forward(request, response);

	
			break;
		case SessionAttributes.ACTION_SAVE:
		request.getRequestDispatcher("/view/viewClient/detalleLibro.jsp").forward(request, response);
		 idLibroForSeeDetail = request.getParameter("idLibroForSeeDetail");
		LOG.info(idLibroForSeeDetail);

		default:
			break;
		}
	}



	private List<Libro> findRegistro(Libro libroEntity) {
		LibroDAO dao = new LibroDAO();
		return dao.selectLibroByFiltersTituloAutorOrEditorial(libroEntity);
	
	}

	private void loadLibros(HttpServletRequest request) {
		LOG.info("######Cargando catálogo de libros");
		List<Libro> listLib = loadLibros();
		request.setAttribute("libros", listLib);
	}


	private List<Libro> loadLibros() {
		LibroDAO dao = new LibroDAO();
		return dao.selectAllLibros();

	}
}
