<div>
	<fieldset>
	<legend>SEARCH BLOC</legend>
	
	
	
	<form action="<%=request.getContextPath() %>/ServletSearch" method="POST">
	
		Filtres : 
		<input type="text" value="le nom de l'article contient">
		<br>
		cat�gorie : 
		<select><option>Toutes</option></select>
		<hr>
		
		<input type="submit" value="RECHERCHER"> 
		</form>

	<%session=request.getSession(false); %>
	<%if (session != null) {%>		

		<!-- TODO autoris� uniquement le cochage des cases correspondant au radio bouton s�lectionn� ??-->
		<!-- renommer les boutons is OK ??? -->
	
		
		<input type="radio" value="buying" id="buying" name="radio-action">
		<label for="buying">ACHAT</label> <br>
		
		<input type="checkbox" id="all-ongoing-auctions" name="all-ongoing-auctions">
		<label for="all-ongoing-auctions">ench�res ouvertes</label> <br>
		
		<input type="checkbox" id="ongoing-user-auctions" name="ongoing-user-auctions">
		<label for="ongoing-user-auctions">mes ench�res en cours</label><br>
		
		<input type="checkbox" id="won-user-auctions" name="won-user-auctions">
		<label for="won-user-auctions">mes ench�res remport�es</label>
		<hr>
		
		<input type="radio" value="sales" id="sales" name="radio-action">
		<label for="sales">Mes VENTES</label> <br>
		
		<input type="checkbox" id="ongoing-user-sales" name="ongoing-user-sales"> 
		<label for="ongoing-user-sales">mes ventes en cours</label><br>
		
		<input type="checkbox" id="unstarted-user-sales" name="unstarted-user-sales"> 
		<label for="unstarted-user-sales">ventes non d�but�es</label><br>
		
		<input type="checkbox" id="ended-user-sales" name="ended-user-sales">	
		<label for="ended-user-sales">ventes termin�es</label><br>
		
		<input type="submit" value="RECHERCHER"> 
	</form>
	<%} %>
	
	</fieldset>
	
</div>
