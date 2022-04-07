<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nón bảo hiểm</title>
	<tiles:insertAttribute name="head"/>
</head>
<body class="container">
    <header class="row">
        <h1 class=" w3-container w3-light-blue">
            <!-- <b class="glyphicon glyphicon-shopping-cart"></b> -->
            <b class="glyphicon glyphicon-shopping-cart"></b>
           
            <span>Đại Phong Helmet</span>
        </h1>
    </header>
    <nav class="row">
        <tiles:insertAttribute name="menu"/>
    </nav>
    <main class="row">
        <article class="col-sm-9">
            <div class="row">
                <tiles:insertAttribute name="main"/>
            </div>
        </article>
        <aside class="col-sm-3">
            <div class="row" style="margin-left: 2px;">
                <tiles:insertAttribute name="right"/>
            </div>
        </aside>
    </main>
    <footer class="row text-center">
        <div class="panel panel-default">
            <div class="panel-body">
               Đại Phong &copy; 2021. All rights reserved.
            </div>
        </div>
    </footer>
</body>
</html>