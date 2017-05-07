package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Professor;
import br.unipe.javaweb.controleacademico.services.ProfessorService;

@SuppressWarnings("serial")
public class ReadProfessorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		List<Professor> professores = ProfessorService.listarProfessores();
	    request.setAttribute("professores", professores);
	    RequestDispatcher rd = request.getRequestDispatcher("listaProfessor.jsp");
	    rd.forward(request, response);
	}
}
