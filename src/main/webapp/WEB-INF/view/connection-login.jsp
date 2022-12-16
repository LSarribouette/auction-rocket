<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCTION ROCKET - log in</title>
</head>
<body>

<h1>connection-login</h1>

form login ! 
<br>

OR

create account ? -> 
<button>
	<a href="<%=request.getContextPath()%>/connection/signup"> Sign up</a>
</button>

<%if(request.getAttribute("message")!=null) {%>
<h3 strong style="color:red"><%=request.getAttribute("message") %></h3>
<%} %>

<fieldset>
	<legend>LOGIN</legend>
	<form method="post" action="<%=request.getContextPath()%>/connection/login">
		<label for="pseudo">pseudo</label>
		<input type="text" id="pseudo" name="pseudo" required>
		<label for="pwd">Mot De Passe</label>
		<input type="password" id="pwd" name="pwd" required>
		<input type="submit">
	</form>
</fieldset>



</body>
</html>