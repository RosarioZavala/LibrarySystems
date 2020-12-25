package edu.tesji.sistemas.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.Usuario;
import edu.tesji.library.persistence.dao.UsuarioDAO;
import edu.tesji.library.utils.SessionAttributes;


/**
 * Servlet implementation class LoginController
 */
@WebServlet(name="/LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = -7690912214756326308L;
    private static final Logger log = Logger.getLogger(LoginController.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("##### iniciando... info ");
        String user = request.getParameter("usuarioTXT");
        String password = request.getParameter("passwordTXT");

        Usuario usuarioEntity = new Usuario(0, user, password, true);
        request.getSession().getId();
        log.info("##### Autenticando usuario " + usuarioEntity.toString());
        

        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> userList = dao.selectUsuario(usuarioEntity);
        
        if (!userList.isEmpty()) {
            log.info("Credenciales válidas " + usuarioEntity.toString());
            log.info(userList.get(0).toString());

            request.getSession().setAttribute(SessionAttributes.USER_ADMIN_NAME, 
            		userList.get(0).getNombre());
            response.sendRedirect("/LibrarySystems/view/login/inicio.jsp");
        } else {
            log.warn("Credenciales inválidas " + usuarioEntity.toString());
            response.sendRedirect("/LibrarySystems/");
        }
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

