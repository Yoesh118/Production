<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                  <a href="../index.htm">Option Tables</a> | <a href="customerLevel.form">New Customer Level</a> | <a href="customerLevel.list">Customer Level List</a>
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="customerLevelId"/>
                            <%@include file="../template/formState.jspf" %>
                            <div class="form-group">
                                       <label>Level Name</label>
                                <form:input path="name" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="name" class="alert-danger"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                       <label>Level Description</label>
                                <form:textarea path="description" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="description" class="alert-danger"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                       <label>Level privileges </label>
                                <form:input path="privilege" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="privilege" class="alert-danger"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                       <label>Level Discount</label>
                                <form:input path="discount" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="discount" class="alert-danger"/>
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

