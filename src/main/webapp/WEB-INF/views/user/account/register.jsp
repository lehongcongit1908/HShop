<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/account/register" modelAttribute="form" enctype="multipart/form-data">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                <i class="glyphicon glyphicon-user"></i>
                <b>Đăng kí</b>
            </h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-user"></i> Username:</label>
                    <form:input path="id" placeholder="Username?" class="form-control"/>
                </div>
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-text-size"></i> Tên đầy đủ:</label>
                    <form:input path="fullname" placeholder="Tên đầy đủ?" class="form-control"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-lock"></i> Mật khẩu:</label>
                    <form:input path="password" placeholder="Mật khẩu?" type="password" class="form-control"/>
                </div>
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-lock"></i> Xác nhận mật khẩu:</label>
                    <input name="confirm" placeholder="Xác nhận mật khẩu?" type="password" class="form-control">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-picture"></i> Ảnh:</label>
                    <input name="photo_file" placeholder="Photo?" type="file" class="form-control">
                </div>
                <div class="form-group col-sm-6">
                    <label><i class="glyphicon glyphicon-envelope"></i> Email:</label>
                    <form:input path="email" placeholder="Email?" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="panel-footer text-right">
            <button class="btn btn-default">
                <i class="glyphicon glyphicon-ok"></i> Đăng kí
            </button>
            <b class="pull-left text-danger"><i>${message}</i></b>
        </div>
    </div>    
</form:form>