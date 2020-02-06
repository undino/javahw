<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.itstep.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%--@elvariable id="user" type="org.itstep.entity.User"--%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <p class="navbar-brand" style="color: #b70000">Admin: ${user.login} </p>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
<%--                    <a class="nav-link" href="<%=request.getContextPath()%> /admin">Home--%>
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/admin">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/admin">Write a blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/admin">Delete a blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/logout">Logout</a>
                </li>
                <li class="nav-item">
                    <p class="nav-link">Аутентифицированных пользователей: ${count}</p>
                </li>
            </ul>
        </div>
    </div>
</nav>

