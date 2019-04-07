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
                <li class="breadcrumb-item active"><spring:message code="building.list"></spring:message></li>
            </ol>
        </div>
        <!-- /.container-fluid -->


        <div class="card mb-3">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th><spring:message code="buildings"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${buildings}" var="building">
                            <tr>
                                <td>
                                    <a href="<c:url value='/locals-${building.id}' />">
                                        <div> ${building.address} </div>
                                    </a>
                                </td>
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
