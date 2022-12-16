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

<h1>CONNECTION SIGNUP</h1>

FORM SIGN UP !

<div>
	<fieldset>
	<legend>REGISTRATION FORM</legend>
	<form action="<%=request.getContextPath() %>/register" method="POST" style="margin: auto;">
	
		<label for="pseudo">Pseudo</label>
		<input type="text" name="pseudo" id="pseudo" required>
		<br><br>	
		<label for="nom">Nom</label>
		<input type="text" name="nom" id="nom">
		<br><br>	
		<label for="prenom">Prénom</label>
		<input type="text" name="prenom" id="prenom">
		<br><br>	
		<label for="email">Email</label>
		<input type="text" name="email" id="email">
		<br><br>
		<label for="telephone">Télephone</label>
		<input type="text" name="telephone" id="telephone">
		<br><br>	
		<label for="rue">Rue</label>
		<input type="text" name="rue" id="rue">
		<br><br>
		<label for="code-postal">Code postal</label>
		<input type="text" name="code-postal" id="code-postal">
		<br><br>	
		<label for="ville">Ville</label>
		<input type="text" name="ville" id="ville">
		<br><br>	
		<label for="mot-de-passe">Mot de passe</label>
		<input type="password" name="mot-de-passe" id="mot-de-passe" required>
		<br><br>
		
		<input type="submit" value="SUBSCRIBE"> 
	</form>
	
	</fieldset>
	
</div>


<button>
	<a href="<%=request.getContextPath()%>/connection/login"> IF OK</a>
</button>

<button>
	<a href="<%=request.getContextPath()%>/home"> ANNULER </a>
</button>


</body>
</html>