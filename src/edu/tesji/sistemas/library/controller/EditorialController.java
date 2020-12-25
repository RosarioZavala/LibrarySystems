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

        switch (action) {
        case SessionAttributes.ACTION_INIT:
			log.info("##### Cargando catálogo de Editoriales... ");
			List<Editorial> list = loadEditoriales();
			log.info("Número de registros a cargar: " + list.size());

			request.setAttribute("editoriales", list);
			request.getRequestDispatcher("/view/editorial/gestion_editorial.jsp").forward(request, response);
			break;
        case SessionAttributes.ACTION_SAVE:
			log.info("##### Guardando Editorial... ");
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
        
}

