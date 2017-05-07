<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="br.unipe.javaweb.controleacademico.model.*, br.unipe.javaweb.controleacademico.services.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro/Edição de professores</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
</head>

<body>

	<%
	Professor professor = null;
	if (request.getParameter("id") != null)
		professor = ProfessorService.buscarProfessor(Long.parseLong(request.getParameter("id")));
	%>

	<form action='<%=professor != null ? "updateprofessor" : "createprofessor"%>' method='post'>
			<input type="hidden" name="id"
				value="<%=professor != null ? professor.getId() : ""%>" /> Nome: <input
				type='text' name='nome'
				value="<%=professor != null ? professor.getNome() : ""%>" /> Area
			de Atuação: <input type='text' name='areaatuacao'
				value="<%=professor != null ? professor.getAreaAtuacao() : ""%>" />
			CPF: <input type='text' name='cpf'
				value="<%=professor != null ? professor.getCpf() : ""%>" />
			Titulacao: <input type='text' name='titulacao'
				value="<%=professor != null ? professor.getTitulacao() : ""%>" />
			E-mail: <input type='text' name='email'
				value="<%=professor != null ? professor.getEmail() : ""%>" />	
				 <input
				class="btn waves-effect waves-light" type='submit' value='salvar' />

		</form>
</body>

</html>