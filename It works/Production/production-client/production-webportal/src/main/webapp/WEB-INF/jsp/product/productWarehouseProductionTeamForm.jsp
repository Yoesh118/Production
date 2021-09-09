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
                            <form:hidden path="ProductWarehouseProductionTeamId"/>
                            <c:if test="${not empty item.productWarehouseProductionTeamId}">
                                <form:hidden path="dateCreated"/>
                                <%--<form:hidden path="createdBy" value="${item.createdBy.username}"/>--%>
                            </c:if>
                            <div class="form-group">
                                <label> Team Name </label>
                                <form:select path="productionTeam" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="productionTeamName"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
                                </p>
                            </div>
                            
                            <div class="form-group">
                                <label> Team No </label>
                                <form:select path="productWarehouseProductionTeamNo" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="teamNo"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
                                </p>
                            </div>
                            
                            <div class="form-group">
                                <label> Team Members </label>
                                <form:select path="productWarehouseProductionTeamDescription" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="productionTeamMembers"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
                                </p>
                            </div>
                             
                             <div class="form-group">
                                <label>Team Duties</label>
                                <form:input path="productWarehouseProductionTeamDuties" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="productWarehouseProductionTeamDuties" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Time Till Free</label>
                                <form:select path="timeTillFree" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="timeTillFree"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
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
    $("select#productionTeam").change(function () {
    $this = $(this);
    $("#productWarehouseProductionTeamNo").val($this.val());
    $("#productWarehouseProductionTeamMembers").val($this.val());
    $("#timeTillFree").val($this.val());
});

</script>