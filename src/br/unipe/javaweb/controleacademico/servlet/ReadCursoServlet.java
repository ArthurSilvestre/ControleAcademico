package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Curso;
import br.unipe.javaweb.controleacademico.services.CursoService;

@SuppressWarnings("serial")
public class ReadCursoServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		List<Curso> cursos = CursoService.listarCursos();
	    request.setAttribute("cursos", cursos);
	    RequestDispatcher rd = request.getRequestDispatcher("listaCurso.jsp");
	    rd.forward(request, response);
	}
}
