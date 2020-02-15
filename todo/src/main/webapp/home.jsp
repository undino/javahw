<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/static/style.css" rel="stylesheet">
</head>
<body>
<div class="outer">
    <div class="form">
        <form method="post" action="">
            <h3>Создать ToDo</h3>
            <div>
                <label for="short_description">Заголовок: </label>
                <input type="text" id="short_description" name="short_description" required/>
            </div>
            <div>
                <label for="long_description">Задание: </label>
                <input type="text" id="long_description" name="long_description" required/>
            </div>
            <div>
                <label for="start_todo">Дата начала: </label>
                <input type="date" id="start_todo" name="start_todo" required/>
            </div>
            <div>
                <label for="end_todo">Дата окончания: </label>
                <input type="date" id="end_todo" name="end_todo" required/>
            </div>
            <div id="priority">
                <h4>Приоритет</h4>
                <label for="priority1">Низкий: </label>
                <input type="radio" class="priority" id="priority1" name="priority" value="3"><br>
                <label for="priority2">Средний: </label>
                <input type="radio" class="priority" id="priority2" name="priority" value="2"><br>
                <label for="priority3">Высокий: </label>
                <input type="radio" class="priority" id="priority3" name="priority" value="1"><br>
            </div>
            <button>Создать</button>
        </form>
    </div>
    <div class="list">
        <h3>Скисок ToDo</h3>
        <c:forEach items="${queue}" var="a">
            <div class="todo_list">
                <p class="header_todo">Тема:${a.shortDescription}</p>
                <p class="date_create">Дата создания: ${a.creat}</p>
                <div class="content">Задача: ${a.longDescription}</div>
                <p class="date_start">с ${a.start}</p>
                <p class="date_end">до ${a.end}</p>
                <a href="/delete?id=${a.id}">Выполнено (удалить) </a>
            </div>
        </c:forEach>
    </div>
</div>
</div>
</body>
</html>