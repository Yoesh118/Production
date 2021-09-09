<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <a href="../adminpro/index.htm">Option Tables</a> | <a href="finishedProducts.form">New Finished Product</a> | <a href="finishedProducts.list">Finished Product List</a><br/><br/>
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="finishedProductsId"/>
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
                                <label> Product No</label>
                                <form:select path="productNo" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${product}" itemValue="productId" itemLabel="productNo"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="product" class="alert-danger"/>
                                </p>
                            </div>
                                
                            <div class="form-group">
                                <label>Order No</label>
                                <form:input path="orderNo" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="orderNo"/>
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

<script type="text/javascript">
    $("select#product").change(function () {
    $this = $(this);
    $("#productNo").val($this.val());
});

</script>