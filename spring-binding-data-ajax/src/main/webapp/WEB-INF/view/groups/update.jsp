<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<h1>Update new student</h1>
<form method="post">

    <div>
        <label for="name">First name: </label>
        <input name="name" id="name" value="${groups.name}" required/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form>
</body>
</html>
