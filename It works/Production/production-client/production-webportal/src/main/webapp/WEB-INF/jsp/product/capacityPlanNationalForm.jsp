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
                        <form:form modelAttribute="capacityPlan">
                            <form:hidden path="capacityPlanId"/>
                            <div class="form-group">
                                <label>Plan Id</label>
                                <form:input path="capacityPlanId" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="capacityPlanId" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Plan Description</label>
                                <form:input path="capacityPlanDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="capacityPlanDescription" class="alert-danger"/>
                                </p>
                            </div>                               
                            <div class="form-group">
                                <label> Team Assigned </label>
                                <form:input path="labour" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="labour" class="alert-danger"/>
                                </p>
                            </div>                                
                            <div class="form-group">
                                <label>Plan Materials</label>
                                <form:input path="material" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="material" class="alert-danger"/>
                                </p>
                            </div>                               
                            <div class="form-group">
                                <label>Equipment</label>
                                <form:input path="equipment" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="equipment" class="alert-danger"/>
                                </p>
                            </div>                           
                            <div class="form-group">
                                <label>Machinery</label>
                                <form:input path="machinery" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="machinery" class="alert-danger"/>
                                </p>
                            </div>                           
                            <div class="form-group">
                                <label>Product Demand</label>
                                <form:input path="equipment" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="equipment" class="alert-danger"/>
                                </p>
                            </div>                                
                            <div class="form-group">
                                <label>Product Work Order</label>
                                <form:input path="equipment" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="equipment" class="alert-danger"/>
                                </p>
                            </div>                                
                            <div class="form-group">
                                <label>Plan Date</label>
                                <form:input path="planDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="planDate" class="alert-danger"/>
                                </p>
                            </div>                                
                            <div class="form-group">
                                <label>Plan Manager</label>
                                <form:input path="manager" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="manager" class="alert-danger"/>
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