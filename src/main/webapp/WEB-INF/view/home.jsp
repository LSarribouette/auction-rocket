<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCTION ROCKET - Homepage</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/blocs/header.jsp">
		<jsp:param value="false" name="isConnected"/>
		<jsp:param value="home.jsp" name="from"/>
</jsp:include>
	
<h1>THIS IS HOME.JSP</h1>

<button>
	<a href="<%=request.getContextPath()%>/ServletConnection">Log in / Sign up</a>
</button>


</body>
</html>