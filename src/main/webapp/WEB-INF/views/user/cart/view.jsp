<%@ page  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="panel panel-warning">
    <div class="panel-heading">
        <h3 class="panel-title"><b>Giỏ hàng của bạn</b></h3>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Stt</th>
                <th>Tên</th>
                <th>Giá</th>
                <th>Giảm </th>
                <th>Số lượng</th>
                <th>Tổng</th>
                <th></th>
            </tr>
        </thead>
        <tbody class="nn-cart-items">
        <c:forEach var="item" items="${cart.items}" varStatus="st">
            <tr data-item='{"id":${item.id}, "price":${item.price}, "disc":${item.disc}}'>
                <td>${st.index + 1}</td>
                <td><a href="/product/detail/${item.id}">${item.name}</a></td>
                <td>$${item.price}</td>
                <td>${item.disc * 100}%</td>
                <td>
                	<input class="nn-cart-change" value="${item.qty}" type="number" min="1" style="width:50px">
                </td>
                <td class="nn-item-amt">$${item.amount}</td>
                <td class="text-center">
                    <button class="btn btn-xs btn-danger glyphicon glyphicon-trash nn-cart-remove"></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panel-footer text-right">
        <a href="/home/index" class="btn btn-sm btn-info">
            <i class="glyphicon glyphicon-hand-left"></i> Mua thêm
        </a>
        <button class="btn btn-sm btn-warning nn-cart-clear">
            <i class="glyphicon glyphicon-trash"></i> Xóa hết
        </button>
        <c:if test="${empty sessionScope.user }">
        <a href="/order/checkout" class="btn btn-sm btn-success">
            <i class="glyphicon glyphicon-ok"></i> Checkout
        </a>
        </c:if>
        <b class="pull-left">Tổng đơn: <i class="cart-amt">?</i></b>
    </div>
</div>

<c:if test="${!empty sessionScope.user }">
<form action="/order/purchase" method="post">
<div class="panel panel-danger">
    <div class="panel-heading">
        <h3 class="panel-title"><b>Thông tin giao hàng</b></h3>
    </div>
    <div class="panel-body">
        <div class="form-group">
            <label>Địa chỉ:</label>
            <input name="address" placeholder="Bạn ở đâu?" class="form-control">
        </div>
        <div class="form-group">
            <label>Ghi chú thêm:</label>
            <textarea name="notes" placeholder="Bạn cần gì thêm?" rows="3" class="form-control"></textarea>
        </div>
	</div>
    <div class="panel-footer text-right">
        <button class="btn btn-danger">
            <i class="glyphicon glyphicon-gbp"></i>
            Mua
        </button>
    </div>
</div>
    </form>
</c:if>