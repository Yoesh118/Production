<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            CompanyType List
        </div>
        <div class="panel-body">
            <a href="../index.htm">Option Tables</a> | <a href="companyType.form">New CompanyType</a> | <a href="companyType.list">CompanyType List</a><br/><br/>
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
                            <c:forEach var="companyType" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="companyType.form?id=${companyType.id}"/>">${companyType.name}</a></td>
                                  
                                    <td>
                                        <a href="<c:url value="companyType.form?id=${companyType.id}"/>">Edit | </a>
                                        <a href="<c:url value="companyType.delete?id=${companyType.id}"/>">Delete</a>
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