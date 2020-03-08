
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.2020
  Time: 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/static/css/cssStartPage.css"/>" rel="stylesheet" />
</head>
<body>
<footer>
    <h3>Пользователи сайта</h3>

</footer>
<c:forEach items="${pageData}" var="user" >
<div id="outDiv">
    <div id="imgDiv"><img src="${user.avatar}"></div>
    <p id="first_name">${user.firstName}</p>
    <p id="last_name">${user.lastName}</p>
    <p id="email">${user.email}</p>
</div>
</c:forEach>
</body>
</html>
