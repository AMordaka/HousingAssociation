<%@include file="head.jsp" %>
<body class="bg-dark">
<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header"><spring:message code="add.building.to,association"></spring:message></div>
        <div class="card-body">
            <form:form method="POST" modelAttribute="dto" class="form-horizontal">
                <div class="form-group">
                    <div class="form-label-group">
                        <form:select path="user" id="inputUsers" items="${users}" itemValue="id"
                                     class="form-control input-sm"/>
                        <div class="has-error">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:select path="local" id="inputLocals" items="${locals}" itemValue="id"
                                     class="form-control input-sm"/>
                        <div class="has-error">
                        </div>
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
