<%@include file="../template/header.jspf" %>
<form:form commandName="item">
    <legend style="color: green">Production Dash Board</legend> 

    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Manage Production Processes
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table width="100%" class="table table-bordered">
                        <tbody>
                            <tr>
                                <td>
                                    <a href="${page}/productWarehouse/" title="Manage Warehouse">Manage Warehouse</a>
                                </td>
                                <td>
                                    <a href="${page}/processingPlant/" title="Manage Processing Plant">Manage Processing Plant</a>
                                </td>
                                <td>
                                    <a href="${page}/productRequirements/" title="Manage Product Requirements">Manage Product Requirements</a>
                                </td>

                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</form:form>
<%@include file="../template/footer.jspf" %>