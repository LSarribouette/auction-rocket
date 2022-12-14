<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCTION ROCKET - HOME connected</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/blocs/header.jsp">
		<jsp:param value="true" name="isConnected"/>
		<jsp:param value="auction-home.jsp" name="from"/>
</jsp:include>

<h1>AUCTION HOME user is connected</h1>

	<jsp:include page="/WEB-INF/view/blocs/search-bloc.jsp">
		<jsp:param value="true" name="isConnected"/>
		<jsp:param value="auction-home.jsp" name="from"/>
	</jsp:include>
	<hr>
	<jsp:include page="/WEB-INF/view/blocs/display-search-result.jsp">
		<jsp:param value="auction-home.jsp" name="from"/>
	</jsp:include>


</body>
</html>