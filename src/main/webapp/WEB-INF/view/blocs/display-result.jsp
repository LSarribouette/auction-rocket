<%@page import="fr.teamrocket.auctionrocket.bo.Article"%>
<%@page import="java.util.List"%>

<fieldset>
	<legend>DISPLAY SEARCH RESULT</legend>
	

<table align="center">
		<thead style="text-align: center; text-decoration: underline;">
			<tr>
				<td>no_article</td>
				<td>nom_article</td>
				<td>description</td>
				<td>date_debut_encheres</td>
				<td>date_fin_encheres</td>
				<td>prix_initial</td>
				<td>prix_vente</td>
				<td>no_utilisateur</td>
				<td>no_categorie</td>
				<td>etat_vente</td>
			</tr>
		</thead>
		
				
		<%
			List<Article> articles = (List<Article>)request.getAttribute("articles");
			if(articles == null || articles.isEmpty()) {
		%>
				<p>Il n'y a pas d"articles.</p>
		<%
			} else {
		%>
		<tbody>
			<%
				for(Article a : articles) {
			%>
			<tr style="text-align: center;">
				<td><%=a.getNoArticle() %></td>
				<td><%=a.getNomArticle() %></td>
				<td><%=a.getDescription() %></td>
				<td><%=a.getDateDebutEnchere() %></td>
				<td><%=a.getDateFinEnchere() %></td>
				<td><%=a.getPrixInitial() %></td>
				<td><%=a.getPrixVente() %></td>
				<td><%=a.getUtilisateur().getNoUtilisateur() %></td>
				<td><%=a.getCategorie().getNoCategorie() %></td>
				<td><%=a.getEtatVente() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
		<%
			}
		%>
	</table>
</fieldset>

</fieldset>