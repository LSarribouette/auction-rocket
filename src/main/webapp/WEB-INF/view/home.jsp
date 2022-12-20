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

<button>
	<a href="<%=request.getContextPath()%>/connection/login">Se connecter | S'inscrire</a>
</button>

<h1>Accueil</h1>

<%if (session.getAttribute("current_user") != null) {%>	
	<h2>Bienvenu.e, YOU = 
		<% Utilisateur utilisateur = (Utilisateur) session.getAttribute("current_user"); %> 
		<%= utilisateur.getPseudo() %>
		!</h2>
<%} %>


<jsp:include page="/WEB-INF/view/blocs/search.jsp"/>

<jsp:include page="/WEB-INF/view/blocs/display-result.jsp"/>

</body>
</html>