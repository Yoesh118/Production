<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Citys List
        </div>
        <div class="panel-body">
            <a href="../index.htm">Option Tables</a> | <a href="city.form">New City</a> | <a href="city.list">City List</a>
            <hr/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Name</th>
                        <th>Description</th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Name</th>
                        <th>Description</th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="city" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="city.form?id=${city.id}"/>">${city.name}</a></td>
                                    <td><a href="<c:url value="city.form?id=${city.id}"/>">${city.description}</a></td>
                                    <td>
                                        <a href="<c:url value="city.form?id=${city.id}"/>">Edit | </a>
                                        <a href="<c:url value="city.delete?id=${city.id}"/>">Delete</a>
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