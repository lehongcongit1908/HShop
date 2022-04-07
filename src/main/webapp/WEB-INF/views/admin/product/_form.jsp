<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="${url}/index" modelAttribute="form" enctype="multipart/form-data">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <b>PRODUCT EDITION</b>
            <i class="text-danger pull-right">${message}</i>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-6">
                    <div class="form-group col-sm-6 text-center">
                        <label for="image_file">
                            <img src="/static/images/items/${form.image}" style="height: 200px; max-width: 95%">
                        </label>
                        <input id="image_file" name="image_file" type="file" class="form-control">
                        <form:hidden path="image"/>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label>Id:</label>
                        <form:input path="id" placeholder="Auto Number" readonly="true" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Name:</label>
                        <form:input path="name" placeholder="Name?" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Unit Price:</label>
                        <form:input path="unitPrice" placeholder="Unit Price?" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Discount:</label>
                        <form:input path="discount" placeholder="Discount?" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>Quantity:</label>
                    <form:input path="quantity" placeholder="Quantity?" class="form-control"/>
                </div>
                <div class="form-group col-sm-6">
                    <label>Product Date:</label>
                    <form:input path="productDate" placeholder="Product Date?" class="form-control"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>Category:</label>
                    <form:select path="category.id" class="form-control">
                        <form:options items="${cates}" itemValue="id" itemLabel="nameVN"/>
                    </form:select>
                </div>
                <div class="form-group col-sm-6">
                    <label>View Count:</label>
                    <form:input path="clickCount" placeholder="View Count?" class="form-control"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>Latest:</label>
                    <div class="form-control">
                        <form:radiobutton path="latest" value="true" label="Yes" class="radio-inline"/>
                        <form:radiobutton path="latest" value="false" label="No" class="radio-inline"/>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label>Special:</label>
                    <div class="form-control">
                        <form:radiobutton path="special" value="true" label="Yes" class="radio-inline"/>
                        <form:radiobutton path="special" value="false" label="No" class="radio-inline"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label>Description:</label>
                    <form:textarea path="description" rows="3" placeholder="Description?" class="form-control"></form:textarea>
                </div>
            </div>
        </div>
        <div class="panel-footer text-right">
            <button formaction="${url}/create" ${empty form.id ? '' : 'disabled'} class="btn btn-primary">
			    <i class="glyphicon glyphicon-plus"></i> Create
			</button>
			<button formaction="${url}/update" ${empty form.id ? 'disabled' : ''} class="btn btn-success">
			    <i class="glyphicon glyphicon-saved"></i> Update
			</button>
			<a href="${url}/delete/${form.id}" ${empty form.id ? 'disabled' : ''} class="btn btn-danger">
			    <i class="glyphicon glyphicon-trash"></i> Delete
			</a>
			<a href="${url}/index" class="btn btn-info">
			    <i class="glyphicon glyphicon-retweet"></i> Reset
			</a>
        </div>
    </div>    
</form:form>