<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="${url}/index" modelAttribute="form">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <b>CATEGORY EDITION</b>
            <i class="pull-right" style="color:yellow">${message}${param.message}</i>
        </div>
        <div class="panel-body">
            <div class="form-group">
                <label>Id:</label>
                <form:input path="id" placeholder="Auto Number" readonly="true" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Tên tiếng anh:</label>
                <form:input path="name" placeholder="Tên tiếng anh?" class="form-control"/>
                <form:errors path="name"/>
            </div>
            <div class="form-group">
                <label>Tên tiếng việt:</label>
                <form:input path="nameVN" placeholder="Tên tiếng việt?" class="form-control"/>
            </div>
            
            
        </div>
        <div class="panel-footer text-right">
            <button formaction="${url}/create" ${empty form.id ? '' : 'disabled'} class="btn btn-primary">
			    <i class="glyphicon glyphicon-plus"></i> Create
			</button>
			<button formaction="${url}/update" ${empty form.id ? 'disabled' : ''} class="btn btn-success">
			    <i class="glyphicon glyphicon-saved"></i> Update
			</button>
			<a href="${url}/delete/${form.id}" ${empty form.id ? 'disabled' : ''} class="btn btn-danger">
			    <i class="glyphicon glyphicon-trash"></i> Delete
			</a>
			<a href="${url}/index" class="btn btn-info">
			    <i class="glyphicon glyphicon-retweet"></i> Reset
			</a>
        </div>
    </div>    
</form:form>