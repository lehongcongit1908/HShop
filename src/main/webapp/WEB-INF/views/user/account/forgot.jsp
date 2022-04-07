<%@ page  pageEncoding="utf-8"%>
<form action="/account/forgot" method="post">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                <i class="glyphicon glyphicon-user"></i>
                <b>Quên mật khẩu</b>
            </h3>
        </div>
        <div class="panel-body">
            <div class="form-group">
                <label><i class="glyphicon glyphicon-user"></i> Username:</label>
                <input name="username" placeholder="Username?" class="form-control">
            </div>
            <div class="form-group">
                <label><i class="glyphicon glyphicon-envelope"></i> Email Address:</label>
                <input name="email" placeholder="Email Address?" class="form-control">
            </div>
        </div>
        <div class="panel-footer text-right">
            <button class="btn btn-default">
                <i class="glyphicon glyphicon-ok"></i> Lấy mật khẩu
            </button>
            <b class="pull-left text-danger"><i>${message}</i></b>
        </div>
    </div>    
</form>