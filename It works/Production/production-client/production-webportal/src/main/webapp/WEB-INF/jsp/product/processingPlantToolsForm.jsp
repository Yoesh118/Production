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
                            <form:hidden path="processingPlantToolId"/>
                            <c:if test="${not empty item.processingPlantToolId}">
                                <form:hidden path="dateCreated"/>
                                <%--<form:hidden path="createdBy" value="${item.createdBy.username}"/>--%>
                            </c:if>
                            
                          <div class="form-group">
                                <label>Tool Name</label>
                                   <form:select path="tools" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${tools}" itemValue="toolId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="tools" class="alert-danger"/>
                                </p> 
                            </div>  
                                
                               <div class="form-group">
                                <label>Tool No</label>
                                   <form:select path="processingPlantToolNo" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${tools}" itemValue="toolId" itemLabel="toolNo"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="tools" class="alert-danger"/>
                                </p> 
                            </div>  
                                
                            <div class="form-group">
                                <label>Tool Description</label>
                                   <form:select path="processingPlantToolDescription" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${tools}" itemValue="toolId" itemLabel="description"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="tools" class="alert-danger"/>
                                </p> 
                            </div>  
                         
                             <div class="form-group">
                                <label>Usage Status</label><br/>
                                <form:radiobutton path="status" label="Free" value="true"/>
                                <form:radiobutton path="status" label="In Use" value="false"/>
                            </div>
                                
                            <div class="form-group">
                                <label>User Name</label>
                               <form:select path="productionTeam" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="productionTeamName"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
                                </p>
                            </div> 
                                
                            <div class="form-group">
                                <label>User Location</label>
                                <form:input path="userLocation" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="userLocation" class="alert-danger"/>
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
    $("select#tools").change(function () {
    $this = $(this);
    $("#processingPlantToolNo").val($this.val());
    $("#processingPlantToolDescription").val($this.val());
});

</script>