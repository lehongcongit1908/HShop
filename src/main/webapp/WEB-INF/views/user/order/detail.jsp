<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"><b>Thông tin đặt hàng</b></h3>
    </div>
    <form:form class="panel-body" modelAttribute="order">
        <div class="row">
            <div class="form-group col-sm-4">
                <label>Id:</label>
                <form:input path="id" readonly="true" class="form-control"/>
            </div>
            <div class="form-group col-sm-4">
                <label>Mã người đặt:</label>
                <form:input path="customer.id" readonly="true" class="form-control"/>
            </div>
            <div class="form-group col-sm-4">
                <label>Ngày đặt:</label>
                <form:input path="orderDate" readonly="true" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-4">
                <label>Tổng tiền:</label>
                <form:input path="amount" readonly="true" class="form-control"/>
            </div>
            <div class="form-group col-sm-4">
                <label>Trạng thái:</label>
                <form:input path="status" readonly="true" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-12">
                <label>Địa chỉ giao hàng:</label>
                <form:input path="address" readonly="true" class="form-control"/>
            </div>
            <div class="form-group col-sm-12">
                <label>Ghi chú:</label>
                <form:textarea path="notes" readonly="true" rows="3" class="form-control"></form:textarea>
            </div>
        </div>
    </form:form>
</div>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"><b>Chi tiết đặt hàng</b></h3>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Tên</th>
                <th>Đơn giá</th>
                <th>Giảm giá</th>
                <th>Số lượng</th>
                <th>Tổng</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="d" items="${order.orderDetails}">
            <tr>
                <td>${d.product.id}</td>
                <td>${d.product.name}</td>
                <td>${d.unitPrice}</td>
                <td>${d.discount*100}%</td>
                <td>${d.quantity}</td>
                <td>${d.unitPrice * d.quantity * (1 - d.discount)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<c:if test="${order.status == 0}">
<div class="panel panel-default">
    <div class="panel-heading">
        <a href="/order/cancel/${order.id}" class="btn btn-default">Hủy</a>
    </div>
</div>
</c:if>