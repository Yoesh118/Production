<%@include file="../../template/header.jspf" %>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${pageTitle}
            </div>
            <div class="panel-body">
                <%@include file="../../template/message.jspf" %>
                <%@include file="../../template/benefitStation.jspf" %>
                <div class="row">
                    <div class="col-lg-12">
                        <table id="tableList" class="display" cellspacing="0">
                            <thead>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Type</th>
                            <th>Department</th>
                            <th>Station</th>
                            <th>Awarded</th>
                            <th>Benefit</th>
                            </thead>
                            <tfoot>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Type</th>
                            <th>Department</th>
                            <th>Station</th>
                            <th>Awarded</th>
                            <th>Benefit</th>
                            </tfoot>
                            <tbody>
                                <c:forEach var="ben" items="${items}" >
                                    <tr>
                                        <td>${ben.employee.fullname}</td>
                                        <td>${ben.employee.employmentCategory.name}</td>
                                        <td>${ben.employee.employmentType.name}</td>
                                        <td>${ben.employee.department.name}</td>
                                        <td>${ben.employee.station.name}</td>
                                        <td>${ben.dateAwarded}</td>
                                        <td>${ben.benefit.name}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!--Export panels here -->
                <c:if test="${items.size() >= 1}">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel-footer" style="text-align: right">
                                Export/ View As
                                <a href="${page}${excelExport}">
                                    <img src="<c:url value="/resources/images/excel.jpeg"/>" id="excelExport"/>
                                </a>| &nbsp; 
                                <%--    <a href="${page}${wordExport}">
                                    <img src="<c:url value="/resources/images/wrd.jpeg"/>" id="wordExport"/>
                                </a> --%>| &nbsp; 
                                <a href="${page}${pdfExport}">
                                    <img src="<c:url value="/resources/images/pdf.png"/>"  id="pdfExport"/>
                                </a> | &nbsp;
                                <a href="${page}${emailExport}">
                                    <img src="<c:url value="/resources/images/email.jpeg"/>"/>
                                </a> 
                            </div>
                        </div>
                    </div> 
                </c:if>
            </div>
        </div>
    </div>
</div>
</div>
<%@include file="../../template/footer.jspf" %>
<script type="text/javascript">
    $("#employmentCategory").change(function () {
        $("form").submit();
    });
    $("#employmentType").change(function () {
        $("form").submit();
    });
    $("#department").change(function () {
        $("form").submit();
    });
    $("#station").change(function () {
        $("form").submit();
    });
    $("#dateAwarded").change(function (e) {
        $("form").submit();
    });
    $("#benefit").change(function () {
        $("form").submit();
    });

</script>