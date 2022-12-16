
<fieldset> 
<legend>HEADER MENU</legend>

<button onClick="window.location.reload();">Refresh Page</button><br>

	<a 
	<%if (session.getAttribute("current_user") != null) {%>
	href="<%=request.getContextPath() %>/auction/home">
	<%} else if (session.getAttribute("current_user") == null){ %>
	href="<%=request.getContextPath() %>/home">
	<%} %>
		<img src="<%=request.getContextPath() %>/media/logo-team-rocket-2.png" alt="LOGO Pokemon Team Rocket"> 
	</a><br>

	<a href="">Enchères</a><br>
	
	<a href="<%=request.getContextPath()%>/auction/article/sell">Vendre un article</a><br>
	
	<a href="<%=request.getContextPath()%>/user/myprofile">Mon profil</a><br>
	
	<%if (session.getAttribute("current_user") != null) {%>
		<h1><%=session.getAttribute("current_user") %></h1>
		<a href="<%=request.getContextPath()%>/connection/logout">Déconnexion</a><br>
	<%} %> 
