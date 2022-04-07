<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!--Slide show-->
<jsp:include page="_home-slideshow.jsp"/>

<!--Specials-->
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">HÀNG ĐẶC BIỆT</h3>
    </div>
    <div class="panel-body">
    	<jsp:include page="../product/list.jsp"/>
    </div>
</div>

