<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Customer List
        </div>
        <div class="panel-body">
            <a href="../adminpro/index.htm">Option Tables</a> | <a href="customers.form">New Customer</a> | <a href="customers.list">Customer List</a><br/><br/>
            <%@include file="../template/message.jspf" %>
            <div class="row">
                <div class="col-lg-10">
                    <table id="tableList" class="display" cellspacing="0">
                        <thead>
                        <th>Customer Name</th>
                        <th>Phone Number</th>
                        <th>Customer Address</th>
                        <th>Nationality</th>
                        <th>Years of Service</th>
                        <th>Order Numbers</th>
                        <th>Customer Level</th>
                        <th>Loyalty Discount</th>
                        <th>&nbsp</th>
                        </thead>
                        <tfoot>
                        <th>Customer Name</th>
                        <th>Phone Number</th>
                        <th>Customer Address</th>
                        <th>Nationality</th>
                        <th>Years of Service</th>
                        <th>Order Numbers</th>
                        <th>Customer Level</th>
                        <th>Loyalty Discount</th>
                        <th>&nbsp</th>
                        </tfoot>
                        <tbody>
                            <c:forEach var="customers" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="customers.form?id=${customers.customersId}"/>">${customers.name}</a></td>
                                    <td>${customers.contactDetails}</td>
                                    <td>${customers.customersAddress}</td>
                                    <td>${customers.nationality}</td>
                                    <td>${customers.years}</td>
                                    <td>${customers.orders}</td>
                                    <td>${customers.customerLevel}</td>
                                    <td>${customers.customerLevel.discount}</td>                               
                                    <td>
                                        <a href="<c:url value="customers.form?id=${customers.customersId}"/>">Edit | </a>
                                        <a href="<c:url value="customers.delete?id=${customers.customersId}"/>">Delete</a>
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