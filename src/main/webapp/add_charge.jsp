<%@include file="head.jsp" %>

<body class="bg-dark">

<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header"><spring:message code="add.building.to,association"></spring:message></div>
        <div class="card-body">
            <form:form method="POST" modelAttribute="charge" class="form-horizontal">
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputElectricity" class="form-control" placeholder="electricity"
                                    required="required" path="electricity"/>
                        <label for="inputElectricity"><spring:message code="electricity"></spring:message></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputGas" class="form-control" placeholder="gas"
                                    required="required" path="gas"/>
                        <label for="inputGas"><spring:message code="gas"></spring:message></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputColdWater" class="form-control" placeholder="coldWater"
                                    required="required" path="coldWater"/>
                        <label for="inputColdWater"><spring:message code="cold.water"></spring:message></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputHotWater" class="form-control" placeholder="hotWater"
                                    required="required" path="hotWater"/>
                        <label for="inputHotWater"><spring:message code="hot.water"></spring:message></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputSewage" class="form-control" placeholder="sewage"
                                    required="required" path="sewage"/>
                        <label for="inputSewage"><spring:message code="sewage"></spring:message></label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:input type="text" id="inputFoundRenovation" class="form-control" placeholder="foundRenovation"
                                    required="required" path="foundRenovation"/>
                        <label for="inputFoundRenovation"><spring:message code="fundRenovation"></spring:message></label>
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
