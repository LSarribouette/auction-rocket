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

<% Utilisateur utilisateur = (Utilisateur) session.getAttribute("current_user"); %> 

<h1>PROFILE</h1>

<fieldset>
<legend><%= utilisateur.getPseudo() %> POFILE</legend>

<h4><%=utilisateur.getPseudo() %></h4> 
<h4><%=utilisateur.getNom() %></h4> 
<h4><%=utilisateur.getPrenom() %></h4> 
<h4><%=utilisateur.getEmail() %></h4> 
<h4><%=utilisateur.getTelephone() %></h4> 
<h4><%=utilisateur.getRue() %></h4> 
<h4><%=utilisateur.getCodePostal() %></h4> 
<h4><%=utilisateur.getVille() %></h4> 
<hr>
<h4>your credits : <%=utilisateur.getCredit() %></h4> 

<form action="<%=request.getContextPath()%>/user/editprofile">
	<button type="submit">modifier le pofil</button>
</form>
<form action="<%=request.getContextPath()%>/user/deleteprofile">
         <button type="submit">supprimer le profil</button>
</form>

</fieldset>

</body>
</html>