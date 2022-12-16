<div>
	<fieldset>
	<legend>SEARCH BLOC</legend>
		
	<form action="<%=request.getContextPath() %>/search" method="POST">
	
		Filtres : 
		<input type="text" value="le nom de l'article contient">
		<br>
		catégorie : 
		<select><option>Toutes</option></select>
		<hr>

	<%if (session.getAttribute("current_user") != null) {%>		

		<!-- TODO autorisé uniquement le cochage des cases correspondant au radio bouton sélectionné ??-->	
		
		<input type="radio" value="buying" id="buying" name="radio-action" 
			<%if(request.getAttribute("buying")!=null && request.getAttribute("buying").equals("koshed")){%>
			checked
			<%}%>
			>
		<label for="buying">ACHAT</label> <br>
		
		<input type="checkbox" id="all-ongoing-auctions" name="all-ongoing-auctions"
			<%if(request.getAttribute("all-ongoing-auctions")!=null && request.getAttribute("all-ongoing-auctions").equals("koshed")){%>
			checked
			<%}%>
			>
		<label for="all-ongoing-auctions">enchères ouvertes</label> <br>
		
		<input type="checkbox" id="ongoing-user-auctions" name="ongoing-user-auctions" 
			<%if(request.getAttribute("ongoing-user-auctions")!=null && request.getAttribute("ongoing-user-auctions").equals("koshed")){%>
			checked
			<%}%>
			>
		<label for="ongoing-user-auctions">mes enchères en cours</label><br>
		
		<input type="checkbox" id="won-user-auctions" name="won-user-auctions"
			<%if(request.getAttribute("won-user-auctions")!=null && request.getAttribute("won-user-auctions").equals("koshed")){%>
			checked
			<%}%>
			>
		<label for="won-user-auctions">mes enchères remportées</label>
		<hr>
		
		<input type="radio" value="sales" id="sales" name="radio-action"
			<%if(request.getAttribute("sales")!=null && request.getAttribute("sales").equals("koshed")){%>
			checked
			<%}%>
			>
		<label for="sales">Mes VENTES</label> <br>
		
		<input type="checkbox" id="ongoing-user-sales" name="ongoing-user-sales"
			<%if(request.getAttribute("ongoing-user-sales")!=null && request.getAttribute("ongoing-user-sales").equals("koshed")){%>
			checked
			<%}%>
			> 
		<label for="ongoing-user-sales">mes ventes en cours</label><br>
		
		<input type="checkbox" id="unstarted-user-sales" name="unstarted-user-sales"
			<%if(request.getAttribute("unstarted-user-sales")!=null && request.getAttribute("unstarted-user-sales").equals("koshed")){%>
			checked
			<%}%>
			> 
		<label for="unstarted-user-sales">ventes non débutées</label><br>
		
		<input type="checkbox" id="ended-user-sales" name="ended-user-sales"
			<%if(request.getAttribute("ended-user-sales")!=null && request.getAttribute("ended-user-sales").equals("koshed")){%>
			checked
			<%}%>
			>	
		<label for="ended-user-sales">ventes terminées</label><br>
	<%} %>
		
		<input type="submit" value="RECHERCHER"> 
	
	</form>
	
	</fieldset>
	
</div>
