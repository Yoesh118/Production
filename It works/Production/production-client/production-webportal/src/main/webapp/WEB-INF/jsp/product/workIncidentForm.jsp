<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <a href="../index.htm">Option Tables</a> | <a href="workIncident.form">New Work Incident</a> | <a href="workIncident.list">Work Incident List</a><br/><br/>
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="workIncidentId"/>
                            <%@include file="../template/formState.jspf" %>
                            <div class="form-group">
                                <label>Name</label>
                                <form:input path="workIncidentName" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="workIncidentName" class="alert-danger"/>
                                </p>
                            </div>
                           
                            <div class="form-group">
                                <label>Description</label>
                                <form:textarea path="workIncidentDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="workIncidentDescription"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                <label>Date of Occurrence </label>
                                <form:input path="date" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="date"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                <label> Repair Status </label>
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

<script type="text/javascript">
    $("#date").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy',
        yearRange: general
    });
</script>