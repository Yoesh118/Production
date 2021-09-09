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
                        <form:form modelAttribute="costCard">
                            <form:hidden path="costCardId"/>
                            <div class="form-group">
                                <label>Division Name</label>
                                <form:input path="name" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="name" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Cost Description</label>
                                <form:textarea path="description" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="description" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Reason for Cost</label>
                                <form:input path="reason" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="reason" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Alternatives</label>
                                <form:input path="alternatives" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="alternatives" class="alert-danger"/>
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
                                <label>Total Cost</label>
                                <form:input path="totalCost" class="form-control"/>
                                <p class="help-block">
                                    <form:errors path="totalCost" class="alert-danger"/>
                                </p>
                            </div>
                            <div class="form-group">
                                <label>Team Status</label><br/>
                                <form:radiobutton path="status" label="Urgent" value="true"/>
                                <form:radiobutton path="status" label="Not Urgent" value="false"/>
                            </div>
                            <div class="form-group">
                                <label>Team Status</label><br/>
                                <form:radiobutton path="approved" label="Approved" value="true"/>
                                <form:radiobutton path="approved" label="Declined" value="false"/>
                            </div>

                            private boolean status = true;
                            private String ;
                            private double ;;
                            private boolean approved = true;
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