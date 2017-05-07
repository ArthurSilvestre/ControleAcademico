<%@page import="br.unipe.javaweb.controleacademico.services.ProfessorService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="br.unipe.javaweb.controleacademico.model.*, java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Professores</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
</head>
<body>

	<a href="editProfessor.jsp"> Incluir Professor </a>
	</br>
	<a href="menu.jsp"> voltar </a>
	</br>

	<%
		// Usuario usuario = (Usuario) session.getAttribute("usuario");
		List<Professor> professores = ProfessorService.listarProfessores();

		String filtro = (String) request.getParameter("filtro");
	%>

	<%
		if (professores == null || professores.isEmpty()) {
	%>
	Professores não cadastrados
	<%
		} else {
	%>
	<table class="highlight">
		<tr>
			<th>Nome
			<th />
			<th>E-mail
			<th />
			<th>Acoes
			<th />
		</tr>
		<%
			for (Professor professor : professores) {
		%>
		<tr>
			<td><%=professor.getNome()%>
			<td />
			<td><%=professor.getEmail()%>
			<td />
			<td><a href='deleteprofessor?id=<%=professor.getId()%>'>excluir</a>
				<a href='editProfessor.jsp?id=<%=professor.getId()%>'>editar</a>
			<td />
		</tr>
		<%
			}

			}
		%>
	</table>
</body>
</html>
