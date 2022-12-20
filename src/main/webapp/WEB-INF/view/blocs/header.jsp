
<fieldset> 
<legend>HEADER MENU</legend>

<button onClick="window.location.reload();">Rafraîchir</button><br>
<button onClick="history.go(-1)">Retour</button><br>

	<a href="<%=request.getContextPath() %>/home">
		<img height="100px" width="100px" src="<%=request.getContextPath() %>/media/logo-team-rocket-2.png" alt="LOGO Pokemon Team Rocket"> 
	</a><br>

	<%if (session.getAttribute("current_user") != null) {%>
		<a href="">Enchères</a><br>
		<a href="<%=request.getContextPath()%>/sale/create">Vendre un article</a><br>
		<a href="<%=request.getContextPath()%>/user/showprofile">Mon profil</a><br>
		<a href="<%=request.getContextPath()%>/connection/logout">Déconnexion</a><br>
	<%} %> 
