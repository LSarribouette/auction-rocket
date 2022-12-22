<%@page import="fr.teamrocket.auctionrocket.bo.Utilisateur"%>
<%@page import="fr.teamrocket.auctionrocket.bo.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auction Rocket</title>
</head>
<body>

<% Article article = (Article) request.getAttribute("article"); %>
<% Utilisateur seller = (Utilisateur) request.getAttribute("seller"); %>
<jsp:include page="/WEB-INF/view/blocs/header.jsp"/>

<h1>Fiche article détaillé</h1>
<hr>
<ul>
	<h3><%=article.getDescription()%></h3>
	<hr>
	<li>début des enchères : <%=article.getDateDebutEnchere()%></li>
	<hr>
	<li>fin des enchères : <%=article.getDateFinEnchere()%></li>
	<hr>
	<li>prix de départ : <%=article.getPrixInitial()%> ₩ </li>
	<hr>
	<li>vendu pour : <%=article.getPrixVente()%> ₩ </li>
	<hr>
	<li>vendu par : <%=article.getUtilisateur().getNoUtilisateur()%></li>
	<%-- <li>vendu par : <%=seller.getNom()%></li> --%>
	<hr>
	<li>catégorie : <%=article.getCategorie().getNoCategorie()%></li>
	<hr>
	<li>état de la ventes : <%=article.getEtatVente()%></li>
</ul>


</body>
</html>