<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Customer Level List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="customerLevel.form">New Customer Level</a> | <a href="customerLevel.list">Customer Level List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Level Name</th>
                        <th>Level Description</th>
                        <th>Level Privileges</th>
                        <th>Level Discount</th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                         <th>Level Name</th>
                        <th>Level Description</th>
                        <th>Level Privileges</th>
                        <th>Level Discount</th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="customerLevel" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="customerLevel.form?id=${customerLevel.customerLevelId}"/>">${customerLevel.name}</a></td>
                                    <td>${customerLevel.description}</td>
                                    <td>${customerLevel.privilege}</td>
                                    <td>${customerLevel.discount}</td>
                                    <td>
                                        <a href="<c:url value="customerLevel.form?id=${customerLevel.customerLevelId}"/>">Edit | </a>
                                        <a href="<c:url value="customerLevel.delete?id=${customerLevel.customerLevelId}"/>">Delete</a>
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