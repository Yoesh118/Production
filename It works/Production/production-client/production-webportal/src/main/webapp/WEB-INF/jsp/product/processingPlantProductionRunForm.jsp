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
                            <form:hidden path="ProcessingPlantProductionRunId"/>
                            <c:if test="${not empty item.processingPlantProductionRunId}">
                                <form:hidden path="dateCreated"/>
                                <%--<form:hidden path="createdBy" value="${item.createdBy.username}"/>--%>
                            </c:if>
                            <div class="form-group">
                                <label>Production Run No</label>
                                <form:input path="processingPlantProductionRunNo" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="processingPlantProductionRunNo" class="alert-danger"/>
                                </p>
                            </div>
                           
                             <div class="form-group">
                                <label>Run Description</label>
                                <form:input path="processingPlantProductionRunDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="processingPlantProductionRunDescription"/>
                                </p>
                             </div> 
                                
                             <div class="form-group">
                                <label>Start Date</label>
                                <form:input path="startDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="startDate"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                <label>Date of Completion</label>
                                <form:input path="completionDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="completionDate"/>
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
    $("#completionDate").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy'
    });
</script>