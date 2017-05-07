package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Professor;
import br.unipe.javaweb.controleacademico.services.ProfessorService;

@SuppressWarnings("serial")
public class DeleteProfessorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		if (request.getParameter("id") != null){
			long id = Integer.parseInt(request.getParameter("id"));
			
			Professor professor = ProfessorService.buscarProfessor(id);
			if(professor != null){
				ProfessorService.excluir(professor);
			}
			
			response.sendRedirect("listaProfessor.jsp");
		}
	}
}
