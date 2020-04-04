<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<c:set var="title" value="Teachers"/>
<%@include file="../include/header.jsp" %>

<div class="container">
    <h1>${title}</h1>
    <div class="row">
        <table class="highlight col s12">
            <thead>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${teachersDto}" var="t">
                <tr>
                    <td>${t.id}</td>
                    <td>${t.firstName}</td>
                    <td>${t.lastName}</td>
                    <td>
                        <select>
                            <c:forEach items="${t.groupsName}" var="group">
                                <option>${group}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <a class="btn" href="<spring:url value="/teachers/edit/${t.id}"/>">Update
                            <i class="material-icons right">edit</i></a>
                        <a class="btn" href="<spring:url value="/teachers/delete/${t.id}"/>">Delete
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
            <c:forEach var="i" begin="1" end="${teacherPage}" >
            <li class="active"><a href="?page=${i}">${i}</a></li>
            </c:forEach>
<%--            <li class="waves-effect"><a href="#!">2</a></li>--%>
<%--            <li class="waves-effect"><a href="#!">3</a></li>--%>
<%--            <li class="waves-effect"><a href="#!">4</a></li>--%>
<%--            <li class="waves-effect"><a href="#!">5</a></li>--%>
            <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col s1 offset-s11">
            <a href="<spring:url value="/teachers/create"/>" class="btn-floating btn-large">
                <i class="material-icons">add</i>
            </a>
        </div>
    </div>
    <jsp:include page="../include/scripts.jsp"/>
</div>
<%@include file="../include/footer.jsp" %>
