<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Finished Products List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="finishedProducts.form">New Finished Product</a> | <a href="finishedProducts.list">Finished Products List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Name</th>
                        <th>Product No</th>
                        <th> Order No </th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Name</th>
                        <th>Product No</th>
                        <th> Order No </th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="finishedProducts" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="finishedProducts.form?id=${finishedProducts.finishedProductsId}"/>">${finishedProducts.product}</a></td>
                                    <td><a href="<c:url value="finishedProducts.form?id=${finishedProducts.finishedProductsId}"/>">${finishedProducts.product.productNo}</a></td>
                                    <td><a href="<c:url value="finishedProducts.form?id=${finishedProducts.finishedProductsId}"/>">${finishedProducts.orderNo}</a></td>
                                  
                                    <td>
                                        <a href="<c:url value="finishedProducts.form?id=${finishedProducts.finishedProductsId}"/>">Edit | </a>
                                        <a href="<c:url value="finishedProducts.delete?id=${finishedProducts.finishedProductsId}"/>">Delete</a>
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