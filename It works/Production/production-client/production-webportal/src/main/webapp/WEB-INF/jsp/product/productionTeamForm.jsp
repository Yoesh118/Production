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
                        <form:form modelAttribute="productionTeam">
                            <form:hidden path="productionTeamId"/>
                            <div class="form-group">
                                <label>Name</label>
                                <form:input path="productionTeamName" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="productionTeamName" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Team No</label>
                                <form:input path="teamNo" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="teamNo" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Team Description</label>
                                <form:input path="productionTeamDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="productionTeamDescription" class="alert-danger"/>
                                </p>
                            </div>  
                            <div class="form-group">
                                <label>Team Members</label>
                                <form:textarea path="productionTeamMembers" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="productionTeamMembers" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Team Status</label><br/>
                                <form:radiobutton path="status" label="Active" value="true"/>
                                <form:radiobutton path="status" label="In Active" value="false"/>
                            </div>
                            <div class="form-group">
                                <label>Time till free</label>
                                <form:input path="timeTillFree" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="timeTillFree" class="alert-danger"/>
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