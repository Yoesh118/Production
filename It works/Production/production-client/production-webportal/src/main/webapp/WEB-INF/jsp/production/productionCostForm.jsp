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
                        <form:form modelAttribute="company">
                            <form:hidden path="companyId"/>
                            <div class="form-group">
                                <label>Name</label>
                                <form:input path="name" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="name" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Company No</label>
                                <form:input path="companyNo" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="companyNo" class="alert-danger"/>
                                </p>
                            </div>    



                            <div class="form-group">
                                <label>Balance</label>
                                <form:input path="balance" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="balance" class="alert-danger"/>
                                </p>
                            </div>  
                            <div class="form-group">
                                <label>Credit Limit</label>
                                <form:input path="creditLimit" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="creditLimit" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Primary Contact</label>
                                <form:input path="contact" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="contact" class="alert-danger"/>
                                </p>
                            </div>    
                            <div class="form-group">
                                <label>Currency</label>
                                <form:input path="currency" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="currency" class="alert-danger"/>
                                </p>
                            </div>    

                            <div class="form-group">
                                <label>Start Date</label>
                                <form:input path="startDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="startDate" class="alert-danger"/>
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