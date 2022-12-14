<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCTION ROCKET - sell an article</title>
</head>
<body>
	
	<h1>article sell form</h1>
	<!-- TODO : FOUTRE DES REQUIRED -->
	<fieldset>ARTICLE SELL FORM
	<form action="<%=request.getContextPath()%>/user/mysales" method="post" >
		<label for="name">Article: </label>
	   	<input type="text" name="name" id="name" >
	   	<br>    
	   	<label for="description">Description: </label>
	   	<textarea rows="5" cols="10">description</textarea>
	   	<br>
	   	<label for="category">Categorie</label>
	   	<select name="category" id="category">
	   		<option>tout</option>
	   		<option>électronique</option>
	   		<option>matériel de torture</option>
	   	</select>
	   	<br>
	   	<label for="photo-article">photo de l'article: </label>
	   	<input type="file" name="photo-article" id="photo-article" accept="image/png, image/jpeg">
	   	<br>
	   	<label for="prix">Mise à prix:</label>	
		<input type="number" id="prix" name="prix" min="0">
	   	<br>
	   	<label for="date-start">Start date:</label>
		<input type="date" id="date-start" name="date-start"
	      value="2022-01-30"
	      min="" max="">
		<br>
		<label for="date-end">End date:</label>
		<input type="date" id="date-end" name="date-end"
	      value="2022-01-30"
	      min="" max="">
	   	<br>
	   	<fieldset>Retrait
	   	<label for="street">Rue: </label>
	   	<input type="text" name="street" id="street"> <br>   
	   	<label for="postalcode">Code Postal: </label>
	   	<input type="text" name="postalcode" id="postalcode"> <br>  
	   	<label for="city">Ville: </label>
	   	<input type="text" name="city" id="city">
	   	</fieldset>
	   	<input type="submit" value="Submit - if form ok">
		<button>
			<a href="<%=request.getContextPath()%>/auction/home">CANCEL</a>
		</button>
	</form>

	</fieldset>
</body>
</html>