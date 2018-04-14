<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<html>
<head>
<meta charset="UTF-8"/>
<title>Primeira aplicação web</title>
<script type="text/javascript">
	function excluir(i) {
		if(window.confirm("Você quer mesmo excluir o nome de índice " + i)) {
			location.href = "teste2?i=" + i + "&a=exc";
		}
	}
</script>
</head>
<body>
<div>
<div>
<% 
	Object msg = request.getAttribute("msg"); 
	if (msg != null) {
		String msgstr = (String)msg;
		out.print(msg);
	}
	
	Cliente cli = (Cliente)request.getAttribute("cli");
	
	Object iCli = request.getAttribute("iCli");
	
%>
</div>
<form action="teste2" method="post">
		<input type="hidden" name="i" value="<%=iCli%>"/>
		<label>Name </label><input type="text" name="nome" value="<%=cli.getNome()%>"/>	
		<input type="submit" id="botao" value="Save"/>
</form>

<%
	List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
	int i = 0;
	for(Cliente c : lista) {
%>
		<%=c.getNome()%>
		<a href="javascript:excluir(<%=i%>)">Excluir</a>
		<a href="teste2?i=<%=i%>&a=edit">Editar</a><br> 
<%
		i++;
	}
%>

</div>
</body>
</html>