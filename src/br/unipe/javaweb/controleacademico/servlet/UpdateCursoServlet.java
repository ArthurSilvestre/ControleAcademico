package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Curso;
import br.unipe.javaweb.controleacademico.services.CursoService;

@SuppressWarnings("serial")
public class UpdateCursoServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		long id = Integer.parseInt(request.getParameter("id"));
		
		Curso curso = CursoService.buscarCurso(id);

	    request.setAttribute("curso", curso);
	    RequestDispatcher rd = request.getRequestDispatcher("editCurso.jsp");
	    rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String descricao = req.getParameter("descricao");
		String tipo = req.getParameter("tipo");
		
		Curso curso = CursoService.buscarCurso(id);		
		curso.setNome(nome);
		curso.setDescricao(descricao);
		curso.setTipo(tipo);	
		
		CursoService.atualizar(curso);
		
		resp.sendRedirect("listaCurso.jsp");		
	}
}
