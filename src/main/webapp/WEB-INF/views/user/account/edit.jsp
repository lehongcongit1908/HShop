<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/account/edit" modelAttribute="form" enctype="multipart/form-data">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                <i class="glyphicon glyphicon-user"></i>
                <b>EDIT PROFILE</b>
            </h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-4 text-center">
                    <label>
                        <img src="/static/images/users/${form.photo}" class="img-thumbnail" style="height: 210px; max-width: 200px;">
                        <input class="hide" name="photo_file" type="file">
                    </label>
                </div>
                <div class="col-sm-8">
                    <div class="form-group">
                        <label><i class="glyphicon glyphicon-user"></i> Username:</label>
                        <form:input path="id" placeholder="Username?" class="form-control" readonly="true"/>
                    </div>
                    <div class="form-group">
                        <label><i class="glyphicon glyphicon-text-size"></i> Fullname:</label>
                        <form:input path="fullname" placeholder="Fullname?" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label><i class="glyphicon glyphicon-envelope"></i> Email Address:</label>
                        <form:input path="email" placeholder="Email Address?" class="form-control"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel-footer text-right">
            <form:hidden path="password"/>
            <form:hidden path="activated"/>
            <form:hidden path="admin"/>
            <form:hidden path="photo"/>
            <button class="btn btn-default">
                <i class="glyphicon glyphicon-ok"></i> Update Profile
            </button>
            <b class="pull-left text-danger"><i>${message}</i></b>
        </div>
    </div>    
</form:form>