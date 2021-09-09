<%@include file="../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <a href="../index.htm">Option Tables</a> | <a href="suppliers.form">New Supplier</a> | <a href="suppliers.list">Supplier List</a>
                <%@include file="../template/message.jspf" %>
                <div class="row">
                    <div class="col-lg-10">
                        <form:form commandName="item">
                            <form:hidden path="version"/>
                            <form:hidden path="suppliersId"/>
                            <%@include file="../template/formState.jspf" %>
                            <div class="form-group">
                                <label>Supplier Name</label>
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
                                <label>Supplier Address</label>
                                <form:input path="suppliersAddress" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="suppliersAddress" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label>Bank Details</label>
                                <form:input path="bankDetails" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="bankDetails" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label>Supplier Company Nationality</label>
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
                                <label>Number of Orders</label>
                                <form:input path="orders" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="orders" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label>Loyalty Benefits</label>
                                <form:input path="loyaltyBenefits" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="loyaltyBenefits" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label>Loyalty Discount</label>
                                <form:input path="loyaltyDiscount" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="loyaltyDiscount" class="alert-danger"/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label>Supplier Status</label><br/>
                                <form:radiobutton path="status" label="Alternative" value="true"/>
                                <form:radiobutton path="status" label="Default" value="false"/>
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
