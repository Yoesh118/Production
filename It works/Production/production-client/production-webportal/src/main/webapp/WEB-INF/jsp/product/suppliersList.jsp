<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Supplier's List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="suppliers.form">New Supplier's</a> | <a href="suppliers.list">Supplier's List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Name</th>
                        <th>Phone Number </th>
                        <th>Address</th>
                        <th>Bank Details</th>
                        <th>Company Nationality</th>
                        <th>Years of Service</th>
                        <th>Number of Orders</th>
                        <th>Loyalty Benefits</th>
                        <th>Loyalty Discount</th>
                        <th>Supplier Status</th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                       <th>Name</th>
                        <th>Phone Number </th>
                        <th>Address</th>
                        <th>Bank Details</th>
                        <th>Company Nationality</th>
                        <th>Years of Service</th>
                        <th>Number of Orders</th>
                        <th>Loyalty Benefits</th>
                        <th>Loyalty Discount</th>
                        <th>Supplier Status</th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="suppliers" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="suppliers.form?id=${suppliers.suppliersId}"/>">${suppliers.name}</a></td>
                                    <td>${suppliers.contactDetails}</td>
                                    <td>${suppliers.suppliersAddress}</td>
                                    <td>${suppliers.bankDetails}</td>
                                    <td>${suppliers.nationality}</td>
                                    <td>${suppliers.years}</td>
                                    <td>${suppliers.orders}</td>
                                    <td>${suppliers.loyaltyBenefits}</td>
                                    <td>${suppliers.loyaltyDiscount}</td>
                                    <td>${suppliers.preferred}</td>
                                  
                                    <td>
                                        <a href="<c:url value="suppliers.form?id=${suppliers.suppliersId}"/>">Edit | </a>
                                        <a href="<c:url value="suppliers.delete?id=${suppliers.suppliersId}"/>">Delete</a>
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