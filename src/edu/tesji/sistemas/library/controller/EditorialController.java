package edu.tesji.sistemas.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.Editorial;
import edu.tesji.library.persistence.dao.EditorialDAO;
import edu.tesji.library.utils.SessionAttributes;


/**
 * Servlet implementation class EditorialController
 */
@WebServlet(name="/EditorialController", urlPatterns = { "/editorial" })
public class EditorialController extends HttpServlet {
	private static final long serialVersionUID = -5787552603959991230L;
	private static final Logger log = Logger.getLogger(EditorialController.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        log.info("##### controller editorial: " + action);
        String nombreEditorial = request.getParameter("nombreEditorialTXT");
        String lugarImpresion = request.getParameter("lugarImpresionTXT");
       
        Editorial editorialEntity = new Editorial(0,nombreEditorial,lugarImpresion );
        		
        switch (action) {
        case SessionAttributes.ACTION_INIT:
			log.info("##### Cargando catálogo de Editoriales... ");
			List<Editorial> list = loadEditoriales();
			request.setAttribute("editoriales", list);
			request.getRequestDispatcher("/view/editorial/gestion_editorial.jsp").forward(request, response);
		
			log.info("Número de registros a cargar: " + list.size());

			
			break;
        case SessionAttributes.ACTION_SAVE:
			log.info("##### Guardando Editorial... ");
			int affectedRows = insertEditorial(editorialEntity);
			String message;
			if(affectedRows == 1) {
				message = "Registro insertado exitosamente.";
			} else {
				message = "Registro NO insertado exitosamente.";
			}
			request.setAttribute("mesage", message);
			
			List<Editorial> lista= loadEditoriales();
			request.setAttribute("editoriales", lista);
			request.getRequestDispatcher("/view/editorial/gestion_editorial.jsp").forward(request, response);
			
			log.info("#######Número de registros agregados" + editorialEntity);
			break;

		case SessionAttributes.ACTION_FIND:
			log.info("Buscando Registro: " + editorialEntity.toString());
			List<Editorial>listaFind = find(editorialEntity);
			request.setAttribute("editoriales", listaFind);
			request.getRequestDispatcher("/view/editorial/gestion_editorial.jsp").forward(request, response);
		break;
		default:
			break;
		}
        
    }


	/**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    private List<Editorial> loadEditoriales() {
		EditorialDAO dao = new EditorialDAO();
		return dao.selectAllEditorial();
		
	}
    
	private List<Editorial> find(Editorial editorialEntity) {
		EditorialDAO dao = new EditorialDAO();
		return dao.selectEditorialByFilters(editorialEntity);
		
	}
	


	private int insertEditorial(Editorial editorialEntity) {
		// TODO Auto-generated method stub
	EditorialDAO dao = new EditorialDAO();
	return dao.insertEditorial(editorialEntity);
	
	
	

	}    
}

