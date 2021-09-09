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
                                    <a href="${page}/workOrder/" title="Manage Work Order">Manage Work Order</a>
                                </td>
<td>
                                    <a href="${page}/productRequirements/" title="Manage Product Requirements">Manage Product Requirements</a>
                                </td>
                                <td>
                                    <a href="${page}/admincap/index" title="Manage Capacity Plan">Capacity Plan</a>
                                </td>
                            </tr>
                            <tr>
                                 <td>
                                    <a href="${page}/processPlan/" title="Manage Process Plan">Manage Process Plan</a>
                                </td>
<td>
                                    <a href="${page}/clientMaintanance/" title="Manage Product Maintanance">Manage Client Maintanance</a>
                                </td>
                                <td>
                                    <a href="${page}/assetMaintanance/" title="Manage Asset Maintanance">Manage Asset Maintanance</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
                                            
<div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Manage Production Data
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table width="100%" class="table table-bordered">
                        <tbody>
                            <tr>
                                 <td>
                                    <a href="${page}/product/" title="Manage Product">Product</a>
                                </td>
                                <td>
                                    <a href="${page}/productBatch/" title="Manage Product Batch">Manage Product Batch</a>
                                </td>
                                <td>
                                    <a href="${page}/employee/" title="Manage Employee">Manage Employee</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/material/" title="Manage Material">Manage Material</a>
                                </td>
                                <td>
                                    <a href="${page}/tools/" title="Manage Tools">Manage Tools</a>
                                </td>
                                <td>
                                    <a href="${page}/machinery/" title="Manage Machinery">Manage Machinery</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/productWarehouse/" title="Manage Warehouse">Manage Warehouse</a>
                                </td>
                                 <td>
                                    <a href="${page}/processingPlant/" title="Manage Processing Plant">Manage Processing Plant</a>
                                </td>
                                 <td>
                                    <a href="${page}/productionCost/" title="Manage  Production Cost">Manage  Production Cost</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/finishedProducts/" title="Manage Finished Products">Manage Finished Products</a>
                                </td>
                                  <td>
                                    <a href="${page}/workIncident/" title="Manage workIncident">Manage Work Incident</a>
                                </td>
                                 <td>
                                    <a href="${page}/batchStatus/" title="Manage Batch Status">Manage Batch Status</a>
                                </td>
                            </tr>
                             <tr>
                                <td>
                                    <a href="${page}/productionTeam/" title="Manage Production Team">Manage Production Team</a>
                                </td>
                                <td>
                                    <a href="${page}/customers/" title="Manage Customers">Manage Customers</a>
                                </td>
                                <td>
                                    <a href="${page}/customerLevel/" title="Manage Customer Level">Manage Customer Level</a>
                                </td>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</form:form>
<%@include file="../template/footer.jspf" %>