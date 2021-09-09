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
                        <form:form modelAttribute="processPlan">
                            <form:hidden path="processPlanId"/>
                            <div class="form-group">
                                <label>Order Number</label>
                                <form:input path="OrderNo" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="OrderNo" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Number of Stages</label>
                                <form:input path="processStages" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="processStages" class="alert-danger"/>
                                </p>
                            </div>  
                            <div class="form-group">
                                <label>Stage Descriptions</label>
                                <form:textarea path="description" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="description"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Current Stage Number</label>
                                <form:input path="stageNo" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="stageNo" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label> Order Status </label>
                                <form:select path="batchStatus" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${batchStatus}" itemValue="batchStatusId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="batchStatus" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label> Processing Plant Name</label>
                                <form:select path="processingPlant" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${processingPlant}" itemValue="processingPlantId" itemLabel="processingPlantName"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="processingPlant" class="alert-danger"/>
                                </p>
                            </div> 
                             <div class="form-group">
                                <label> Warehouse Name </label>
                                <form:select path="productWarehouse" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productWarehouse}" itemValue="warehouseId" itemLabel="warehouseName"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productWarehouse" class="alert-danger"/>
                                </p>
                            </div> 
                               <div class="form-group">
                                <label>Start Date</label>
                                <form:input path="startDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="startDate" class="alert-danger"/>
                                </p>
                            </div> 
                             <div class="form-group">
                                <label>End Date</label>
                                <form:input path="endDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="endDate" class="alert-danger"/>
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
    $("#startDate").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy'
    });
    $("#endDate").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy'
    });
</script>
