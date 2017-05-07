package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Disciplina;
import br.unipe.javaweb.controleacademico.services.DisciplinaService;

@SuppressWarnings("serial")
public class ReadDisciplinaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		List<Disciplina> disciplinas = DisciplinaService.listarDisciplinas();
	    request.setAttribute("disciplinas", disciplinas);
	    RequestDispatcher rd = request.getRequestDispatcher("listaDisciplina.jsp");
	    rd.forward(request, response);
	}
}
