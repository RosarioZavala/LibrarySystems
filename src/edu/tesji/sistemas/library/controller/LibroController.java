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
import edu.tesji.library.entities.Editorial;
import edu.tesji.library.persistence.dao.AutorDAO;
import edu.tesji.library.persistence.dao.EditorialDAO;
import edu.tesji.library.utils.SessionAttributes;

@WebServlet(name="LibroController", urlPatterns = { "/libros"})

public class LibroController extends HttpServlet {

	
	private static final long serialVersionUID = -4559494590866548992L;
	private static final Logger log = Logger.getLogger(LibroController.class);
	
	
	public LibroController() {
		super();
	}
	
protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String action = request .getParameter("action");
	log.info("##### controller libro:" + action);
	switch (action) {
	case SessionAttributes.ACTION_INIT:
		log.info("#### Cargando catalogos editoriales ....");
		List<Editorial > list = loadEditoriales();
		log.info("Número de registros a cargar:" + list.size());
		
		
		
		log.info("#### Cargando catalogos de autores ....");
		List<Autor> lista = loadAutores();
		log.info("Número de registros a cargar" + lista.size());
		

		request.setAttribute("autores",lista );
		request.setAttribute("editoriales",list );
		request.getRequestDispatcher("/view/libros/gestion_libros.jsp").forward(request, response);
		break;
		default:
			break;
	}
}

	


private List<Autor> loadAutores() {
AutorDAO dao = new AutorDAO();
return dao.selectAllAutor();
}

protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	doGet(request,response);
}
private List<Editorial> loadEditoriales() {
	EditorialDAO dao = new EditorialDAO();
	return dao.selectAllEditorial();
}
}


