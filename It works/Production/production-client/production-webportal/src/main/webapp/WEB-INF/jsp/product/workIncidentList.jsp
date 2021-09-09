<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Work Incident List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="workIncident.form">New Work Incident</a> | <a href="workIncident.list">Work Incident List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Date of Occurrence </th>
                        <th>Repair Status </th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Date of Occurrence </th>
                        <th>Repair Status </th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="workIncident" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="workIncident.form?id=${workIncident.workIncidentId}"/>">${workIncident.workIncidentName}</a></td>                   
                                    <td>${workIncident.workIncidentDescription}</td>
                                    <td>${workIncident.date}</td>
                                    <td>${workIncident.batchStatus}</td>
                                    <td>
                                        <a href="<c:url value="workIncident.form?id=${workIncident.workIncidentId}"/>">Edit | </a>
                                        <a href="<c:url value="workIncident.delete?id=${workIncident.workIncidentId}"/>">Delete</a>
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