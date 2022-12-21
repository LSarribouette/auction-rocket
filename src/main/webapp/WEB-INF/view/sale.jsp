<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auction Rocket</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/blocs/header.jsp"/>
    <h1>Fiche de l'article à mettre en vente</h1>
    <!-- TODO : FOUTRE DES REQUIRED -->
    <fieldset>ARTICLE SELL FORM
    <form action="<%=request.getContextPath()%>/sale/create" method="post" >
		<label for="nom-article">Article: </label>
	   	<input type="text" name="nom-article" id="nom-article" >
	   	<br>    
	   	<label for="description">Description: </label>
	   	<textarea rows="5" cols="15" id="description" name="description">description</textarea>
	   	<br>
	   	<label for="category">Categorie</label>
	   	<select name="category" id="category">
	   		<option value="Art">Art</option>
	   		<option value="Musique">Musique</option>
	   		<option value="Littérature">Littérature</option>
	   		<option value="Jeux">Jeux</option>
	   		<option value="Electroménager">Electroménager</option>
	   		<option value="Véhicules">Véhicules</option>
	   		<option value="Vêtements">Vêtements</option>
	   		<option value="Chaussures">Chaussures</option>
	   		<option value="Bijoux">Bijoux</option>
	   	</select>
	   	<br>
	   	<label for="photo-article">photo de l'article: </label>
	   	<input type="file" name="photo-article" id="photo-article" accept="image/png, image/jpeg">
	   	<br>
	   	<label for="prix-initial">Mise à prix:</label>	
		<input type="number" id="prix-initial" name="prix-initial" min="0">
	   	<br>
	   	
	   	<label for="date-start">Start date:</label>
		<input type="datetime-local" id="date-start" name="date-start"
	      value="2022-01-30T12:00"
	      min="" max="">
		<br>
		<label for="date-end">End date:</label>
		<input type="datetime-local" id="date-end" name="date-end"
	      value="2022-01-30T12:00"
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
	   	<input type="submit" value="SUBMIT">
		<button>
			<a href="<%=request.getContextPath()%>/home">CANCEL</a>
		</button>
	</form>
    </fieldset>
    <script>
    /* PETIT BOUT DE SCRIPT pour set la date now dans le form par défaut :)  */
        window.addEventListener('load', () => {
            let nowDate = new Date();
            nowDate.setMinutes(nowDate.getMinutes());
            /* remove second/millisecond if needed - credit ref. 
            https://stackoverflow.com/questions/24468518/html5-input-datetime-local-default-value-of-today-and-current-time#comment112871765_60884408 */
            nowDate.setMilliseconds(null)
            nowDate.setSeconds(null)
            document.querySelector('#date-start').value = nowDate.toISOString().slice(0, -1);
            /* TODO :  DATE END à +7j */
            document.querySelector('#date-end').value = nowDate.toISOString().slice(0, -1);
        });
    </script>
</body>
</html>