<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <a href="../adminpro/index.htm">Option Tables</a> | <a href="employee.form">New Employee</a> | <a href="employee.list">Employee List</a><br/><br/>
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="employeeId"/>
                            <%@include file="../template/formState.jspf" %>
                            <div class="form-group">
                                <label>Name</label>
                                <form:input path="employeeName" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="employeeName" class="alert-danger"/>
                                </p>
                            </div>
                           
                             <div class="form-group">
                                <label>Id</label>
                                <form:input path="employeeNo" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="employeeNo"/>
                                </p>
                             </div> 
                                
                             <div class="form-group">
                                <label>Qualification</label>
                                <form:input path="qualification" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="qualification"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                <label> Team No </label>
                                <form:select path="productionTeam" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="teamNo"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                <label> Team Description </label>
                                <form:select path="productionTeamDescription" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${productionTeam}" itemValue="productionTeamId" itemLabel="productionTeamDescription"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="productionTeam" class="alert-danger"/>
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
 
     $("select#productionTeam").change(function () {
    $this = $(this);
    $("#productionTeamDescription").val($this.val());
});    
</script>