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
                        <form:form modelAttribute="productBatch">
                            <form:hidden path="productBatchId"/>
                            <div class="form-group">
                                <label>Batch Name</label>
                                <form:input path="productBatchName" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="productBatchName" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Batch Description</label>
                                <form:input path="batchDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="batchDescription" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Batch Quantity</label>
                                <form:input path="batchQuantity" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="batchQuantity" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label> Batch Status </label>
                                <form:select path="batchStatus" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${batchStatus}" itemValue="batchStatusId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="batchStatus" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label> Processing Plant </label>
                                <form:select path="processingPlant" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${processingPlant}" itemValue="processingPlantId" itemLabel="processingPlantName"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="processingPlant" class="alert-danger"/>
                                </p>
                            </div> 
                          <div class="form-group">
                                <label> Warehouse </label>
                                <form:select path="productWarehouse" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productWarehouse}" itemValue="warehouseId" itemLabel="warehouseName"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productWarehouse" class="alert-danger"/>
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