<%@ page import="br.com.bank.model.Client" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div align="center">
		<h2>Login Usuário</h2>
		<br/>
		<form action="clientServlet" method="POST">
			<label for="name">Name</label>
			<input id="name" name="name" type="text" placeholder="your name" >
			<br/>
			<br/>
			<label for="email">E-mail</label>
			<input id="email" name="email" type="email" placeholder="your email" >
			<br/>
			<br/>
			<label for="phone">Phone</label>
			<input id="phone" name="phone" type="text" placeholder="your phone" >
			<br/>
			<br/>
			<input type="submit" value="Add" id="btn-Login">
		</form>
	</div>
	
	<table>
		<thead>	
				<tr>
					<th>Id:</th>
                    <th>Name:</th>
                    <th>Email:</th>
                    <th>Phone:</th>
				</tr>
		</thead>
		<tbody id="corpo-tabela">
			<%
				Object parametro = request.getAttribute("client");
				if(parametro != null)
				{
					ArrayList<Client> clients  = (ArrayList<Client>)parametro;
					for(Client client : clients){	
			%>
			
			<tr>
				<td id="id" name="id" class="id"><%=client.getId()%></td>
				<td><%=client.getName()%></td>
				<td><%=client.getEmail()%></td>
				<td><%=client.getPhone()%></td>	
				<td><button type="button" value="Excluir"  id="bt-excluir" onclick="excluir(<%=client.getId()%>)">Excluir</button></form></td>	
			</tr>
		
		<%
					}
				}
		%>
		</tbody>
	</table>
	
	<script>
	
	reloadList();
	
	function reloadList() {
		var url = '${pageContext.request.contextPath}/clientServlet';
		
        $.get(url,{
        }).done(function (){
        }).fail(function () {
			alert("Falha ao carregar");
		});
    }
	
	function excluir(id){	
		var url = '${pageContext.request.contextPath}/clientDeleteServlet';
		
		$.post(url,{
			id: id,
		}).done(function (){
			alert("Excluido com sucesso!");
		}).fail(function () {
			alert("Falha ao excluir!");
		});
		reloadList();
	}
	
	
	
	</script>
</body>
</html>