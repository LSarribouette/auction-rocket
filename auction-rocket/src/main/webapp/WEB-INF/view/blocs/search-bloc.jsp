<div>
	<fieldset>
	<legend>SEARCH BLOC</legend>
	<form action="" method="POST">
	
		Filtres : 
		<input type="text" value="le nom de l'article contient">
		<br>
		cat�gorie : 
		<select><option>Toutes</option></select>
		<hr>
		
		<input type="radio" value="buying" id="buying" name="radio-action">
		<label for="buying">ACHAT</label> <br>
		
		<input type="checkbox" id="open-auctions" name="open-auctions">
		<label for="open-auctions">ench�res ouvertes</label> <br>
		
		<input type="checkbox" id="ongoing-auctions" name="ongoing-auctions">
		<label for="ongoing-auctions">mes ench�res en cours</label><br>
		
		<input type="checkbox" id="won-auctions" name="won-auctions">
		<label for="won-auctions">mes ench�res remport�es</label>
		<hr>
		
		<input type="radio" value="sales" id="sales" name="radio-action">
		<label for="sales">Mes VENTES</label> <br>
		
		<input type="checkbox"
			<%if(request.getAttribute("target")!=null && request.getAttribute("target").toString().equals("mysales")){%>
				checked
			<%} %>
			 id="ongoing-sales" name="ongoing-sales"> 
		<label for="ongoing-sales">mes ventes en cours</label><br>
		
		<input type="checkbox" id="upcoming-sales" name="upcoming-sales"> 
		<label for="upcoming-sales">ventes non d�but�es</label><br>
		
		<input type="checkbox" id="ended-sales" name="ended-sales">	
		<label for="ended-sales">ventes termin�es</label><br>
		
		<hr>
		
		<input type="submit" value="RECHERCHER"> 
	</form>
	
	</fieldset>
	
</div>
