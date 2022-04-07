<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!--Slide show-->
<div class="mi-slider">
<c:forEach var="c" items="${list}">
	<ul>
	<c:forEach var="p" items="${c.products}">
		<li>
			<a href="/product/detail/${p.id}"> <img src="/static/images/items/${p.image}" />
				<h4>${p.unitPrice}</h4>
			</a>
		</li>
	</c:forEach>
	</ul>
</c:forEach>
	<nav>
		<c:forEach var="c" items="${list}">
			<a href="#">${c.name}</a>
		</c:forEach>
	</nav>
</div>
<style>
.mi-slider {
	height: 330px;
}

.mi-slider ul li img {
	height: 200px;
}
</style>
<script>
	$(function() {
		showCatSlider('.mi-slider', 5000);
	});
</script>