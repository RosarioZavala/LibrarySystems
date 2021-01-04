package edu.tesji.sistemas.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tesji.library.utils.SessionAttributes;

@WebServlet(name="/AutorController", urlPatterns = { "/autor"})
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = -5787552603959991230L;
	private static final Logger log = Logger.getLogger(AutorController.class);

public AutorController() {
	super();
}

protected void doGet(HttpServletRequest request,HttpServlet response) throws ServletException, IOException{
	String action = request.getParameter("action");
	log.info("##### controller libro" + action);
	
	switch (action) {
	case SessionAttributes.ACTION_INIT:
		default:
break;
	}
	

}
protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	doGet(request,response);
}
}