<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Maintanance Team List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="maintananceTeam.form">New Maintanance Team</a> | <a href="maintananceTeam.list">Maintanance Team List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Team Name</th>
                        <th>Team No</th>
                        <th>Team Members</th>
                        <th>Team Description</th>
                        <th>Time Till Free</th>
                        <th>Team Status</th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Team Name</th>
                        <th>Team No</th>
                        <th>Team Members</th>
                        <th>Team Description</th>
                        <th>Time Till Free</th>
                        <th>Team Status</th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="maintananceTeam" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="maintananceTeam.form?id=${maintananceTeam.maintananceTeamId}"/>">${maintananceTeam.name}</a></td>
                                    <td>${maintananceTeam.teamNo}</td>
                                    <td>${maintananceTeam.maintananceTeamMembers}</td>
                                    <td>${maintananceTeam.maintananceTeamDescription}</td>
                                    <td>${maintananceTeam.timeTillFree}</td>
                                    <td>${maintananceTeam.preferred}</td>
                                    <td>
                                        <a href="<c:url value="maintananceTeam.form?id=${maintananceTeam.maintananceTeamId}"/>">Edit | </a>
                                        <a href="<c:url value="maintananceTeam.delete?id=${maintananceTeam.maintananceTeamId}"/>">Delete</a>
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