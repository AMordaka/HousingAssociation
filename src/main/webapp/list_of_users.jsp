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
                <li class="breadcrumb-item active"><spring:message code="user.list"></spring:message></li>
            </ol>
        </div>
        <!-- /.container-fluid -->

        <table class="table table-hover">
            <thead>
            <tr>
                <th><spring:message code="firstName"/></th>
                <th><spring:message code="lastName"/></th>
                <th><spring:message code="email"/></th>
                <th><spring:message code="is.active"/></th>
                <th><spring:message code="user.roles"/></th>
                <th><spring:message code="locals"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.isActive}</td>
                    <td>${user.roles}</td>
                    <td><spring:message code="show.locals"></spring:message></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

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
<%@include file="login_section.jsp" %>
</body>
</html>
