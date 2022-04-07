<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target="#hmenu">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Đại Phong</a>
        </div>
        <div class="collapse navbar-collapse" id="hmenu">
            <ul class="nav navbar-nav">
                <li><a href="/home/index"><i class="glyphicon glyphicon-home"></i> <s:message code="layout.menu.home"/> </a></li>
                <li><a href="#"><i class="glyphicon glyphicon-info-sign"></i> Giới thiệu</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-envelope"></i> Liên hệ</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-send"></i> Góp ý</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-question-sign"></i> Hỏi đáp</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        Tài khoản
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                    <c:choose>
                    	<c:when test="${empty sessionScope.user}">
                    		<li><a href="/account/login">Đăng nhập</a></li>
	                        <li><a href="/account/forgot">Quên mật khẩu</a></li>
	                        <li><a href="/account/register">Đăng ký</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li><a href="/account/logoff">Đăng xuất</a></li>
	                        <li><a href="/account/change">Đổi mật khẩu</a></li>
	                        <li><a href="/account/edit">Cập nhật tài khoản</a></li>
	                        <li class="divider"></li>
	                        <li><a href="/order/list">Đơn đặt hàng</a></li>
	                        <li><a href="/order/items">Hàng đã mua</a></li>
                    	</c:otherwise>
                    </c:choose>                       
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/home/index?lang=en"><i class="glyphicon glyphicon-user"></i> English</a></li>
                <li><a href="/home/index?lang=vi"><i class="glyphicon glyphicon-log-in"></i> Tiếng Việt</a></li>
            </ul>
        </div>
    </div>
</nav>
<script>
	$(function(){
		$("a[href*=lang]").click(function(e){
			e.preventDefault();
			var href = $(this).attr("href");
			$.ajax({
				url: href,
				success: function(){
					location.reload();
				}
			})
			//return false;
		})
	})
</script>