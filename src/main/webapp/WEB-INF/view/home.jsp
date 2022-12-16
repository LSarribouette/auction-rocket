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
	
<h1>Accueil</h1>

<button>
	<a href="<%=request.getContextPath()%>/connection/login">Se connecter | S'inscrire</a>
</button>

<jsp:include page="/WEB-INF/view/blocs/search.jsp"/>

<jsp:include page="/WEB-INF/view/blocs/display-result.jsp"/>

</body>
</html>