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
                        <form:form modelAttribute="processingPlant">
                            <form:hidden path="processingPlantId"/>
                            <div class="form-group">
                                <label>Plant Name</label>
                                <form:input path="processingPlantName" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="processingPlantName" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Plant Location</label>
                                <form:input path="processingPlantLocation" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="processingPlantLocation" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Plant Functionality Status</label>
                                <form:input path="functionality" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="functionality" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Plant Capacity</label>
                                <form:input path="capacity" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="capacity" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Plant Description</label>
                                <form:input path="processingPlantDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="processingPlantDescription" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Plant Capacity Status</label>
                                <form:input path="capacityStatus" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="capacityStatus" class="alert-danger"/>
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