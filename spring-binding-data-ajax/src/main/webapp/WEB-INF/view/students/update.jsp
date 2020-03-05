<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<h1>Update new student</h1>
<form method="post">
<%--    <c:forEach var="theStudent" items="${student}">--%>
<%--        --%>
<%--    </c:forEach>--%>
    <div>
        <label for="firstName">First name: </label>
        <input name="firstName" id="firstName" value="${student.firstName}" required/>
    </div>
    <div>
        <label for="lastName">Last name: </label>
        <input name="lastName" id="lastName" value="${student.lastName}" required/>
    </div>
    <div>
        <label for="age">Age: </label>
        <input name="age" id="age" type="number" min="8" max="60" value="${student.age}" required/>
    </div>

    <div>
        <label for="group">Group: </label>
        <%--        <input type="number" name="group" id="group" required/>--%>
        <select name="group" id="group">
            <spring:forEach var="group" items="${groups}">
                <option value="${group.id}">${group.name}</option>
            </spring:forEach>
        </select>
    </div>

    <div>
        <input type="submit"/>
    </div>
</form>
</body>
</html>
