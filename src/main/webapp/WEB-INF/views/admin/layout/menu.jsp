<%@ page pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target="#hmenu">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home/index">Trang chủ</a>
        </div>
        <div class="collapse navbar-collapse" id="hmenu">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        Quản lý
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/admin/product/index">Hàng hóa</a></li>
                        <li><a href="/admin/category/index">Loại hàng hóa</a></li>
                        <li><a href="/admin/customer/index">Khách hàng</a></li>
                        <li><a href="/admin/order/index">Đơn hàng</a></li>
                    </ul>
                </li>
                <li><a href="/admin/report/index">Thống kê</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        Phân quyền
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/account/logoff">Đăng xuất</a></li>
                        <li><a href="/account/change">Đổi mật khẩu</a></li>
                        <li><a href="/admin/master/index">Phân quyền sử dụng</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>