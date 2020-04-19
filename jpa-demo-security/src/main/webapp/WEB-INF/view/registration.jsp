<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/static/css/login.css"/>" rel="stylesheet"/>
</head>
<body>

<!-- vladmaxi top bar -->
<div class="vladmaxi-top">
    <a href="http://vladmaxi.net" target="_blank">Главная Vladmaxi.net</a>
    <span class="right">
        <a href="http://vladmaxi.net/web-developer/css/22-luchshix-formy-vxoda-i-registracii-na-sajte-v-html-css.html">
                <strong>Вернуться назад к статье</strong>
            </a>
        </span>
    <div class="clr"></div>
</div>
<!--/ vladmaxi top bar -->

<div id="login">
    <form name="form_login" method="post" action="<spring:url value="/students/registration"/>">
        <fieldset class="clearfix">
           <p><span class="fontawesome-user"></span><input name="firstName" type="text" value="Имя"
                                                            onBlur="if(this.value == '') this.value = 'Логин'"
                                                            onFocus="if(this.value == 'Логин') this.value = ''"
                                                            required></p>
            <p><span class="fontawesome-user"></span><input name="lastName" type="text" value="Фамилия"
                                                            onBlur="if(this.value == '') this.value = 'Логин'"
                                                            onFocus="if(this.value == 'Логин') this.value = ''"
                                                            required></p>
            <p><span class="fontawesome-user"></span><input name="password" type="password" value="Пароль"
                                                            onBlur="if(this.value == '') this.value = 'Пароль'"
                                                            onFocus="if(this.value == 'Пароль') this.value = ''"
                                                            required></p>
            <p><span class="fontawesome-user"></span><input name="birthDate" type="date" value="День рождения" required></p>
            <p><span class="fontawesome-user"></span>
                <select name="groupId">
                    <c:forEach items="${groups}" var="group">
                        <option value="${group.id}">${group.name}</option>
                    </c:forEach>
                </select></p>
            <security:csrfInput/>
            <p><input type="submit" value="ЗАРЕГЕСТРИРОВАТЬСЯ"></p>
        </fieldset>
    </form>
    <p>Нет аккаунта? &nbsp;&nbsp;<a href="#">Регистрация</a><span class="fontawesome-arrow-right"></span></p>
</div>

</body>
</html>
