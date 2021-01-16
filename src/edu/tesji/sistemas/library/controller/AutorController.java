package edu.tesji.sistemas.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.Autor;
import edu.tesji.library.persistence.dao.AutorDAO;
import edu.tesji.library.utils.SessionAttributes;

@WebServlet(name = "/AutorController", urlPatterns = {"/autor"})
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = -5787552603959991230L;
	private static final Logger log = Logger.getLogger(AutorController.class);

	public AutorController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		log.info("##### controller Autor: " + action);
		String claveAutor = request.getParameter("claveAutorTXT");
		String nacionalidad = request.getParameter("nacionalidadTXT");
		String nombreCompleto = request.getParameter("nombreTXT");

		Autor autorEntity = new Autor(0, claveAutor, nombreCompleto, nacionalidad);
		// request.getSession();

		switch (action) {
		case SessionAttributes.ACTION_INIT:
			List<Autor>list = loadAutores();
			request.setAttribute("autores", list);
			request.getRequestDispatcher("/view/autor/gestion_autor.jsp").forward(request, response);
		
			break;
		case SessionAttributes.ACTION_SAVE:
			log.info("##### Guardando Autor... ");
			int affectedRows = insertAutor(autorEntity);
			String message;
			if (affectedRows == 1) {
				message = "Registro insertado exitosamente.";
			} else {
				message = "Registro NO insertado exitosamente.";
			}
			request.setAttribute("message", message);

			List<Autor>lista = loadAutores();
			request.setAttribute("autores", lista);
			
			request.getRequestDispatcher("/view/autor/gestion_autor.jsp").forward(request, response);
			
			break;
		case SessionAttributes.ACTION_DELETE:
			log.info("Eliminando registro");
			int affectedRow =deleteAutor(autorEntity);
			String messageError;
			if(affectedRow == 1) {
				messageError = "Registro eliminado exitosamente";
			}else {
				messageError = "Registro no eliminado exitosamente";
			}
			request.setAttribute("messageError", messageError);
			
			List<Autor>listaD = loadAutores();
			request.setAttribute("autores", listaD);
			
			request.getRequestDispatcher("/view/autor/gestion_autor.jsp").forward(request, response);
			
			break;
		case SessionAttributes.ACTION_UPDATE:
				update(autorEntity);
			break;
				
		case SessionAttributes.ACTION_FIND:
			log.info("Buscando Registro: " + autorEntity.toString());
			List<Autor>listaFind = find(autorEntity);
			request.setAttribute("autores", listaFind);
			request.getRequestDispatcher("/view/autor/gestion_autor.jsp").forward(request, response);
			break;
		default:
			break;
		}

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private int insertAutor(Autor autorEntity) {
		AutorDAO dao = new AutorDAO();
		return dao.insertAutor(autorEntity);
	}
	

	private int update(Autor autorEntity) {
		AutorDAO dao = new AutorDAO();
		return dao.updateAutor(autorEntity);
		
	}

	private int deleteAutor(Autor autorEntity) {
		AutorDAO dao = new AutorDAO();
			return dao.deleteAutor(autorEntity);
		
	}
	
	private List<Autor> loadAutores() {
		AutorDAO dao = new AutorDAO();
		return dao.selectAllAutor();
		
	}

	private List<Autor> find(Autor autorEntity) {
		AutorDAO dao = new AutorDAO();
		return dao.selectAutorByFilters(autorEntity);
		
	}

}
