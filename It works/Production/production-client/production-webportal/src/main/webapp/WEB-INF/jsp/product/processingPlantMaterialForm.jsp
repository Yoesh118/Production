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
                            <form:hidden path="processingPlantMaterialId"/>
                            <c:if test="${not empty item.processingPlantMaterialId}">
                                <form:hidden path="dateCreated"/>
                                <%--<form:hidden path="createdBy" value="${item.createdBy.username}"/>--%>
                            </c:if>
                            <div class="form-group">
                                <label> Material Name </label>
                                <form:select path="material" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${material}" itemValue="materialId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="material" class="alert-danger"/>
                                </p>
                            <div class="form-group">
                                <label>Material Description</label>
                                <form:input path="processingPlantMaterialDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="processingPlantMaterialDescription" class="alert-danger"/>
                                </p>
                            </div>    
                            <div class="form-group">
                                <label>Date Acquired</label>
                                <form:input path="dateAcquired" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="dateAcquired" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Material Quantity</label>
                                <form:input path="quantity" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="quantity" class="alert-danger"/>
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
    $("#dateAcquired").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy'
    });
</script>