<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title"><b>Danh sách sản phẩm</b></h3>
    </div>
    <table class="table table-hover">
        <thead class="bg-success">
            <tr>
                <th>Id</th>
                <th>Tên</th>
                <th>Giá</th>
                <th>Giảm giá</th>
                <th>Số lượng</th>
                <th>Ngày nhập</th>
                <th>Hàng mới</th>
                <th>Đặc biệt</th>
                <th>Lượt xem</th>
                <th>Loại hàng</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.unitPrice}</td>
                    <td>${item.discount*100}%</td>
                    <td>${item.quantity}</td>
                    <td>${item.productDate}</td>
                    <td>${item.latest?'Yes':'No'}</td>
                    <td>${item.special?'Yes':'No'}</td>
                    <td>${item.clickCount}</td>
                    <td>${item.category.nameVN}</td>
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