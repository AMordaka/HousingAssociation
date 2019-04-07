<%@include file="head.jsp" %>

<body class="bg-dark">

<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header"><spring:message code="add.building.to,association"></spring:message></div>
        <div class="card-body">
            <form:form method="POST" modelAttribute="local" class="form-horizontal">
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputNumber" class="form-control" placeholder="Numer"
                                    required="required" path="number"/>
                        <label for="inputNumber"><spring:message code="number"></spring:message></label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputIsHousing"><spring:message code="is.housing"></spring:message></label>
                    <div class="form-label-group">
                        <form:select id="inputIsHousing" class="form-control" required="required" path="isHousing">
                            <form:option value="true" label="Tak"/>
                            <form:option value="false" label="Nie"/>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputSurfaceArea" class="form-control" placeholder="Surface"
                                    required="required" path="surfaceArea"/>
                        <label for="inputSurfaceArea"><spring:message code="surface.area"></spring:message></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:select path="building" id="inputBuildings" items="${buildings}" itemValue="id"
                                     class="form-control input-sm" />
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
