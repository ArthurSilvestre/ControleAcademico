package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Curso;
import br.unipe.javaweb.controleacademico.services.CursoService;

@SuppressWarnings("serial")
public class CreateCursoServlet extends HttpServlet  {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String tipo = request.getParameter("tipo");
		
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setDescricao(descricao);
		curso.setTipo(tipo);
				
		CursoService.inserir(curso);
		
		response.sendRedirect("listaCurso.jsp");
	}
	
}
