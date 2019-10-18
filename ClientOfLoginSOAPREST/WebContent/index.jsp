<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<%@ page import = "service.ws.User" %>
<%@ page import = "utility.BooleanUtil" %>
<%
	User utente= (User) request.getAttribute("user");
%>
<%
	List<User> userList = (List<User>) request.getAttribute("list");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione utenti SOAP</title>
</head>
<body>
	<% if (BooleanUtil.isTrue((Boolean) session.getAttribute("isAdmin"))) {%>
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
	<%} %>
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
					<% if (BooleanUtil.isTrue((Boolean) session.getAttribute("isAdmin"))) {%>
						<td>
								<input type="submit" value="modifica"/>
						</td>
					<%} %>
				</form>
				<% if (BooleanUtil.isTrue((Boolean) session.getAttribute("isAdmin"))) {%>
					<td>
						<form method="Get" action="deleteConfirm">
							<input type="hidden" name="nomeVero" value="<%= user.getNome() %>"/>
							<input type="submit" value="elimina"/>
						</form>
					</td>
				<%} %>
			</tr>
			<%} %>
		</table>
	<%} else {%>
	<p>Non sono presenti utenti</p>
	<%} %>
	
	<form method="Post" action="logout">
		<input type="submit" value="logout"/>
	</form>
</body>
</html>