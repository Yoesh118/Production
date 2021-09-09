<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form modelAttribute="material">
                            <form:hidden path="materialId"/>
                            <div class="form-group">
                                <label>Name</label>
                                <form:input path="name" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="name" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Material Description</label>
                                <form:input path="materialDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="materialDescription" class="alert-danger"/>
                                </p>
                            </div>    
                            <div class="form-group">
                                <label>Material Cost</label>
                                <form:input path="materialCost" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="materialCost" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Material Quantity</label>
                                <form:input path="quantity" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="quantity" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Procurement Company</label>
                                <form:input path="companyName" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="companyName" class="alert-danger"/>
                                </p>
                            </div>  
                           <div class="form-group">
                                <label>Contact Details</label>
                                <form:input path="contactDetails" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="contactDetails" class="alert-danger"/>
                                </p>
                            </div>
                           <div class="form-group">
                                <label>Company Address</label>
                                <form:input path="companyAddress" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="companyAddress" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit">Save</button>
                                <a href="${itemDelete}"><button class="btn btn-primary" type="button">Cancel</button></a>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../template/footer.jspf" %>