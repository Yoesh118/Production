<%@include file="template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <%@include file="template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-12"> 
                        <%@include file="template/searchDistrictFragment.jspf" %>
                    </div>
                </div> 
                <div class="row">
                    <div class="col-lg-12">
                        <%@include file="template/employeeList.jspf" %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%@include file="template/footer.jspf" %>