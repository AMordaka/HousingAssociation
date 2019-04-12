<%@include file="head.jsp" %>
<body id="page-top">
<%@include file="user_dropdown_section.jsp" %>
<div id="wrapper">
    <%@include file="slidebar_section.jsp" %>
    <div id="content-wrapper">
        <div class="container-fluid">
            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="/">Dashboard</a>
                </li>
                <li class="breadcrumb-item active"><spring:message code="local.list"></spring:message></li>
            </ol>
        </div>
        <!-- /.container-fluid -->


        <div class="card mb-3">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th><spring:message code="number"/></th>
                            <th><spring:message code="is.housing"/></th>
                            <th><spring:message code="surface.area"/></th>
                            <th><spring:message code="building"/></th>
                            <sec:authorize access="hasRole('ADMIN')">
                                <th><spring:message code="is.rented"/></th>
                            </sec:authorize>
                            <sec:authorize access="hasAnyRole('USER','EMPLOYEE')">
                                <th><spring:message code="options"/></th>
                            </sec:authorize>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${locals}" var="local">
                            <tr>
                                <td>${local.number}</td>
                                <td><c:choose><c:when test="${local.isHousing}"><spring:message
                                        code="yes"></spring:message></c:when><c:otherwise><spring:message
                                        code="no"></spring:message></c:otherwise></c:choose></td>
                                <td>${local.surfaceArea}</td>
                                <td>${local.building}</td>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <td><c:choose><c:when test="${local.isRented}"><spring:message
                                            code="yes"></spring:message></c:when><c:otherwise><spring:message
                                            code="no"></spring:message></c:otherwise></c:choose></td>
                                </sec:authorize>
                                <sec:authorize access="hasRole('EMPLOYEE')">
                                    <td>
                                        <c:choose><c:when test="${local.isChargesFilled}">
                                            <a href="confirmCharge-${local.id}"
                                               class="btn btn-secondary btn-block"><spring:message
                                                    code="confirm"></spring:message></a></c:when></c:choose>
                                        <c:choose><c:when test="${local.isChargesAccepted}"><a
                                                href="generatePdf-${local.id}"
                                                class="btn btn-success btn-block"><spring:message
                                                code="generate.pdf"></spring:message></a></c:when></c:choose>

                                    </td>
                                </sec:authorize>
                                <sec:authorize access="hasRole('USER')">
                                    <c:choose><c:when test="${local.canFillCharges}">
                                        <td><a href="charge-${local.id}"
                                               class="btn btn-secondary btn-block"><spring:message
                                                code="fill"></spring:message></a></td>
                                    </c:when></c:choose>

                                </sec:authorize>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Sticky Footer -->
<footer class="sticky-footer">
    <div class="container my-auto">
        <div class="copyright text-center my-auto">
            <span>Copyright © Na Wspólnej 2019</span>
        </div>
    </div>
</footer>

</div>
<!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->
<%@include file="logout.jsp" %>
</body>
</html>
