<fieldset>
	<legend>DISPLAY SEARCH RESULT</legend>
	<h4>
		RECUP LISTE ARTICLE WITH FILTERS<br>
		-> fetch, select by, select where 
	</h4>
	<%if(request.getAttribute("target")!=null && request.getAttribute("target").toString().equals("mysales")){%>
	<h2>FILTER -> MY SALES !!!</h2>
	<%} %>
	
</fieldset>