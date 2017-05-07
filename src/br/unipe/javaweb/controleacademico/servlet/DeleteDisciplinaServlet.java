package br.unipe.javaweb.controleacademico.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.javaweb.controleacademico.model.Disciplina;
import br.unipe.javaweb.controleacademico.services.DisciplinaService;

@SuppressWarnings("serial")
public class DeleteDisciplinaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		if (request.getParameter("id") != null){
			long id = Integer.parseInt(request.getParameter("id"));
			
			Disciplina disciplina = DisciplinaService.buscarDisciplina(id);
			if(disciplina != null){
				DisciplinaService.excluir(disciplina);
			}
			
			response.sendRedirect("listaDisciplina.jsp");
		}
	}
}
