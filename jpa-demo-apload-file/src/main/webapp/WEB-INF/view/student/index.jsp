<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<c:set var="title" value="Students"/>
<%@include file="../include/header.jsp" %>

<div class="container">
    <h1>${title}</h1>
    <div class="row">
        <table class="highlight col s12">
            <thead>
            <tr>
                <th>Avatar</th>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Group</th>
                <th>Birth date</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="s">
                <tr>
                    <td>
                        <img src="<spring:url value="/avatar/${s.avatar}"/>" alt="ava" width="100px" height="100px"/>
                    </td>
                    <td>${s.id}</td>
                    <td>${s.firstName}</td>
                    <td>${s.lastName}</td>
                    <td>${s.groupName}</td>
                    <td>${s.birthDate}</td>
                    <td>
                        <a class=" btn" href="<spring:url value="/students/edit/${s.id}"/>">Update
                            <i class="material-icons right">edit</i></a>
                        <a class="btn" href="<spring:url value="/students/delete/${s.id}"/>">Delete
                            <i class="material-icons right">delete</i></a>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        <ul class="pagination center-align">
            <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
            <c:forEach var="i" begin="1" end="${studentPage}">
                <li class="active"><a href="?page=${i}">${i}</a></li>
            </c:forEach>
            <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col s1 offset-s11">
            <a href="<spring:url value="/students/create"/>" class="btn-floating btn-large">
                <i class="material-icons">add</i>
            </a>
        </div>
    </div>

    <jsp:include page="../include/scripts.jsp"/>
</div>
<%@include file="../include/footer.jsp" %>
