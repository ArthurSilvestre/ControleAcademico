package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Usuario;
import br.unipe.javaweb.controleacademico.services.UsuarioService;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(login.equals("") || senha.equals("")){
			response.sendRedirect("index.html");
			return;
		}
		
		Usuario usuario = UsuarioService.efetuarLogin(login, senha);
		
		if(usuario == null){
			response.sendRedirect("index.html");
			return;
		}
		
		request.getSession().setAttribute("usuario", usuario);
		
		response.sendRedirect("menu.jsp");
	}
	
}
