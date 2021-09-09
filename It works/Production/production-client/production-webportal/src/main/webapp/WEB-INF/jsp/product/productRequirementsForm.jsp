<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <a href="../adminpro/index.htm">Option Tables</a> | <a href="productRequirements.form">New Product Requirements</a> | <a href="productRequirements.list">Product Requirements List</a><br/><br/>
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="productRequirementsId"/>
                            <%@include file="../template/formState.jspf" %>
                             <div class="form-group">
                                <label> Product </label>
                                <form:select path="product" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${product}" itemValue="productId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="product" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Product Requirement</label>
                                <form:input path="productRequirementsDescription" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="productRequirementsDescription" class="alert-danger"/>
                                </p>
                            </div>    
                            <div class="form-group">
                                <label>Requirement Qty</label>
                                <form:input path="qty" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="qty" class="alert-danger"/>
                                </p>
                            </div> 
                             <div class="form-group">
                                <label>Requirement Cost</label>
                                <form:input path="cost" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="cost" class="alert-danger"/>
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