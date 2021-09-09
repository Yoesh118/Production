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
                        <form:form modelAttribute="assetMaintanance">
                            <form:hidden path="assetMaintananceId"/>
                            <div class="form-group">
                                <label>Item to maintain</label>
                                <form:input path="assetMaintananceProduct" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="assetMaintananceProduct" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Problem Description</label>
                                <form:input path="assetMaintananceDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="assetMaintananceDescription" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Company Maintaining</label>
                                <form:input path="maintananceCompany" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="maintananceCompany" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Maintanance Cost</label>
                                <form:input path="cost" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="cost" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Company Address</label>
                                <form:input path="companyAddress" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="companyAddress" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Company Bank Details</label>
                                <form:input path="companyBankDetails" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="companyBankDetails" class="alert-danger"/>
                                </p>
                            </div>  
                            <div class="form-group">
                                <label> Maintainance Status </label>
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