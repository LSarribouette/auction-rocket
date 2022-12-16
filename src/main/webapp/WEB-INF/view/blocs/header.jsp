
<fieldset> 
<legend>HEADER MENU</legend>

<button onClick="window.location.reload();">Rafraîchir</button><br>
<button onClick="history.go(-1)">Retour</button><br>

	<a 
		<%if (session.getAttribute("current_user") != null) {%>
			href="<%=request.getContextPath() %>/auction/home">
		<%} else if (session.getAttribute("current_user") == null){ %>
			href="<%=request.getContextPath() %>/home">
		<%} %>
		<img src="<%=request.getContextPath() %>/media/logo-team-rocket-2.png" alt="LOGO Pokemon Team Rocket"> 
	</a><br>

	<%if (session.getAttribute("current_user") != null) {%>
		<a href="">Enchères</a><br>
		<a href="<%=request.getContextPath()%>/auction/article/sell">Vendre un article</a><br>
		<a href="<%=request.getContextPath()%>/user/myprofile">Mon profil</a><br>
		<a href="<%=request.getContextPath()%>/connection/logout">Déconnexion</a><br>
	<%} %> 
