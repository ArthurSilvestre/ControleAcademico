package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Disciplina;
import br.unipe.javaweb.controleacademico.services.DisciplinaService;

@SuppressWarnings("serial")
public class CreateDisciplinaServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String area = req.getParameter("area");
		
		Disciplina disciplina = new Disciplina();
		disciplina.setNome(nome);
		disciplina.setArea(area);
		
		DisciplinaService.inserir(disciplina);

		resp.sendRedirect("listaDisciplina.jsp");
	}
}
