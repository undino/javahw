<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: orlov
  Date: 11.03.2020
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/static/css/start-page.css" />" rel="stylesheet">
</head>
<body>

<spring:url value='/create' var="url"/>
<form:form method="post" modelAttribute="user" action="${url}">
    <h3>Регестрация пользователя</h3>

    <form:label path="login">
        <spring:message code="login"/>
    </form:label>
    <form:errors path="login" cssClass="error-message"/>
    <form:input path="login" cssErrorClass="error"/><br/>

    <form:label path="password">
        <spring:message code="password"/>
    </form:label>
    <form:errors path="password" cssClass="error-message"/>
    <form:input path="password" type="password" cssErrorClass="error"/><br/>

    <form:label path="checkPassword">
        <spring:message code="password"/>
    </form:label>
    <form:errors path="checkPassword" cssClass="error-message"/>
    <form:input path="checkPassword" type="password" cssErrorClass="error"/><br/>

    <form:label path="email">
        <spring:message code="email"/>
    </form:label>
    <form:errors path="email" cssClass="error-message"/>
    <form:input path="email" cssErrorClass="error"/><br/>

    <form:label path="phone">
        <spring:message code="phone"/>+380
    </form:label>
    <form:errors path="phone" cssClass="error-message"/>
    <form:input path="phone" value="" cssErrorClass="error"/><br/>

    <form:label path="gender">
        <spring:message code="gender"/>
    </form:label>
    <form:errors path="gender" cssClass="error-message"/>
    <form:radiobutton path="gender" name="gender" value="Male" cssErrorClass="error"/>
    <spring:message code="male"/>
    <form:radiobutton path="gender" name="gender" value="Female" cssErrorClass="error"/>
    <spring:message code="female"/>
    <form:radiobutton path="gender" name="gender" value="Other" cssErrorClass="error"/>
    <spring:message code="other"/>
    <br/>

    <form:button type="submit" value="Создать">
        <spring:message code="create"/>
    </form:button>

</form:form>


<%--<form method="post" action="<spring:url value="/create" />">--%>
<%--    <h3>Регестрация пользователя</h3>--%>
<%--    <label for="login">Логин:</label>--%>
<%--    <input id="login" name="login"/><br/>--%>
<%--    <label for="password">Пароль:</label>--%>
<%--    <input id="password" name="password"/><br/>--%>
<%--    <label for="email">Эл. Почта:</label>--%>
<%--    <input id="email"  name="email"><br/>--%>
<%--    <label for="phone">Телефон:</label>--%>
<%--    <input id="phone" name="phone"><br/>--%>
<%--    <label for="gender">Пол:</label>--%>
<%--    <input id="gender" type="radio" name="gender" value="Male">Male--%>
<%--    <input type="radio" name="gender" value="Female">Female--%>
<%--    <input type="radio" name="gender" value="Other">Other--%>
<%--    <button type="submit">Создать</button>--%>

</body>
</html>
