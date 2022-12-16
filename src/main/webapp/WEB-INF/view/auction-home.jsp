<%@page import="fr.teamrocket.auctionrocket.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCTION ROCKET - HOME connected</title>
</head>
<body>

<jsp:include page="/WEB-INF/view/blocs/header.jsp"/>

<h1>
	Accueil -- Bienvenu.e, YOU = 
	<% Utilisateur utilisateur = (Utilisateur) session.getAttribute("current_user"); %> 
	<%= utilisateur.getPseudo() %>
	!
</h1>

<jsp:include page="/WEB-INF/view/blocs/search.jsp"/>

<jsp:include page="/WEB-INF/view/blocs/display-result.jsp"/>

</body>
</html>