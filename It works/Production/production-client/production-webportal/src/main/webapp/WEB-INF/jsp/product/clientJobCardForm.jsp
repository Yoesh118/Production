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
                        <form:form modelAttribute="clientJobCard">
                            <form:hidden path="clientJobCardId"/>
                            <div class="form-group">
                                <label>Client Name</label>
                                <form:input path="name" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="name" class="alert-danger"/>
                                </p>
                            </div>
                                 <div class="form-group">
                                <label>Date</label>
                                <form:input path="currentDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="currentDate" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Job Description</label>
                                <form:textarea path="currentJob" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="currentJob" class="alert-danger"/>
                                </p>
                            </div>
                                 <div class="form-group">
                                <label>Last Time Maintained (Date)</label>
                                <form:input path="lastMaintained" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="lastMaintained" class="alert-danger"/>
                                </p>
                            </div>
                               
                                <div class="form-group">
                                <label>Start Date</label>
                                <form:input path="startDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="startDate" class="alert-danger"/>
                                </p>
                            </div>
                                <div class="form-group">
                                <label>Estimated Stop Date</label>
                                <form:input path="estimatedStopDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="estimatedStopDate" class="alert-danger"/>
                                </p>
                            </div>
                                
                                <div class="form-group">
                                <label>Maintenance Team</label>
                                <form:select path="maintananceTeam" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${maintananceTeam}" itemValue="maintananceTeamId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="maintananceTeam" class="alert-danger"/>
                                </p>
                            </div>
                               
                                <div class="form-group">
                                <label>Previous Maintenance Description</label>
                                <form:input path="priorAssessment" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="priorAssessment" class="alert-danger"/>
                                </p>
                            </div>
                                <div class="form-group">
                                <label>Previous Assessor Name</label>
                                <form:input path="priorName" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="priorName" class="alert-danger"/>
                                </p>
                            </div>
                                <div class="form-group">
                                <label>Previous Job Done</label>
                                <form:input path="priorJob" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="priorJob" class="alert-danger"/>
                                </p>
                            </div>
                               <div class="form-group">
                                <label>Card Status</label><br/>
                                <form:radiobutton path="status" label="Complete" value="true"/>
                                <form:radiobutton path="status" label="InComplete" value="false"/>
                            </div>
                                    <div class="form-group">
                                <label>Delay Time(optional if there is a delay)</label>
                                <form:input path="delayTime" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="delayTime" class="alert-danger"/>
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