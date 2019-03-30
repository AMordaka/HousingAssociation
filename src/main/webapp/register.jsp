<%@include file="head.jsp" %>

<body class="bg-dark">

<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Register an Account</div>
        <div class="card-body">
            <form:form  method="POST" modelAttribute="user" class="form-horizontal">
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputLogin" class="form-control" placeholder="login" required="required" path="login" />
                        <label for="inputLogin">Login</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <form:input type="text" id="inputFirstName" class="form-control" placeholder="First Name" required="required" path="firstName"/>
                                <label for="inputFirstName"><spring:message code="firstName"></spring:message></label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <form:input type="text" id="inputLastName" class="form-control" placeholder="Login" required="required" path="lastName"/>
                                <label for="inputLastName"><spring:message code="lastName"></spring:message></label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="email" id="inputEmail" class="form-control" placeholder="Login" required="required" path="email"/>
                        <label for="inputEmail">Email</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="password" id="inputPassword" class="form-control" placeholder="Login" required="required" path="password"/>
                        <label for="inputPassword"><spring:message code="password"></spring:message></label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="form-label-group">
                        <form:select path="roles" id="userRoles" items="${roles}" multiple="true" itemValue="id" class="form-control input-sm" />
                        <div class="has-error">
                    </div>
                </div>

                </div>
                    <a class="btn btn-primary btn-block" href="login.html">Register</a>
            </form:form>
        </div>
    </div>
</div>

</body>

</html>