<!DOCTYPE html>
<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8"/>
<title>Primeira aplicação web</title>
</head>
<body>
<div>
<form action="teste2" method="post">
		<label>Name </label><input type="text" name="nome" value=""/>	
		<input type="submit" id="botao" value="Save"/>
</form>

<%
	List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");

	for(Cliente c : lista) {
		out.print(c.getNome() + "<br>"); 
	}
%>

</div>
</body>
</html>