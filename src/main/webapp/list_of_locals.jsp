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
                            <th><spring:message code="is.rented"/></th>
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
                                <td><c:choose><c:when test="${local.isRented}"><spring:message
                                        code="yes"></spring:message></c:when><c:otherwise><spring:message
                                        code="no"></spring:message></c:otherwise></c:choose></td>
                                <c:choose><c:when test="${local.isRented}"></c:when><c:otherwise>
                                </c:otherwise></c:choose>
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
