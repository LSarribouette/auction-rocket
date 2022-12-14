<%@page import="fr.teamrocket.auctionrocket.bo.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCTION ROCKET - Homepage</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/blocs/header.jsp">
		<jsp:param value="false" name="isConnected"/>
		<jsp:param value="home.jsp" name="from"/>
</jsp:include>
	
<h1>THIS IS HOME.JSP</h1>

<button>
	<a href="<%=request.getContextPath()%>/ServletConnection">Log in / Sign up</a>
</button>


<table align="center">
		<thead>
			<tr>
				<td>noAtricle</td>
				<td>Descirption</td>
			</tr>
		</thead>
		
		<%
			List<Article> articles = (List<Article>)request.getAttribute("articles");
			if(articles == null || articles.isEmpty()) {
		%>
			<p>Il n'y a pas de Article</p>
		<%
			} else {
		%>
		<tbody>
			<%
				for(Article a : articles) {
			%>
			<tr>
				<td><%=a.getNoArticle() %></td>
				<td><%=a.getDescription() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
		<%
			}
		%>
	</table>

</body>
</html>