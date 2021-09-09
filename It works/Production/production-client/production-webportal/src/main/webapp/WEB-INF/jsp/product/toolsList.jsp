<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Tools List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="tools.form">New Tool</a> | <a href="tools.list">Tools List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Tool No</th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Tool No</th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="tools" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="tools.form?id=${tools.toolId}"/>">${tools.name}</a></td>
                                    <td>${tools.description}</td>
                                    <td>${tools.toolNo}</td>
                                  
                                    <td>
                                        <a href="<c:url value="tools.form?id=${tools.toolId}"/>">Edit | </a>
                                        <a href="<c:url value="tools.delete?id=${tools.toolId}"/>">Delete</a>
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