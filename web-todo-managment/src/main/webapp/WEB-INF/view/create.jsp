<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: orlov
  Date: 10.03.2020
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/static/css/style-create-form.css" />" rel="stylesheet">
</head>
<body>
<form method="post">
    <label for="title">Заглавие</label>
    <input id="title" type="text" name="title" placeholder=""/>
    <label for="description">Описание</label>
    <input id="description" type="text" name="description" placeholder=""/>
    <label for="priority">Приоритет</label>
    <select name="priority" id="priority">
        <option>HIGH</option>
        <option>MEDIUM</option>
        <option>LOW</option>
    </select>
    <label for="done">Статус выполнения</label>
    <select name="done" id="done">
        <option>false</option>
        <option>true</option>
    </select>
    <button type="submit">Добавить</button>
</form>
</body>
</html>
