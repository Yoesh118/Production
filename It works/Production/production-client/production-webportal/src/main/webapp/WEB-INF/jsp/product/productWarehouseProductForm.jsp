<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <%@include file="../template/dashboard/productWarehouseProfile.jspf" %>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <%@include file="../template/message.jspf" %> 
                        <a href="../dashboard/profile.htm?id=${productWarehouse.warehouseId}">${productWarehouse.warehouseName}'s Dashboard</a><br/><br/>
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="productWarehouse" value="${productWarehouse.warehouseId}"/>
                            <form:hidden path="productWarehouseProductId"/>
                            <c:if test="${not empty item.productWarehouseProductId}">
                                <form:hidden path="dateCreated"/>
                                <%--<form:hidden path="createdBy" value="${item.createdBy.username}"/>--%>
                            </c:if>
                          
                                 <div class="form-group">
                                <label>Product Name</label>
                                   <form:select path="product" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${product}" itemValue="productId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="product" class="alert-danger"/>
                                </p> 
                            </div> 
                                
                            <div class="form-group">
                                <label>Product No</label>
                                   <form:select path="productWarehouseProductNo" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${product}" itemValue="productId" itemLabel="productNo"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="product" class="alert-danger"/>
                                </p> 
                            </div>  
                                
                            <div class="form-group">
                                <label>Product Description</label>
                                   <form:select path="productWarehouseProductDescription" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${product}" itemValue="productId" itemLabel="description"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="product" class="alert-danger"/>
                                </p> 
                            </div>  
                                
                             <div class="form-group">
                                <label>Stock Status</label><br/>
                                <form:radiobutton path="status" label="Available" value="true"/>
                                <form:radiobutton path="status" label="Unavailable" value="false"/>
                             </div>
                                
                            <div class="form-group">
                                <label>Quantity</label>
                                <form:input path="qty" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="qty" class="alert-danger"/>
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


<script type="text/javascript">
    $("select#product").change(function () {
    $this = $(this);
    $("#productWarehouseProductNo").val($this.val());
    $("#productWarehouseProductDescription").val($this.val());
});

</script>