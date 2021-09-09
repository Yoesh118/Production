<%@include file="../template/header.jspf" %>
<form:form commandName="item">
    <legend style="color: green">Administrator Dash Board</legend> 

    
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Manage Companies
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table width="100%" class="table table-bordered">
                        <tbody>
                            <tr>                                
                                <td>
                                    <a href="${page}/admin/companyStatus/" title="Manage Company Status">Manage Company Status</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/companyType/" title="Manage Company Type">Manage Company Type</a>
                                </td>
                            </tr>                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Manage Employee Data
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table width="100%" class="table table-bordered">
                        <tbody>
                            <tr>
                                <td>
                                    <a href="${page}/admin/city/" title="Manage City">Manage Cities</a>
                                </td>

                                <td>
                                    <a href="${page}/admin/nationality/" title="Manage Nationality">Manage Nationality</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/employeeStatus/" title="Manage Employee Status">Manage Employee Status</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/admin/employmentCategory/" title="Manage Employment Category">Manage Employment Category</a>
                                </td>

                                <td>
                                    <a href="${page}/admin/employmentType/" title="Manage Employment Type">Manage Employment Type</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/leaveStatus/" title="Manage Leave Status">Manage Leave Status</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/admin/notch/" title="Manage Notches">Manage Employee Notches</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/loan/" title="Manage Loans">Manage Employee Loans</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/rating/" title="Manage Ratings">Manage Employee Ratings</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>


    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Manage Station Data
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table width="100%" class="table table-bordered">
                        <tbody>
                            <tr>
                                <td>
                                    <a href="${page}/admin/period/" title="Manage Period">Manage Employee Period</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/supportingDocument/" title="Manage Supporting Documents">Supporting Document</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/qualification/" title="Manage Qualifications">Manage Qualification</a>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <a href="${page}/admin/leaveType/" title="Manage Leave Type">Manage Leave Type</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/misconductType/" title="Manage Misconduct Type">Misconduct Type</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/employeeStatusChangeReason/" title="Manage Change Reasons">Status Change Reasons</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/admin/accountType/" title="Manage Account Type">Manage Account Type</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/benefit/" title="Manage Benefits">Manage Employee Benefits</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/grade/" title="Manage Grades">Manage Employee Grades</a>
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>  

    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Manage Person Data
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table width="100%" class="table table-bordered">
                        <tbody>
                            <tr>
                                <td>
                                    <a href="${page}/admin/department/" title="Manage Department">Manage Employee Department</a>
                                </td>

                                <td>
                                    <a href="${page}/admin/district/" title="Manage District">Manage Employee District</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/country/" title="Manage Country">Manage Employee Country</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/admin/institution/" title="Manage Institution">Manage Employee Institution</a>
                                </td>

                                <td>
                                    <a href="${page}/admin/post/" title="Manage Post">Manage Employee Post</a>            
                                </td>
                                <td>
                                    <a href="${page}/admin/province/" title="Manage Province">Manage Employee Province</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/admin/station/" title="Manage Stations">Manage Employee Stations</a>            
                                </td>

                                <td>
                                    <a href="${page}/admin/stationCategory/" title="Manage Station Category">Manage Station Category</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/stationEstablishment/">Manage Station Establishment</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>                        

    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Manage Demographic Data
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table width="100%" class="table table-bordered">
                        <tbody>
                            <tr>
                                <td>
                                    <a href="${page}/admin/addressType/" title="Manage Address Types">Employee Address Type</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/contactType/" title="Manage Contact Type">Manage Contact Type</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/nationality/" title="Manage Nationality">Manage Nationality</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/admin/maritalStatus/" title="Manage Marital Status">Employee Marital Status</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/citizenship/" title="Manage Citizenship">Manage Citizenship</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/identityType/" title="Manage Identity Type">Manage Identity Type</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${page}/admin/relationship/" title="Manage Relationship">Employee Relationship</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/title/" title="Manage Title">Manage Employee Title</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/caseOutcome/" title="Manage Case Outcomes">Manage Case Outcomes</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>                        

    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Manage User Data
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table width="100%" class="table table-bordered">
                        <tbody>
                            <tr>
                                <td>
                                    <a href="${page}/admin/user/">Manage System User</a> 
                                </td>
                                <td>
                                    <a href="${page}/admin/userRole/">Manage User Role</a>
                                </td>
                                <td>
                                    <a href="${page}/admin/privilege/">Manage User Privileges</a>  
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>                        

</form:form>
<%@include file="../template/footer.jspf" %>