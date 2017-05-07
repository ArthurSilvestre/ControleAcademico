package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Professor;
import br.unipe.javaweb.controleacademico.services.ProfessorService;

@SuppressWarnings("serial")
public class CreateProfessorServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String areaAtuacao = req.getParameter("areaatuacao");
		String titulacao = req.getParameter("titulacao");
		
		Professor professor = new Professor();
		professor.setCpf(cpf);
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setAreaAtuacao(areaAtuacao);
		professor.setTitulacao(titulacao);
		
		ProfessorService.inserir(professor);
		
		resp.sendRedirect("listaProfessor.jsp");
	}
}
