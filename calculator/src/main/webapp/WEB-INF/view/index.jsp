<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.02.2020
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input {
            width: 50px;
        }
    </style>
</head>
<body>
<form method="get" action="/">
    <label>a: </label>
    <input type="number" name="a">
    <label>b: </label>
    <input type="number" name="b">
    <label>sing </label>
    <select name="op">
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
    </select>
    <button>execute</button>
    <p>result: ${task}${result}</p>
</form>
</body>
</html>
