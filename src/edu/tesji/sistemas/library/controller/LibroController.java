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
				.parseInt(request.getParameter("inventarioTXT") == null ||
						request.getParameter("inventarioTXT").trim().isEmpty() ? "0" : request.getParameter("inventarioTXT"));
		BigDecimal precioVenta = new BigDecimal(
				request.getParameter("precioVentaTXT") == null ||
						request.getParameter("precioVentaTXT").trim().isEmpty() ? "0" : request.getParameter("precioVentaTXT"));
		BigDecimal precioCompra = new BigDecimal(
				request.getParameter("precioComprasTXT") == null ||
						request.getParameter("precioComprasTXT").trim().isEmpty() ? "0" : request.getParameter("precioComprasTXT"));
//		String portada = request.getParameter("portadaTXT");

		
		switch (action) {

		case SessionAttributes.ACTION_INIT:
			loadLibrosAndCatalogs(request);
			request.getRequestDispatcher("/view/libros/gestion_libros.jsp").forward(request, response);
			break;

		case SessionAttributes.ACTION_FIND:
			Libro libroEntity = new Libro(0, titulo, isbn, descripcion, paginas, precioVenta, precioCompra, inventario,
					true, null, Integer.parseInt(idAutorSelected), Integer.parseInt(idEditorialSelected));

			log.info("Buscando registro" + libroEntity.toString());
			List<Libro> listaFindL = find(libroEntity);
			request.setAttribute("libros", listaFindL);
			loadCatalogs(request);
			request.getRequestDispatcher("/view/libros/gestion_libros.jsp").forward(request, response);

		default:
			break;

		case SessionAttributes.ACTION_SAVE:
			log.info("#############Guardando registro");
			Libro libroEntitySave = new Libro(0, titulo, isbn, descripcion, paginas, precioVenta, precioCompra, inventario,
					true, null, Integer.parseInt(idAutorSelected), Integer.parseInt(idEditorialSelected));

			int affectedRows = insertLibro(libroEntitySave);
			String message;
			if (affectedRows == 1) {
				message = "Registro agregado exitosamente";
			} else {
				message = "Registro no agregado exitosamente";
			}
			request.setAttribute("message", message);
			loadLibrosAndCatalogs(request);
			request.getRequestDispatcher("/view/libros/gestion_libros.jsp").forward(request, response);

			break;
		}
	}

	private int insertLibro(Libro libroEntity) {
		LibroDAO dao = new LibroDAO();
		return dao.insertLibro(libroEntity);
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

	private void loadLibrosAndCatalogs(HttpServletRequest request) {
		log.info("######Cargando catálogo de libros");
		List<Libro> listLib = loadLibros();
		request.setAttribute("libros", listLib);
		loadCatalogs(request);
	}

	private void loadCatalogs(HttpServletRequest request) {
		log.info("#### Cargando catalogo editoriales ....");
		List<Editorial> list = loadEditoriales();
		log.info("Número de registros a cargar:" + list.size());

		log.info("#### Cargando catalogo de autores ....");
		List<Autor> lista = loadAutores();
		log.info("Número de registros a cargar" + lista.size());

		request.setAttribute("autores", lista);
		request.setAttribute("editoriales", list);
	}
}
