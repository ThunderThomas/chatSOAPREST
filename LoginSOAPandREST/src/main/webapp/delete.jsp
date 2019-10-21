<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma cancellazione</title>
</head>
<body>
<p>Per confermare l'eliminazione dell'utente, riscrivi qui il suo nome</p>
<form method="Post" action="deleteUser">
	<input type="text" name="nome"/><br>
	<input type="hidden" name="nomeVero" value="<%= request.getParameter("nomeVero") %>"/>
	<input type="submit" value="conferma"/>
</form> 
</body>
</html>