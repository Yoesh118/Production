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
                            <%@include file="../template/dashboard/processingPlantProfile.jspf" %>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <%@include file="../template/message.jspf" %> 
                        <a href="../dashboard/profile.htm?id=${processingPlant.processingPlantId}">${processingPlant.processingPlantName}'s Dashboard</a><br/><br/>
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="processingPlant" value="${processingPlant.processingPlantId}"/>
                            <form:hidden path="ProcessingPlantProductionTeamId"/>
                            <c:if test="${not empty item.processingPlantProductionTeamId}">
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
                                <form:select path="processingPlantProductionTeamNo" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="teamNo"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
                                </p>
                            </div>
                            
                            <div class="form-group">
                                <label> Team Members </label>
                                <form:select path="processingPlantProductionTeamDescription" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="productionTeamMembers"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
                                </p>
                            </div>
                             <div class="form-group">
                                <label> Team Duties </label>
                                <form:select path="processingPlantProductionTeamDuties" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="productionTeamDescription"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
                                </p>
                            </div>
                             <div class="form-group">
                                <label> Team Duties </label>
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
    $("#processingPlantProductionTeamNo").val($this.val());
    $("#processingPlantProductionTeamDescription").val($this.val());
    $("#processingPlantProductionTeamDuties").val($this.val());
    $("#timeTillFree").val($this.val());
});

</script>