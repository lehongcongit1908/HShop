<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:set value="/admin/category" var="url" scope="request"/>
<h2 class="alert alert-success">Category Management</h2>

<ul class="nav nav-tabs">
    <li class="active">
        <a data-toggle="tab" href="#tab1">
            <i class="glyphicon glyphicon-th-list"></i> Edit
        </a>
    </li>
    <li>
        <a data-toggle="tab" href="#tab2">
            <i class="glyphicon glyphicon-edit"></i> List
        </a>
    </li>
</ul>
<div class="tab-content">
    <div id="tab1" class="tab-pane fade in active">
        <jsp:include page="_form.jsp"/>
    </div>
    <div id="tab2" class="tab-pane fade">
        <jsp:include page="_table.jsp"/>
    </div>
</div>
