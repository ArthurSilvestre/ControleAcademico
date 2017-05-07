<%@page import="br.unipe.javaweb.controleacademico.services.DisciplinaService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="br.unipe.javaweb.controleacademico.model.*, java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Disciplinas</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
</head>
<body>

	<a href="editDisciplina.jsp"> Incluir Disciplina </a>
	</br>
	<a href="menu.jsp"> voltar </a>
	</br>

	<%
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		List<Disciplina> disciplinas = DisciplinaService.listarDisciplinas();

		String filtro = (String) request.getParameter("filtro");
	%>

	<%
		if (disciplinas == null || disciplinas.isEmpty()) {
	%>
	Disciplinas não cadastradas
	<%
		} else {
	%>
	<table class="highlight">
		<tr>
			<th>Nome
			<th />
			<th>Area
			<th />
			<th>Acoes
			<th />
		</tr>
		<%
			for (Disciplina disciplina : disciplinas) {
		%>
		<tr>
			<td><%=disciplina.getNome()%>
			<td />
			<td><%=disciplina.getArea()%>
			<td />
			<td><a href='deletedisciplina?id=<%=disciplina.getId()%>'>excluir</a>
				<a href='editDisciplina.jsp?id=<%=disciplina.getId()%>'>editar</a>
			<td />
		</tr>
		<%
			}

			}
		%>
	</table>
</body>
</html>
