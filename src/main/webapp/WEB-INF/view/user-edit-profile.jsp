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

<h1>PROFILE EDIT</h1>

<fieldset>
<legend>EDITING <%= utilisateur.getPseudo() %> POFILE</legend>

<form action="<%=request.getContextPath() %>/user/myprofile" method="post">
	
		<label for="pseudo">Pseudo</label>
		<input type="text" name="pseudo" id="pseudo" required value="<%= utilisateur.getPseudo() %>">
		<br><br>	
		<label for="nom">Nom</label>
		<input type="text" name="nom" id="nom" value="<%= utilisateur.getNom()%>">
		<br><br>	
		<label for="prenom">Prénom</label>
		<input type="text" name="prenom" id="prenom" value="<%= utilisateur.getPrenom()%>">
		<br><br>	
		<label for="email">Email</label>
		<input type="text" name="email" id="email" value="<%= utilisateur.getEmail()%>">
		<br><br>
		<label for="telephone">Télephone</label>
		<input type="text" name="telephone" id="telephone" value="<%= utilisateur.getTelephone()%>">
		<br><br>	
		<label for="rue">Rue</label>
		<input type="text" name="rue" id="rue" value="<%= utilisateur.getRue()%>">
		<br><br>
		<label for="code-postal">Code postal</label>
		<input type="text" name="code-postal" id="code-postal" value="<%= utilisateur.getCodePostal()%>">
		<br><br>	
		<label for="ville">Ville</label>
		<input type="text" name="ville" id="ville" value="<%= utilisateur.getVille()%>">
		<br><br>	
		<!--TODO: MDP A GERER ! pas en clair, faire confirmer lors de la modif, etc..  -->
		<label for="mot-de-passe">mot de passe</label>
		<input type="password" name="mot-de-passe" id="mot-de-passe" value="<%= utilisateur.getMdp()%>">
		<br><br>	
		<input type="submit" value="SUBMIT"> 
	</form>
	<form action="<%=request.getContextPath()%>/user/showprofile">
         <button type="submit">CANCEL</button>
	</form>
	
<!-- TODO ask for pwd and confirm changes, as well if user wants to change pwd  -->

</fieldset>

</body>
</html>