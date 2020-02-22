<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
    <h1>Students</h1>
    <p><a href="<spring:url value="/groups/new"/>">Create group</a></p>
    <p><a href="<spring:url value="/"/>">Home page</a></p>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Name group</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:if test="${error != null}" >
       <tr>
        <th colspan="3">
        ${error}
        </th>
       </tr>
    </c:if>
            <c:forEach var="group" items="${groups}">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td><a href="<spring:url value="/groups/delete/${group.id}"/>">Delete</a>
                    <br/>
                    <a href="<spring:url value="/groups/update/${group.id}"/>">Update</a> </td>
            </tr>
        </c:forEach>

    </tbody>
</table>
</body>
</html>
