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
		String idAutorForDeleteOrUpdate = request.getParameter("idAutorForDeleteOrUpdate");

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
			
			
			if (idAutorForDeleteOrUpdate == null || idAutorForDeleteOrUpdate.trim().isEmpty()) {
				message = "Debe de seleccionar un registro para Eliminarlo.";
				List<Autor>listaDel = loadAutores();
				request.setAttribute("autores", listaDel);
				request.setAttribute("message", message);
				request.getRequestDispatcher("/view/autor/gestion_autor.jsp").forward(request, response);
				break;
			}
			autorEntity.setIdautor(Integer.parseInt(idAutorForDeleteOrUpdate));
			int affectedRowsDel = deleteAutor(autorEntity);
			if (affectedRowsDel == 1) {
				message = "Registro eliminado exitosamente.";
			} else {
				message = "Registro NO eliminado.";
			}
			request.setAttribute("message", message);

			List<Autor>listaDel = loadAutores();
			request.setAttribute("autores", listaDel);
			request.getRequestDispatcher("/view/autor/gestion_autor.jsp").forward(request, response);
			
			break;
			
		case SessionAttributes.ACTION_UPDATE:
			log.info("Actualizando registro");
					
			if (idAutorForDeleteOrUpdate == null || idAutorForDeleteOrUpdate.trim().isEmpty()) {
				message = "Debe de seleccionar un registro para Actualizarlo.";
				List<Autor>listaUpdate= loadAutores();
				request.setAttribute("autores", listaUpdate);
				request.setAttribute("message", message);
				request.getRequestDispatcher("/view/autor/gestion_autor.jsp").forward(request, response);
				break;
			}
			autorEntity.setIdautor(Integer.parseInt(idAutorForDeleteOrUpdate));
			
			int affectedRowsUp = updateAutor(autorEntity);
			if (affectedRowsUp == 1) {
				
				message = "Registro Actualizado exitosamente.";
			} else {
				message = "Registro NO Actualizado.";
			}
			request.setAttribute("message", message);

			List<Autor>listaUpdate = loadAutores();
			request.setAttribute("autores", listaUpdate);
			request.getRequestDispatcher("/view/autor/gestion_autor.jsp").forward(request, response);
			
			break;
				
		case SessionAttributes.ACTION_FIND:
			log.info("Buscando Registro: " + autorEntity.toString());
			List<Autor>listaFind = find(autorEntity);
			request.setAttribute("autores", listaFind);
			request.getRequestDispatcher("/view/autor/gestion_autor.jsp").forward(request, response);
			break;
		default:
			
		}

	}

	

	private int updateAutor(Autor autorEntity) {
		AutorDAO dao = new AutorDAO();
		return dao.updateAutor(autorEntity);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private int insertAutor(Autor autorEntity) {
		AutorDAO dao = new AutorDAO();
		return dao.insertAutor(autorEntity);
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
