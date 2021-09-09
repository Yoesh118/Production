<%@include file="../template/header.jspf" %>
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            CompanyStatus List
        </div>
        <div class="panel-body">
            <a href="../index.htm">Option Tables</a> | <a href="companyStatus.form">New CompanyStatus</a> | <a href="companyStatus.list">CompanyStatus List</a><br/><br/>
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
                            <c:forEach var="companyStatus" items="${items}" >
                                <tr>
                                    <td><a href="<c:url value="companyStatus.form?id=${companyStatus.id}"/>">${companyStatus.name}</a></td>
                                  
                                    <td>
                                        <a href="<c:url value="companyStatus.form?id=${companyStatus.id}"/>">Edit | </a>
                                        <a href="<c:url value="companyStatus.delete?id=${companyStatus.id}"/>">Delete</a>
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