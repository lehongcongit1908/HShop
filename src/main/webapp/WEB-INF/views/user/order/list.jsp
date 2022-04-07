<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel panel-warning">
    <div class="panel-heading">
        <h3 class="panel-title"><b>Đơn hàng của bạn</b></h3>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Ngày đặt</th>
                <th>Tổng tiền</th>
                <th>Địa chỉ giao hàng</th>
                <th>Trạng thái</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="o" items="${orders}">
            <tr>
                <td>${o.id}</td>
                <td>${o.orderDate}</td>
                <td>${o.amount}</td>
                <td>${o.address}</td>
                <td>${status[o.status]}</td>
                <td class="text-right">
                    <c:if test="${o.status == 0}">
                    	<a href="/order/cancel/${o.id}" class="btn btn-xs btn-danger glyphicon glyphicon-trash"></a>
                    </c:if>
                    <a href="/order/detail/${o.id}" class="btn btn-xs btn-warning glyphicon glyphicon-search"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panel-footer text-right">
        <b>Total Amount: ?</b>
    </div>
</div>