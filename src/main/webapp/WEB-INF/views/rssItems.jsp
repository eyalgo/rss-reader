<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<style type="text/css">
		h1 {color:red;}
		div
		{
			background-color:#E6E6FA;
			box-shadow: 6px 6px 2px #888888;
			border:1px solid;
			border-radius:3px;
			margin-bottom:6px;
			padding-top:3px;
			padding-bottom:3px;
		}
	</style>
</head>
<body>
	<h1>RSS Items</h1>
 
	<c:forEach items="${items}" var="item">
		<div>
			<a href="${item.link}" target="_blank">${item.title}</a><br>
			${item.publishedDate}
		</div>
	</c:forEach>
 </body>
</html>