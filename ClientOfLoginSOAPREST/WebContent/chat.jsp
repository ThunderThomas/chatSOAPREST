<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<%@ page import = "service.ws.User" %>
<%@ page import = "service.ws.Message" %>
<% User utente= (User) request.getAttribute("user"); %>
<% List<User> userList = (List<User>) request.getAttribute("userList"); %>
<% List<Message> messageList = (List<Message>) request.getAttribute("messageList");%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chat</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<%for (User u : userList) {
					if (!u.getNome().equals(session.getAttribute("user"))) {%>
						<form method="Get" action="getChat">
							<input type="hidden" name="friend" value="<%= u.getNome() %>"/>
							<input type="submit" value="<%= u.getNome() %>"/>
						</form>
					<%}
					}%>
			</td>
			<td>
				<% if (messageList != null && !messageList.isEmpty()) {%>
					<%for (Message m: messageList) {%>
						<table>
							<tr>
								<td>[<%= m.getData() %>] <%= m.getMittente() %>: <%=m.getTesto() %></td>
								<%if (m.getMittente().equals(session.getAttribute("user"))) {%>
									<td>
										<form method="Post" action="deleteMessage">
											<input type="hidden" name="id" value="<%= m.getId() %>"/>
											<input type="submit" value="elimina"/>
										</form>
									</td>
								<%} %>
							<tr>
						</table>
					<%} %>
				<%} else {%>
					<p>Non sono presenti messaggi</p>
				<%} %>
				<form method="Post" action="sendMessage">
					<input type="hidden" name="destinatario" value="<%= utente.getNome() %>"/>
					<input type="text" name="testo"/>
					<input type="submit" value="Invia"/>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>