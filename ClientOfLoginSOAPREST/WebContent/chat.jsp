<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="clients.MessagesSoapClient" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="service.ws.Message"%>
<%@ page import="service.ws.User"%>
<%@ page import="utility.BooleanUtil"%>
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH.mm.ss"); %>
<% String friend = (String) request.getAttribute("friend"); %>
<% boolean isReplying = (boolean) session.getAttribute("isReplying"); %>
<% Message messageReplied = (Message) request.getAttribute("message"); %>
<% List<User> userList = (List<User>) session.getAttribute("userList"); %>
<% List<Message> messageList = (List<Message>) request.getAttribute("messageList"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chat</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<%for (User u: userList) {
					if (!u.getNome().equals(session.getAttribute("user"))) {%>
						<p>
							<form method="Get" action="getChat">
								<input type="hidden" name="friend" value="<%= u.getNome() %>" /> 
								<input type="submit" value="<%= u.getNome() %>" />
							</form>
						</p>
					<%}
				}%>
				<form method="Post" action="logout">
					<input type="submit" value="logout" />
				</form>
			</td>
			<td>
				<% if (messageList != null && !messageList.isEmpty()) {
					for (Message m: messageList) {
						if (!m.isEliminato()) {%>
						<form method="Post"
							action="<%if (m.getMittente().equals(session.getAttribute("user"))) {%>deleteMessage<%} else {%>replyToMessage<%}%>">
							<%if (m.getRisposta() != 0) {%><p>(risposta a <%=MessagesSoapClient.getMessage(m.getRisposta()).getMittente() %>: <%=MessagesSoapClient.getMessage(m.getRisposta()).getTesto() %>)</p>
							<%} %>
							<p>
								[<%= sdf.format(m.getData().toGregorianCalendar().getTime())%>]
								<%= m.getMittente() %>:
								<%= m.getTesto() %>
								<input type="hidden" name="friend" value="<%= friend %>" /> <input
									type="hidden" name="id" value="<%= m.getId() %>" /> <input
									type="submit"
									value="<%if (m.getMittente().equals(session.getAttribute("user"))) {%>elimina<%} else {%>rispondi<%}%>" />
							</p>
						</form> <%}
						}
					} else {%>
						<p>Non sono presenti messaggi</p> 
					<%} 
				if (friend != null){ 
					if (BooleanUtil.isTrue(isReplying)) {%>
						<p>
							risposta a
							<%= messageReplied.getMittente()%>:
							<%= messageReplied.getTesto() %>
						<p>
					<%} %>
				
					<form method="Post" action="postMessage">
						<input type="hidden" name="destinatario" value="<%= friend %>" /> 
						<input type="text" name="testo" />
						<% if (BooleanUtil.isTrue(isReplying)) {%>
							<input type="hidden" name="id" value="<%= messageReplied.getId()%>" />
						<%} %>
						<input type="submit" value="Invia" />
					</form> 
				<%} %>
			</td>
		</tr>
	</table>
</body>
</html>