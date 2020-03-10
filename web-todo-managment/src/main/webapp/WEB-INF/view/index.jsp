<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.03.2020
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/static/css/style_start_page.css" />" rel="stylesheet">
</head>
<body>
<menu>
    <h3>Задачи: </h3>
</menu>
<a href="<spring:url value="/create" />" id="createA">Создать задачу</a>
<c:forEach items="${model.toDos}" var="todo">
    <div id="todo">

        <div class="lineDiv" id="title">Заглавие:<p>${todo.title}</p></div>
        <div class="lineDiv" id="description">Описание: <p>${todo.description}</p></div>
        <div class="lineDiv" id="created">Создан: <p> ${todo.created}</p></div>
        <div class="lineDiv" id="lastUpdate">Обновлен:<p>${todo.lastUpdate}</p></div>
        <div class="lineDiv" id="priority">Приоритет:<p>${todo.priority}</p></div>
        <div class="lineDiv" id="done">Сделано: <p>${todo.done}</p></div>
        <a id="deleteA" href="<spring:url value="/delete?url=${todo.links.self.href}"/>">Удалить</a>

    </div>
</c:forEach>
<script src="<spring:url value="/static/script/script-for-delete.js" />" rel="script"></script>
</body>
</html>
