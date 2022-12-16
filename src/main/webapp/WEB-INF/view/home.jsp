<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCTION ROCKET - Homepage</title>
</head>
<body>

<jsp:include page="/WEB-INF/view/blocs/header.jsp"/>
	
<h1>Accueil</h1>

<button>
	<a href="<%=request.getContextPath()%>/connection/login">Log in / Sign up</a>
</button>

<jsp:include page="/WEB-INF/view/blocs/search.jsp"/>

<jsp:include page="/WEB-INF/view/blocs/display-result.jsp"/>

</body>
</html>