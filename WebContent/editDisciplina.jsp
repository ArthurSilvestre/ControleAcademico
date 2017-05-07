<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="br.unipe.javaweb.controleacademico.model.*, br.unipe.javaweb.controleacademico.services.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro/Edição de disciplinas</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
</head>
<body>

	<%
	Disciplina disciplina = null;

	if (request.getParameter("id") != null)
		disciplina = DisciplinaService.buscarDisciplina(Long.parseLong(request.getParameter("id")));
	%>

	<form action='<%=disciplina != null ? "updatedisciplina" : "createdisciplina"%>' method='post'>
		<input type="hidden" name="id"
			value="<%=disciplina != null ? disciplina.getId() : ""%>" /> Nome:
		<input type='text' name='nome'
			value="<%=disciplina != null ? disciplina.getNome() : ""%>" /> Area:
		<input type='text' name='area'
			value="<%=disciplina != null ? disciplina.getArea() : ""%>" /> <input
			class="btn waves-effect waves-light" type='submit' value='salvar' />
	</form>
</body>
</html>