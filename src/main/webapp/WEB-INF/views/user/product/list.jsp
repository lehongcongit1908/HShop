<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="row">
<c:forEach var="p" items="${prods}">
	<div class="col-sm-4">
    <div class="panel panel-default nn-prod">
        <div class="panel-heading text-center">
            ${p.name}
        </div>
        <div class="panel-body text-center">
            <a href="/product/detail/${p.id}">
                <img src="/static/images/items/${p.image}">
                <!--  <img src="/static/images/items/helmet1.png"> -->
            </a>
        </div>
        <div class="panel-footer">
            <div class="row" data-item="${p.id}">
                <div class="col-xs-4 text-left text-primary">$${p.unitPrice}</div>
                <div class="col-xs-8 text-right">
					<jsp:include page="_actions.jsp"/>
                </div>
            </div>
        </div>
        <c:choose>
        	<c:when test="${p.special}">
        		<img src="/static/images/special_icon.gif">
        	</c:when>
        	<c:when test="${p.latest}">
        		<img src="/static/images/new_icon.gif">
        	</c:when>
        	<c:when test="${p.discount > 0}">
        		<img src="/static/images/promo_icon.gif">
        	</c:when>
        </c:choose>
        
    </div>
</div>
</c:forEach></div>

<jsp:include page="_send-dialog.jsp"/>