<%@include file="head.jsp" %>

<body class="bg-dark">

<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header"><spring:message code="add.building.to,association"></spring:message></div>
        <div class="card-body">
            <form:form method="POST" modelAttribute="building" class="form-horizontal">
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputLogin" class="form-control" placeholder="address"
                                    required="required" path="address"/>
                        <label for="inputLogin"><spring:message code="address"></spring:message></label>
                    </div>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message
                        code="register"></spring:message></button>
            </form:form>
        </div>
    </div>
</div>

</body>

</html>
