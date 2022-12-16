
<fieldset> 
<legend>HEADER MENU</legend>

<button onClick="window.location.reload();">Refresh Page</button>

<% if(request.getParameter("isConnected").equals("false")){ %>
	<h3 style="color:red">l'utilisateur NEST PAS CONNECTE</h3>
	<a href="<%=request.getContextPath() %>">
		<img src="../media/logo-team-rocket-2.png" alt="Pokemon Team Rocket Logo qui retourne à HOME non connecté">
	</a>
	
<% } else if(request.getParameter("isConnected").toString().equals("true")){ %>
	<h3 style="color:blue">l'utilisateur EST CONNECTE</h3> 
	
	<a href="<%=request.getContextPath() %>/auction/home">
		<img src="../media/logo-team-rocket-2.png" alt="Pokemon Team Rocket Logo qui retourne à HOME connecté">
	</a>

	<a href="">Enchères</a>
	
	<a href="<%=request.getContextPath()%>/auction/article/sell">Vendre un article</a>
	
	<a href="<%=request.getContextPath()%>/user/myprofile">Mon profil</a>
	
	<%if(!request.getParameter("from").equals("home.jsp")){ %>
		<a href="<%=request.getContextPath()%>/connection/logout">Déconnexion</a>
	<%}%>

<%}%>

</fieldset>