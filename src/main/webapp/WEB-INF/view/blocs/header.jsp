
<fieldset> 
<legend>HEADER MENU</legend>

<button onClick="window.location.reload();">Refresh Page</button><br>

<!-- TODO ARRETEZ LES CONNERIES avec les getParameter   -->
<!-- TODO se demerder pour recup la session ici pour TOUJOURS afficher image mais changer son href -->


<%-- 	<%session=request.getSession(false); %> --%>
<!-- 	<a  -->
<%-- 	<%if (session != null) {%> --%>
<%-- 	href="<%=request.getContextPath() %>/auction/home"> --%>
<%-- 	<%} else if (session == null){ %> --%>
<%-- 	href="<%=request.getContextPath() %>/home"> --%>
<%-- 	<%} %> --%>
<!-- 		<img src="../media/logo-team-rocket-2.png" alt="LOGO Pokemon Team Rocket">  -->
<!-- 	</a><br> -->

<%-- 	<a href="<%=request.getContextPath() %>"><img src="../media/logo-team-rocket-2.png" alt="LOGO Pokemon Team Rocket"></a><br> --%>
	
	
	
	<a href="">Enchères</a><br>
	
	<a href="<%=request.getContextPath()%>/auction/article/sell">Vendre un article</a><br>
	
	<a href="<%=request.getContextPath()%>/user/myprofile">Mon profil</a><br>
	
	<%if (session.getAttribute("current_user") != null) {%>
		<h1><%=session.getAttribute("current_user") %></h1>
		<a href="<%=request.getContextPath()%>/connection/logout">Déconnexion</a><br>
	<%} %> 
	
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- 	<c:choose> --%>
<%-- 	    <c:when test="${pageContext.request.session != null}"> --%>
<!-- 	        Not Null -->
<%-- 	    </c:when> --%>
<%-- 	    <c:otherwise> --%>
<!-- 	        Null -->
<%-- 	    </c:otherwise> --%>
<%-- 	</c:choose> --%>
		

</fieldset>