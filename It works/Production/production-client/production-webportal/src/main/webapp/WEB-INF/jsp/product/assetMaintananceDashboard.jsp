<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <br>
            <a href="${page}/adminpro/index.htm">Option Tables</a> | <a href="${page}/assetMaintanance/item.form">New Asset</a> | <a href="${page}/assetMaintanance/">Asset Maintanance List</a>
            <div class="panel-body">
                <%@include file="../template/message.jspf" %>
                <br/>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">                            
                            <%@include file="../template/dashboard/assetMaintananceProfile.jspf" %>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <br/>
                        <%@include file="../template/dashboard/dashboardTabs_assetMaintanance.jspf" %>
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