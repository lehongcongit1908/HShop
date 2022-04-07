<%@ page pageEncoding="UTF-8"%>

<div class="panel panel-danger">
	<div class="panel-heading">
        <h3 class="panel-title">
        	<i class="glyphicon glyphicon-search"></i>
        	Tìm kiếm
        </h3>
    </div>
    <form method="post" action="/product/find-by-keywords" class="panel-body">
        <input value="${param.keywords}" name="keywords" placeholder="Từ khóa" class="form-control" />
    </form>
</div>