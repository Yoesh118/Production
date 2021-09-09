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
                        <form:form modelAttribute="workOrder">
                            <form:hidden path="workOrderId"/>


                            <%--  <div class="form-group">
                                <label> Customer Name </label>
                                <form:select path="customer" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${customer}" itemValue="code" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="customer" class="alert-danger"/>
                                </p>
                            </div> --%>

                            <div class="form-group">
                                <label> Customer Name </label>
                                <form:select path="customers" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${customers}" itemValue="customersId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="customers" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label> Customer Contact </label>
                                <form:select path="customerContact" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${customers}" itemValue="customersId" itemLabel="contactDetails"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="customers" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label>Order Date</label>
                                <form:input path="dateOrdered" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="dateOrdered" class="alert-danger"/>
                                </p>
                            </div>  

                            <div class="form-group">
                                <label> Batch Status </label>
                                <form:select path="batchStatus" class="form-control">
                                    <form:option value="" label="--Select Item"/>
                                    <form:options items="${batchStatus}" itemValue="batchStatusId" itemLabel="name"/>
                                </form:select>
                                <p class="help-block">
                                    <form:errors path="batchStatus" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Collection Date</label>
                                <form:input path="collectionDate" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="collectionDate" class="alert-danger"/>
                                </p>
                            </div>    

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
                                <label>Quantity</label>
                                <form:input path="quantity" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="quantity" class="alert-danger"/>
                                </p>
                            </div> 
                            <div class="form-group">
                                <label>Cost</label>
                                <form:input path="cost" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="cost" class="alert-danger"/>
                                </p>
                            </div> 
                            <div id="parentElement" class="row text-right">
                                <label>Add another input line</label>
                                <button onclick="addInputLine()" name="addInputLine" class="btn btn-default" ><span class="fa fa-plus"></span></button>
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
    $("#dateOrdered").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy'
    });
    $("#initialPaymentDate").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'dd/mm/yy'
    });

    $("select#product").change(function () {
        $this = $(this);
        $("#productNo").val($this.val());
    });
    
    $("select#customers").change(function () {
        $this = $(this);
        $("#customerContact").val($this.val());
    });
    function addInputLine() {
        var node = document.createElement("input");                 // Create an <input> node                         
        document.getElementById("product").appendChild(node);     // Append it to the parent
    }
</script>