<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title"><b>ORDER LIST</b></h3>
    </div>
    <table class="table table-hover">
        <thead class="bg-success">
            <tr>
                <th>Id</th>
                <th>Customer</th>
                <th>Order Date</th>
                <th>Amount</th>
                <th>Shipping Address</th>
                <th>Status</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.customer.id}</td>
                    <td>${item.orderDate}</td>
                    <td>${item.amount}</td>
                    <td>${item.address}</td>
                    <td>${statuses[item.status]}</td>
                    <td class="text-center">
                        <div class="btn-group btn-group-xs">
						    <a href="${url}/edit/${item.id}" class="btn btn-primary">
						        <i class="glyphicon glyphicon-edit"></i>
						    </a>
						    <a href="${url}/delete/${item.id}" class="btn btn-danger">
						        <i class="glyphicon glyphicon-trash"></i>
						    </a>
						</div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>