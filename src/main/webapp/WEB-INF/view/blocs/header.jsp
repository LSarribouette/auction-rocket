
<fieldset> 
<legend>HEADER MENU</legend>

<h3>
*** HEADER TEST ***
</h3>
<p>UNE IMAGE DE MARQUE</p>

<% if(request.getParameter("isConnected").toString().equals("false")){ %>
<h3 style="color:red">l'utilisateur NEST PAS CONNECTE</h3>
<% } else if(request.getParameter("isConnected").toString().equals("true")){ %>
<h3 style="color:blue">l'utilisateur EST CONNECTE</h3> 

<a href="">Enchères</a>

<a href="<%=request.getContextPath()%>/auction/article/sell">Vendre un article</a>

<a href="<%=request.getContextPath()%>/user/myprofile">Mon profil</a>

<%if(!request.getParameter("from").toString().equals("home.jsp")){ %>
<a href="<%=request.getContextPath()%>/connection/logout">Déconnexion</a>
<%}%>

<%} %>




</fieldset>