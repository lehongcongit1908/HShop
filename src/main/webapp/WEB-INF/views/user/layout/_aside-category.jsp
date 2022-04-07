<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="panel panel-success">
    <div class="panel-heading">
        <h3 class="panel-title">
        	<i class="glyphicon glyphicon-list-alt"></i>
        	Loại hàng
        </h3>
    </div>
    <div class="list-group">
    	<c:forEach items="${cates}" var="cate">
        <a href="/product/find-by-category/${cate.id}" class="list-group-item">
        <c:choose>
        	<c:when test="${pageContext.response.locale.language == 'vi'}">${cate.nameVN}</c:when>
        	<c:otherwise>${cate.name}</c:otherwise>
        </c:choose>
            
        </a>
        </c:forEach>
    </div>
</div>
