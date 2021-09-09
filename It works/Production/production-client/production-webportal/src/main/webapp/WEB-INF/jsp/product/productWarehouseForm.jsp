<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form modelAttribute="productWarehouse">
                            <form:hidden path="warehouseId"/>
                            <div class="form-group">
                                <label>Warehouse Name</label>
                                <form:input path="warehouseName" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="warehouseName" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Warehouse Description</label>
                                <form:input path="warehouseDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="warehouseDescription" class="alert-danger"/>
                                </p>
                            </div>    
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit">Save</button>
                                <a href="${itemDelete}"><button class="btn btn-primary" type="button">Cancel</button></a>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../template/footer.jspf" %>