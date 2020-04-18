<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>${title}</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <link href="<spring:url value="/static/css/style.css"/>" rel="stylesheet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>

<nav>
    <div class="nav-wrapper">
        <a href="<spring:url value="/"/>" class="brand-logo"><i class="material-icons">school</i> Academy</a>
        <a href="#" data-target="mobile-nav" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="<spring:url value="/"/>">Home</a></li>
            <li><a class="dropdown-trigger" href="#!" data-target="dropdown-students">Students<i
                    class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-trigger" href="#!" data-target="dropdown-groups">Groups<i
                    class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-trigger" href="#!" data-target="dropdown-teachers">Teachers<i
                    class="material-icons right">arrow_drop_down</i></a></li>
            <li><a href="<spring:url value="/h2console"/>" target="_blank">H2 Console</a></li>


            <security:authorize access="isAuthenticated()" var="isUser"/>

            <c:choose>
                <c:when test="${not isUser}">
                    <li><a class="waves-effect waves-light modal-trigger" href="/login">Sing in</a></li>
                </c:when>
                <c:otherwise>
                    <li><a class="waves-effect waves-light modal-trigger" id="lgt" href="<spring:url value="/logout"/>">Log
                        out</a></li>
                    <form method="post" id="form_logout" action="/logout">
                        <security:csrfInput/>
                    </form>
                    <script>
                        let logout = document.getElementById("lgt");
                        logout.addEventListener("click", (e) => {
                            e.preventDefault();
                            const logForm = document.getElementById("form_logout");
                            logForm.submit();
                        })
                    </script>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
    <ul class="sidenav" id="mobile-nav">
        <li><a href="<spring:url value="/"/>">Home</a></li>
        <li><a class="dropdown-trigger-mobile" href="#!" data-target="dropdown-students-mobile">Students<i
                class="material-icons right">arrow_drop_down</i></a></li>
    </ul>
    <ul id="dropdown-students" class="dropdown-content">
        <security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_TEACHER')" var="creator"/>

        <li><a href="<spring:url value="/students"/>"><i class="material-icons">person</i>List</a></li>
        <c:if test="${creator}">
            <li><a href="<spring:url value="/students/create"/>"><i class="material-icons">person_add</i>Add</a></li>
        </c:if>
    </ul>
    <ul id="dropdown-students-mobile" class="dropdown-content">
        <li><a href="<spring:url value="/students"/>"><i class="material-icons">person</i>List</a></li>
        <c:if test="${creator}">
            <li><a href="<spring:url value="/students/create"/>"><i class="material-icons">person_add</i>Add</a></li>
        </c:if>
    </ul>

    <ul id="dropdown-groups" class="dropdown-content">
        <li><a href="<spring:url value="/groups"/>"><i class="material-icons">group</i>List</a></li>
        <c:if test="${creator}">
            <li><a href="<spring:url value="/groups/create"/>"><i class="material-icons">group_add</i>Add</a></li>
        </c:if>
    </ul>

    <ul id="dropdown-teachers" class="dropdown-content">
        <li><a href="<spring:url value="/teachers"/>"><i class="material-icons">group</i>List</a></li>
        <security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin"/>
        <c:if test="${isAdmin}">
            <li><a href="<spring:url value="/teachers/create"/>"><i class="material-icons">person_add</i>Add</a></li>
        </c:if>
    </ul>

</nav>

<div id="modal1" class="modal">
    <form>
        <div class="modal-content">
            <h4>Sing in</h4>
            <div>
                <label>Username<input name="username" required/></label>
            </div>
            <div>
                <label>Password<input name="password" required type="password"/></label>
            </div>
        </div>
        <div class="modal-footer">
            <a type="submit" href="#!" class="modal-close waves-effect waves-green btn">Cancel</a>
            <button type="submit" href="#!" class="waves-effect waves-green btn">Submit</button>
        </div>
    </form>

</div>
