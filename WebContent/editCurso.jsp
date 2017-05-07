<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="br.unipe.javaweb.controleacademico.model.*, br.unipe.javaweb.controleacademico.services.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro/Edição de curso</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
</head>
<body>

	<%
	Curso curso = null;
	if (request.getParameter("id") != null)
		curso = CursoService.buscarCurso(Long.parseLong(request.getParameter("id")));
	%>

	<form action='<%=curso != null ? "updatecurso" : "createcurso"%>'
		method='post'>
		<input type="hidden" name="id" value="<%=curso != null ? curso.getId() : ""%>" />
		Nome: <input type='text' name='nome' value="<%=curso != null ? curso.getNome() : ""%>" />
		Descricao: <input type='text' name='descricao' value="<%=curso != null ? curso.getDescricao() : ""%>" />
		Tipo: <input type='text' name='tipo' value="<%=curso != null ? curso.getTipo() : ""%>" />
		<input class="btn waves-effect waves-light" type='submit' value='salvar' />
	</form>
</body>
</html>