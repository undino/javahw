<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: orlov
  Date: 10.03.2020
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="erroe">
    <h1>${message}</h1>
    <a href="<spring:url value="/" />">Вернуться на главную страницу</a>
</div>
</body>
</html>
