<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Batch Status List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="batchStatus.form">New Batch Status</a> | <a href="batchStatus.list">Batch Status List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Name</th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Name</th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="batchStatus" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="batchStatus.form?id=${batchStatus.batchStatusId}"/>">${batchStatus.name}</a></td>
                                  
                                    <td>
                                        <a href="<c:url value="batchStatus.form?id=${batchStatus.batchStatusId}"/>">Edit | </a>
                                        <a href="<c:url value="batchStatus.delete?id=${batchStatus.batchStatusId}"/>">Delete</a>
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