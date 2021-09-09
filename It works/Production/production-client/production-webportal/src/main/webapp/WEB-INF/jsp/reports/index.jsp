<%@include file="../template/header.jspf" %>
<form:form commandName="item">
    <legend style="color: green">Reports Dash Board</legend> 
    <div class="panel panel-default">
        <div class="panel-heading">
            Employees Reports By Criteria
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table width="100%" class="table table-bordered">
                    <tbody>
                        <tr>
                            <td>
                                <a href="${page}/getPDF">All Employees</a>
                            </td>
                            <td>
                                <a href="${page}/getPDF">Employees Leave</a> 
                            </td>

                            <td>
                                <a href="${page}/getPDF">Leave Cross Tabulation</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>                     
</form:form>
<%@include file="../template/footer.jspf" %>
