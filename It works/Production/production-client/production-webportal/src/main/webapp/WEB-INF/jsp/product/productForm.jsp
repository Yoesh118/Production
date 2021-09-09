<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                 <a href="../adminpro/index.htm">Option Tables</a> | <a href="product.form">New Product</a> | <a href="product.list">Product List</a>
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="productId"/>
                            <%@include file="../template/formState.jspf" %>
                            <div class="form-group">
                                       <label>Name</label>
                                <form:input path="name" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="name" class="alert-danger"/>
                                </p>
                            </div>
                           
                                <div class="form-group">
                                <label>Description</label>
                                <form:textarea path="description" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="description"/>
                                </p>
                            </div>
                            
                             <div class="form-group">
                                <label>Id</label>
                                <form:input path="productNo" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="productNo"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                <label>Team Status</label><br/>
                                <form:radiobutton path="status" label="In Stock" value="true"/>
                                <form:radiobutton path="status" label="Out Of Stock" value="false"/>
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




