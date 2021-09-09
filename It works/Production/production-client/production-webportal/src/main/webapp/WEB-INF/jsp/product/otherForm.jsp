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
                            <form:hidden path="otherId"/>
                            <c:if test="${not empty item.otherId}">
                                <form:hidden path="dateCreated"/>
                                <%--<form:hidden path="createdBy" value="${item.createdBy.username}"/>--%>
                            </c:if>
                            <div class="form-group">
                                <label>Cost Name</label>
                                <form:input path="name" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="name" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Cost Description</label>
                                <form:input path="description" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="description" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Amount</label>
                                <form:input path="cost" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="cost"/>
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
                                <label>Payment Date</label>
                                <form:input path="datePaid" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="datePaid"/>
                                </p>
                            </div>
                                
                             <div class="form-group">
                                <label>ShortFall</label>
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
    $("#datePaid").datepicker({
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