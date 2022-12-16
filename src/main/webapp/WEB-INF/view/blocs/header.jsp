
<fieldset> 
<legend>HEADER MENU</legend>

<button onClick="window.location.reload();">Refresh Page</button>

<!-- TODO ARRETEZ LES CONNERIES avec les getParameter   -->
<!-- TODO se demerder pour recup la session ici pour TOUJOURS afficher image mais changer son href -->

	<%session=request.getSession(false); %>
	<a href="
	<%if (session == null) {%>
	<%=request.getContextPath() %>
	<%} else { %>
	<%=request.getContextPath() %>/auction/home">
	<%} %>
		<img src="../media/logo-team-rocket-2.png" alt="Pokemon Team Rocket Logo">
	</a>

	<a href="">Enchères</a>
	
	<a href="<%=request.getContextPath()%>/auction/article/sell">Vendre un article</a>
	
	<a href="<%=request.getContextPath()%>/user/myprofile">Mon profil</a>
	
	<a href="<%=request.getContextPath()%>/connection/logout">Déconnexion</a>


</fieldset>