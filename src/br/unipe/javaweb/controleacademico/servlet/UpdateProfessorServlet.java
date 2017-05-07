package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Professor;
import br.unipe.javaweb.controleacademico.services.ProfessorService;

@SuppressWarnings("serial")
public class UpdateProfessorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Integer.parseInt(req.getParameter("id"));
		
		Professor professor = ProfessorService.buscarProfessor(id);

	    req.setAttribute("professor", professor);
	    RequestDispatcher rd = req.getRequestDispatcher("editProfessor.jsp");
	    rd.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Integer.parseInt(req.getParameter("id"));
		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String areaAtuacao = req.getParameter("areaAtuacao");
		String titulacao = req.getParameter("titulacao");
		
		Professor professor = ProfessorService.buscarProfessor(id);
		professor.setCpf(cpf);
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setAreaAtuacao(areaAtuacao);
		professor.setTitulacao(titulacao);
		
		ProfessorService.atualizar(professor);
		
		resp.sendRedirect("listaProfessor.jsp");		
		
	}
}
