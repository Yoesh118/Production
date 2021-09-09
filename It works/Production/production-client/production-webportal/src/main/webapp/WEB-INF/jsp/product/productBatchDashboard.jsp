<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div>
                <br>
            <a href="${page}/adminpro/index.htm">Option Tables</a> | <a href="${page}/productBatch/item.form">New Product</a> | <a href="${page}/productBatch/">Product List</a>
            </div>
            <div class="panel-body">
                <%@include file="../template/message.jspf" %>
                <br/>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">                            
                            <%@include file="../template/dashboard/productBatchProfile.jspf" %>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <br/>
                        <%@include file="../template/dashboard/dashboardTabs_productBatch.jspf" %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../template/footer.jspf" %>
<script type="text/javascript">
    $("#tabs").tabs();
</script>