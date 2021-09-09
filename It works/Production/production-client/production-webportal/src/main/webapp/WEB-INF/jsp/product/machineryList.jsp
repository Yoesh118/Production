<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Machinery List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="machinery.form">New Machinery</a> | <a href="machinery.list">Machinery List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Name</th>
                        <th>Machine No</th>
                        <th>Description</th>
                        <th>Capacity</th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Name</th>
                        <th>Machine No</th>
                        <th>Description</th>
                        <th>Capacity</th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="machinery" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="machinery.form?id=${machinery.machineryId}"/>">${machinery.name}</a></td>
                                    <td>${machinery.machineNo}</td>
                                    <td>${machinery.description}</td>
                                    <td>${machinery.machineCapacity}</td>
                                    <td>
                                        <a href="<c:url value="machinery.form?id=${machinery.machineryId}"/>">Edit | </a>
                                        <a href="<c:url value="machinery.delete?id=${machinery.machineryId}"/>">Delete</a>
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