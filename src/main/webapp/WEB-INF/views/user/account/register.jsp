<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/account/register" modelAttribute="form" enctype="multipart/form-data">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                <i class="glyphicon glyphicon-user"></i>
                <b>REGISTRATION</b>
            </h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-user"></i> Username:</label>
                    <form:input path="id" placeholder="Username?" class="form-control"/>
                </div>
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-text-size"></i> Fullname:</label>
                    <form:input path="fullname" placeholder="Fullname?" class="form-control"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-lock"></i> Password:</label>
                    <form:input path="password" placeholder="Password?" type="password" class="form-control"/>
                </div>
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-lock"></i> Confirm Password:</label>
                    <input name="confirm" placeholder="Confirm Password?" type="password" class="form-control">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-picture"></i> Photo:</label>
                    <input name="photo_file" placeholder="Photo?" type="file" class="form-control">
                </div>
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-envelope"></i> Email Address:</label>
                    <form:input path="email" placeholder="Email Address?" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="panel-footer text-right">
            <button class="btn btn-default">
                <i class="glyphicon glyphicon-ok"></i> Sign Up
            </button>
            <b class="pull-left text-danger"><i>${message}</i></b>
        </div>
    </div>    
</form:form>