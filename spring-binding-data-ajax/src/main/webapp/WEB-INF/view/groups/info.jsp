<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Student Info</title>
    <link href="<spring:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<h1>Student Info</h1>

<div>${error}</div>
<div>
    <p>Id: ${group.id}</p>
    <p>Group name: ${group.name}</p>
</div>
<p>
    <a href="<c:url value="/groups"/>">Go to students list</a>
</p>
</body>
</html>
