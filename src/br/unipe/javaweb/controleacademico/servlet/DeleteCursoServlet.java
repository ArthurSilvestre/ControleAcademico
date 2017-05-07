package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Curso;
import br.unipe.javaweb.controleacademico.services.CursoService;

@SuppressWarnings("serial")
public class DeleteCursoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		if (request.getParameter("id") != null){
			long id = Integer.parseInt(request.getParameter("id"));
			
			Curso curso = CursoService.buscarCurso(id);
			if(curso != null){
				CursoService.excluir(curso);
			}
			
			response.sendRedirect("listaCurso.jsp");
		}
	}
}
