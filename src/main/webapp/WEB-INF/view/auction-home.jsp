<%@page import="fr.teamrocket.auctionrocket.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auction Rocket</title>
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