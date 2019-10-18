<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "utility.BooleanUtil" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Benvenuto</title>
</head>
<body>
	<p>Effettua il login qui</p>
	<form method="Post" action="checkLogin">
		<table>
			<tr>
				<td>Inserisci lo username</td>
				<td>
					<input type="text" name="username"/>
				</td>
			</tr>
			<tr>
				<td>Inserisci la password</td>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
		</table>
		<input type="submit" value ="Entra"/>
	</form>
	<% if (BooleanUtil.isTrue((Boolean) session.getAttribute("noUserOrPassword"))) {%>
		<p>inserire uno username e una password</p>
	<%} %>
	<% if (BooleanUtil.isTrue((Boolean) session.getAttribute("wrongUserOrPassword"))) {%>
		<p>username o password non corretti</p>
	<%} %>
</body>
</html>