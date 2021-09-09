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
                            <form:hidden path="processingPlantMachineryId"/>
                            <c:if test="${not empty item.processingPlantMachineryId}">
                                <form:hidden path="dateCreated"/>
                                <%--<form:hidden path="createdBy" value="${item.createdBy.username}"/>--%>
                            </c:if>
                            <div class="form-group">
                                <label> Machine Name </label>
                                <form:select path="machinery" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${machinery}" itemValue="machineryId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="machinery" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label> Machine No </label>
                                <form:select path="processingPlantMachineryNo" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${machinery}" itemValue="machineryId" itemLabel="machineNo"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="machinery" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label> Description </label>
                                <form:select path="processingPlantMachineryDescription" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${machinery}" itemValue="machineryId" itemLabel="description"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="machinery" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label> Machine Capacity </label>
                                <form:select path="processingPlantMachineryCapacity" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${machinery}" itemValue="machineryId" itemLabel="machineCapacity"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="machinery" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label>Machine User Status</label><br/>
                                <form:radiobutton path="status" label="Available" value="true"/>
                                <form:radiobutton path="status" label="In Use" value="false"/>
                            </div>


                            <div class="form-group">
                                <label> User </label> 
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
                                    <form:errors path="userLocation"/>
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
    $("select#processingPlantMachineryNo").change(function () {
        $this = $(this);
        $("#processingPlantMachineryDescription").val($this.val());
        $("#processingPlantMachineryCapacity").val($this.val());
    });

</script>