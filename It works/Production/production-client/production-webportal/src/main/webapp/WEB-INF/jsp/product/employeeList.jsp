<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Employee List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="employee.form">New Employee</a> | <a href="employee.list">Employee List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Name</th>
                        <th>Id</th>
                        <th>Qualification</th>
                        <th>Team No</th>
                        <th>Team Description </th> 
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Name</th>
                        <th>Id</th>
                        <th>Qualification</th>
                        <th>Team No</th>
                        <th>Team Description </th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="employee" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="employee.form?id=${employee.employeeId}"/>">${employee.employeeName}</a></td>
                                    <td>${employee.employeeNo}</td>
                                    <td>${employee.qualification}</td>
                                    <td>${employee.productionTeam.teamNo}</td>
                                    <td>${employee.productionTeam.productionTeamDescription}</td>
                                    <td>
                                        <a href="<c:url value="employee.form?id=${employee.employeeId}"/>">Edit | </a>
                                        <a href="<c:url value="employee.delete?id=${employee.employeeId}"/>">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>

        </div>
        <div class="panel-footer">
            
        </div>
    </div>
</div>

<%@include file="../template/footer.jspf" %>