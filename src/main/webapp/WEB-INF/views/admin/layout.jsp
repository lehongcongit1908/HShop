<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Online Shopping Center</title>
	<tiles:insertAttribute name="head"/>
</head>
<body class="container">
	<header class="row">
		<h2>Website Administration</h2>
	</header>
	<nav class="row">
		<tiles:insertAttribute name="menu"/>
	</nav>
	<main class="row">
		<tiles:insertAttribute name="main"/>
	</main>
	<footer class="row text-center">
		<p>&copy; 2021 by Nhất Nghệ. All rights reserved.</p>
	</footer>
</body>
</html>