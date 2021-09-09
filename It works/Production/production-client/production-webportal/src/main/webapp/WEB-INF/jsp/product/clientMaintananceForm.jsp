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
                        <form:form modelAttribute="clientMaintanance">
                            <form:hidden path="clientMaintananceId"/>
                            <div class="form-group">
                                <label>Client Name</label>
                                <form:input path="clientName" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="clientName" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Item to maintain</label>
                                <form:input path="clientMaintananceProduct" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="clientMaintananceProduct" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Problem Description</label>
                                <form:input path="clientMaintananceDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="clientMaintananceDescription" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Cost to Client</label>
                                <form:input path="clientCost" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="clientCost" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Cost to Company</label>
                                <form:input path="companyCost" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="companyCost" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label> Team </label>
                                <form:select path="productionTeam" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="productionTeamName"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label> Maintanance Status </label>
                                <form:select path="batchStatus" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${batchStatus}" itemValue="batchStatusId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="batchStatus" class="alert-danger"/>
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