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

import edu.tesji.library.entities.Autor;
import edu.tesji.library.entities.Editorial;
import edu.tesji.library.entities.Libro;
import edu.tesji.library.persistence.dao.AutorDAO;
import edu.tesji.library.persistence.dao.EditorialDAO;
import edu.tesji.library.persistence.dao.LibroDAO;
import edu.tesji.library.utils.SessionAttributes;

@WebServlet(name = "LibroController", urlPatterns = { "/libros" })

public class LibroController extends HttpServlet {

	private static final long serialVersionUID = -4559494590866548992L;
	private static final Logger log = Logger.getLogger(LibroController.class);

	public LibroController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		log.info("##### controller libro:" + action);

		String isbn = request.getParameter("isbnTXT");
		String titulo = request.getParameter("tituloTXT");
		String idEditorialSelected = request.getParameter("editorialSelect");
		String idAutorSelected = request.getParameter("autorSelect");
		log.info("idEditorialSelected: " + idEditorialSelected);
		log.info("idAutorSelected: " + idAutorSelected);
		String descripcion = request.getParameter("descripcionTXT");
		String paginas = request.getParameter("numeroPaginasTXT");
		int inventario = Integer
				.parseInt(request.getParameter("inventarioTXT") == null ? "0" : request.getParameter("inventarioTXT"));
		BigDecimal precioVenta = new BigDecimal(
				request.getParameter("precioVentaTXT") == null ? "0" : request.getParameter("precioVentaTXT"));
		BigDecimal precioCompra = new BigDecimal(
				request.getParameter("precioComprasTXT") == null ? "0" : request.getParameter("precioComprasTXT"));
//		String portada = request.getParameter("portadaTXT");

//	int idLibro, String titulo, String isbn, String descripcion, String paginas, BigDecimal precioVenta,
//	BigDecimal precioCompra, int inventario, boolean status, InputStream portada

		Libro libroEntity = new Libro(0, titulo, isbn, descripcion, paginas, precioVenta, precioCompra, inventario,
				true, null);

		switch (action) {

		case SessionAttributes.ACTION_INIT:
			log.info("######Cargando catálogo de libros");
			List<Libro> listLib = loadLibros();
			log.info("#### Cargando catalogo editoriales ....");
			List<Editorial> list = loadEditoriales();
			log.info("Número de registros a cargar:" + list.size());

			log.info("#### Cargando catalogo de autores ....");
			List<Autor> lista = loadAutores();
			log.info("Número de registros a cargar" + lista.size());

			request.setAttribute("libros", listLib);
			request.setAttribute("autores", lista);
			request.setAttribute("editoriales", list);
			request.getRequestDispatcher("/view/libros/gestion_libros.jsp").forward(request, response);
			break;

		case SessionAttributes.ACTION_FIND:
			log.info("Buscando registro" + libroEntity.toString());
			List<Libro> listaFindL = find(libroEntity);
			request.setAttribute("libros", listaFindL);
			request.getRequestDispatcher("/view/libros/gestion_libros.jsp").forward(request, response);

		default:
			break;

		case SessionAttributes.ACTION_SAVE:
			log.info("#############Guardando registro");
			int affectedRows = insertLibro(libroEntity);
			String message;
			if (affectedRows == 1) {
				message = "Registro agregado exitosamente";
			} else {
				message = "Registro no agregado exitosamente";
			}
			request.setAttribute("message", message);
			// guardar en tablas asociativas
			List<Libro> listaLib = loadLibros();
			request.setAttribute("libros", listaLib);
			request.getRequestDispatcher("/view/libros/gestion_libros.jsp").forward(request, response);

			break;
		}
	}

	private int insertLibro(Libro libroEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	private List<Libro> find(Libro libroEntity) {
		LibroDAO dao = new LibroDAO();
		return dao.selectLibroByFilters(libroEntity);
	}

	private List<Libro> loadLibros() {
		LibroDAO dao = new LibroDAO();
		return dao.selectAllLibros();

	}

	private List<Autor> loadAutores() {
		AutorDAO dao = new AutorDAO();
		return dao.selectAllAutor();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private List<Editorial> loadEditoriales() {
		EditorialDAO dao = new EditorialDAO();
		return dao.selectAllEditorial();
	}
}
