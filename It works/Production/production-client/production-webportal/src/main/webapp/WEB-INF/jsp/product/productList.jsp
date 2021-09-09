<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Product List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="product.form">New Product</a> | <a href="product.list">Product List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Id</th>
                        <th>Stock Status</th>
                       
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Id</th>
                        <th>Stock Status</th>
                        
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="product" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="product.form?id=${product.productId}"/>">${product.name}</a></td>
                                    <td><a href="<c:url value="product.form?id=${product.productId}"/>">${product.description}</a></td>
                                    <td><a href="<c:url value="product.form?id=${product.productId}"/>">${product.productNo}</a></td>
                                    <td><a href="<c:url value="product.form?id=${product.productId}"/>">${product.preferred}</a></td>
                                  
                                    <td>
                                        <a href="<c:url value="product.form?id=${product.productId}"/>">Edit | </a>
                                        <a href="<c:url value="product.delete?id=${product.productId}"/>">Delete</a>
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