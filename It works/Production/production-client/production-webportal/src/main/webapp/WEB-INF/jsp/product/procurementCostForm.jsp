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
                            <%@include file="../template/dashboard/productionCostProfile.jspf" %>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <%@include file="../template/message.jspf" %> 
                        <a href="../dashboard/profile.htm?id=${productionCost.productionCostId}">${productionCost.name}'s Dashboard</a><br/><br/>
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="productionCost" value="${productionCost.productionCostId}"/>
                            <form:hidden path="procurementCostId"/>
                            <c:if test="${not empty item.procurementCostId}">
                                <form:hidden path="dateCreated"/>
                                <%--<form:hidden path="createdBy" value="${item.createdBy.username}"/>--%>
                            </c:if>
                            <div class="form-group">
                                <label>Procurement Item</label>
                                <form:input path="item" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="item" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <form:input path="qty" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="qty" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Unit Cost</label>
                                <form:input path="unitCost" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="unitCost"/>
                                </p>
                            </div>
                                
                             <div class="form-group">
                                <label> Payment Status </label>
                                <form:select path="batchStatus" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${batchStatus}" itemValue="batchStatusId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="batchStatus" class="alert-danger"/>
                                </p>
                            </div>
                                
                                
                              <div class="form-group">
                                <label>Date of Procurement</label>
                                <form:input path="procurementDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="procurementDate"/>
                                </p>
                            </div>
                            
                            <div class="form-group">
                                <label>Shortfall</label>
                                <form:input path="shortfall" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="shortfall"/>
                                </p>
                            </div>
                                
                             <div class="form-group">
                                <label>Payment Deadline</label>
                                <form:input path="deadline" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="deadline"/>
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
    $("#procurementDate").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy'
    });
    $("#deadline").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy'
    });

</script>