<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đại Phong Helmet</title>
	<tiles:insertAttribute name="head"/>
</head>
<body class="container">
	<header class="row">
		<h2>Trang quản trị</h2>
	</header>
	<nav class="row">
		<tiles:insertAttribute name="menu"/>
	</nav>
	<main class="row">
		<tiles:insertAttribute name="main"/>
	</main>
	<footer class="row text-center">
		<p>&copy; Đại phong Helmet</p>
	</footer>
</body>
</html>