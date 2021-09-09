<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Product Requirements List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="productRequirements.form">New Product Requirement</a> | <a href="productRequirements.list">Product Requirements List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Product Name</th>
                        <th>Requirements</th>
                        <th>Qty</th>
                        <th>Cost</th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Product Name</th>
                        <th>Requirements</th>
                        <th>Qty</th>
                        <th>Cost</th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="productRequirements" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="productRequirements.form?id=${productRequirements.productRequirementsId}"/>">${productRequirements.product}</a></td>
                                    <td>${productRequirements.productRequirementsDescription}</td>
                                    <td>${productRequirements.qty}</td>
                                    <td>${productRequirements.cost}</td>
                                    <td>
                                        <a href="<c:url value="productRequirements.form?id=${productRequirements.productRequirementsId}"/>">Edit | </a>
                                        <a href="<c:url value="productRequirements.delete?id=${productRequirements.productRequirementsId}"/>">Delete</a>
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