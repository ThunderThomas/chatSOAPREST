<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<%@ page import = "models.User" %>
<% User utente= (User) request.getAttribute("user"); %>
<% List<User> userList = (List<User>) request.getAttribute("userList"); %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Pagina di gestione utenti</title>
</head>
<body>
	<p>Crea un nuovo utente</p>
	<form method="Post" action="postUser">
		<table>
			<tr>
				<td>Inserisci il nome</td>
				<td>
					<input type="text" name="nome"/>
				</td>
			</tr>
			<tr>
				<td>Inserisci la password</td>
				<td>
					<input type="text" name="password"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="admin" value="true"/> Admin
				</td>
			</tr>
		</table>
		<input type="submit" value ="crea l'utente"/>
	</form>
	<br>
	<br>
	<form method="Get" action="getUser">
		<table>
			<tr>
				<td>Inserisci il nome dell'utente</td>
				<td>
					<input type="text" name="nome"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="visualizza l'utente"/>
	</form>
	<br>
	<br>
	<% if (utente != null) {%>
		<table>
			<tr>
				<th>Nome</th>
				<th>Password</th>
				<th>È un admin?</th>
			</tr>
			<tr>
				<td><%=utente.getNome() %></td> 
				<td><%=utente.getPassword() %>
				<td><% if (utente.isAdmin()) {%> 
						SI 
					<%} else {%> 
						NO
					<%} %>
				</td>
			</tr>
		</table>
	<%} %>
	<br>
	<br>
	<form method="Get" action="getAll">
		<input type="submit" value="visualizza la lista utenti"/>
	</form>
	<% if (userList != null && !userList.isEmpty()) {%>
		<table>
			<tr>
				<th>Nome</th>
				<th>Password</th>
				<th>È un admin?</th>
			</tr>
			<%for (User user : userList) {%>
			<tr>
				<form method="Get" action="putUser">
					<td><input type="hidden" name="nome" value="<%= user.getNome() %>"/> <%= user.getNome() %></td>
					<td><input type="text" name="password" value="<%= user.getPassword() %>"/></td>
					<td><input type="checkbox" name="admin" value="true"<% if (user.isAdmin()) {%> 
						 checked 
						<%} %>
						/>
					</td>
					<td>
						
							<input type="submit" value="modifica"/>
						
					</td>
				</form>
				<td>
					<form method="Get" action="deleteConfirm">
						<input type="hidden" name="nomeVero" value="<%= user.getNome() %>"/>
						<input type="submit" value="elimina"/>
					</form>
				</td>
			</tr>
			<%} %>
		</table>
	<%} else {%>
	<p>Non sono presenti utenti</p>
	<%} %>
</body>
</html>