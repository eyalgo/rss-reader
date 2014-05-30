<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<style type="text/css">
		h1 {color:red;}
		h2 {color:green;}
	</style>
</head>
<body>
	<h1>RSS Items</h1>
 
	<c:forEach items="${items}" var="item">
		<h2>${item.title}</h2>
		<a href="${item.link}" target="_blank">${item.link}</a> 
		<hr>
	</c:forEach>
 </body>
</html>