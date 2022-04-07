<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title"><b>ORDER LINES</b></h3>
    </div>
    <table class="table table-hover">
        <thead class="bg-success">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Unit Price</th>
                <th>Discount</th>
                <th>Quantity</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="d" items="${form.orderDetails}">
                <tr>
                    <td>${d.product.id}</td>
                    <td>${d.product.name}</td>
                    <td>${d.unitPrice}</td>
                    <td>${d.discount * 100}%</td>
                    <td>${d.quantity}</td>
                    <td>
                    	<fmt:formatNumber pattern="#,###.00" value="${d.unitPrice * d.quantity * (1 - d.discount)}"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>