<div>
	<fieldset>
	<legend>SEARCH BLOC</legend>
	
	
	
	<form action="<%=request.getContextPath() %>/ServletSearch" method="POST">
	
		Filtres : 
		<input type="text" value="le nom de l'article contient">
		<br>
		catégorie : 
		<select><option>Toutes</option></select>
		<hr>
		
		<input type="submit" value="RECHERCHER"> 
		</form>

	<%session=request.getSession(false); %>
	<%if (session != null) {%>		

		<!-- TODO autorisé uniquement le cochage des cases correspondant au radio bouton sélectionné ??-->
		<!-- renommer les boutons is OK ??? -->
	
		
		<input type="radio" value="buying" id="buying" name="radio-action">
		<label for="buying">ACHAT</label> <br>
		
		<input type="checkbox" id="all-ongoing-auctions" name="all-ongoing-auctions">
		<label for="all-ongoing-auctions">enchères ouvertes</label> <br>
		
		<input type="checkbox" id="ongoing-user-auctions" name="ongoing-user-auctions">
		<label for="ongoing-user-auctions">mes enchères en cours</label><br>
		
		<input type="checkbox" id="won-user-auctions" name="won-user-auctions">
		<label for="won-user-auctions">mes enchères remportées</label>
		<hr>
		
		<input type="radio" value="sales" id="sales" name="radio-action">
		<label for="sales">Mes VENTES</label> <br>
		
		<input type="checkbox" id="ongoing-user-sales" name="ongoing-user-sales"> 
		<label for="ongoing-user-sales">mes ventes en cours</label><br>
		
		<input type="checkbox" id="unstarted-user-sales" name="unstarted-user-sales"> 
		<label for="unstarted-user-sales">ventes non débutées</label><br>
		
		<input type="checkbox" id="ended-user-sales" name="ended-user-sales">	
		<label for="ended-user-sales">ventes terminées</label><br>
		
		<input type="submit" value="RECHERCHER"> 
	</form>
	<%} %>
	
	</fieldset>
	
</div>
