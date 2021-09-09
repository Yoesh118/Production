<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <a href="../index.htm">Option Tables</a> | <a href="maintananceTeam.form">New Maintanance Team</a> | <a href="maintananceTeam.list">Maintanance Team List</a>
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="maintananceTeamId"/>
                            <%@include file="../template/formState.jspf" %>
                            <div class="form-group">
                                <label>Team Name</label>
                                <form:input path="name" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="name" class="alert-danger"/>
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
                                <label>Team Members</label>
                                <form:input path="maintananceTeamMembers" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="maintananceTeamMembers" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Team Description</label>
                                <form:input path="maintananceTeamDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="maintananceTeamDescription" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Time till Free</label>
                                <form:input path="timeTillFree" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="timeTillFree" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label>Team Status</label><br/>
                                <form:radiobutton path="status" label="Active" value="true"/>
                                <form:radiobutton path="status" label="In Active" value="false"/>
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

