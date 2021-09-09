<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <a href="../index.htm">Option Tables</a> | <a href="customers.form">New Customer </a> | <a href="customers.list">Customer  List</a>
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="customersId"/>
                            <%@include file="../template/formState.jspf" %>
                            <div class="form-group">
                                <label>Customer Name</label>
                                <form:input path="name" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="name" class="alert-danger"/>
                                </p>
                            </div>
                            
                            <div class="form-group">
                                <label>Phone Number</label>
                                <form:input path="contactDetails" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="contactDetails" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Customer Address</label>
                                <form:input path="customersAddress" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="customersAddress" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label> Nationality </label>
                                 <form:input path="nationality" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="nationality" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Years of Service</label>
                                <form:input path="years" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="years" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Order Numbers</label>
                                <form:input path="orders" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="orders" class="alert-danger"/>
                                </p>
                            </div>
                                                               <div class="form-group">
                                <label> Customer Level </label>
                                <form:select path="customerLevel" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${customerLevel}" itemValue="customerLevelId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="customerLevel" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label> Loyalty Discount </label>
                                <form:select path="loyaltyDiscount" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${customerLevel}" itemValue="customerLevelId" itemLabel="discount"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="customerLevel" class="alert-danger"/>
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


<script>
    
</script>
<script type="text/javascript">

    $("select#customerLevel").change(function () {
        $this = $(this);
        $("#loyaltyDiscount").val($this.val());
    });
    
    $("#nationality").countrypicker({ defaultCountry: "us"});
</script>

