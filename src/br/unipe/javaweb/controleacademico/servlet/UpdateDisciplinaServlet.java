package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Disciplina;
import br.unipe.javaweb.controleacademico.services.DisciplinaService;

@SuppressWarnings("serial")
public class UpdateDisciplinaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Integer.parseInt(req.getParameter("id"));
		
		Disciplina disciplina = DisciplinaService.buscarDisciplina(id);

	    req.setAttribute("disciplina", disciplina);
	    RequestDispatcher rd = req.getRequestDispatcher("editDisciplina.jsp");
	    rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String area = req.getParameter("area");
		
		Disciplina disciplina = DisciplinaService.buscarDisciplina(id);
		disciplina.setNome(nome);
		disciplina.setArea(area);
		
		DisciplinaService.atualizar(disciplina);

		resp.sendRedirect("listaDisciplina.jsp");		
		
	}
}
