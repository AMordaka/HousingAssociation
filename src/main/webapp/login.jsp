<%@include file="head.jsp" %>

<body class="bg-dark">

<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
            <form action="/login" method="post">
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        <spring:message code="invalid.username.or.password"/>
                    </div>
                </c:if>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="text" id="email" class="form-control" placeholder="Email address"
                               required="required" autofocus="autofocus" name="email">
                        <label for="email">Email</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="password" id="password" class="form-control" placeholder="Password"
                               required="required" name="password">
                        <label for="password"><spring:message code="password"></spring:message></label>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" class="btn btn-primary" value="<spring:message code="login"/>">
            </form>
            <div class="text-center">
                <%--<a class="d-block small" href="forgot-password.html">Forgot Password?</a>--%>
            </div>
        </div>
    </div>
</div>

</body>

</html>
