<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="/">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
        </a>
    </li>
    <sec:authorize access="hasRole('ADMIN')">
        <li class="nav-item active">
            <a class="nav-link" href="/register">
                <i class="fas fa-fw fa-user-plus"></i>
                <span><spring:message code="add.user"></spring:message></span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/addbuilding">
                <i class="fas fa-fw fa-hospital"></i>
                <span><spring:message code="add.building"></spring:message></span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/addlocal">
                <i class="fas fa-fw fa-home"></i>
                <span><spring:message code="add.local"></spring:message></span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/assign">
                <i class="fas fa-fw fa-plug"></i>
                <span><spring:message code="assign.to.user"></spring:message></span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="users">
                <i class="fas fa-fw fa-user-friends"></i>
                <span><spring:message code="user.list"></spring:message></span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="buildings">
                <i class="fas fa-fw fa-building"></i>
                <span><spring:message code="buildings"></spring:message></span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="locals">
                <i class="fas fa-fw fa-table"></i>
                <span><spring:message code="locals"></spring:message></span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="rest">
                <i class="fas fa-fw fa-info"></i>
                <span><spring:message code="rest.controller"></spring:message></span></a>
        </li>
    </sec:authorize>
    <sec:authorize access="hasRole('EMPLOYEE')">
        <li class="nav-item active">
            <a class="nav-link" href="locals">
                <i class="fas fa-fw fa-table"></i>
                <span><spring:message code="locals"></spring:message></span></a>
        </li>
    </sec:authorize>
    <sec:authorize access="hasRole('USER')">
    <li class="nav-item active">
        <a class="nav-link" href="mylocals">
            <i class="fas fa-fw fa-table"></i>
            <span><spring:message code="my.locals"></spring:message></span></a>
    </li>
    </sec:authorize>
</ul>
