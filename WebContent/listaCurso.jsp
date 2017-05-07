<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="br.unipe.javaweb.controleacademico.model.*, br.unipe.javaweb.controleacademico.services.*, java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Cursos</title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

</head>
<body>

	<a href="editCurso.jsp"> Incluir Curso </a>
	</br>
	<a href="menu.jsp"> voltar </a>
	</br>

	<%
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		List<Curso> cursos = CursoService.listarCursos();

		String filtro = (String) request.getParameter("filtro");
	%>

	<%
		if (cursos == null || cursos.isEmpty()) {
	%>
	Cursos não cadastrados
	<%
		} else {
	%>
	<table class="highlight">
		<tr>
			<th>Nome
			<th /><th>Descricao
			
			<th />
			<th>Acoes
			<th />
		</tr>
		<%
			for (Curso curso : cursos) {
		%>
		<tr>
			<td><%=curso.getNome()%>
			<td />
			<td><%=curso.getDescricao()%>
			<td />
			<td><a href='deletecurso?id=<%=curso.getId()%>'>excluir</a> <a
				href='editCurso.jsp?id=<%=curso.getId()%>'>editar</a>
			<td />
		</tr>
		<%
			}

			}
		%>
	</table>
</body>
</html>
