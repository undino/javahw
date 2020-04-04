<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.04.2020
  Time: 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data">
    <label for="file"></label>
    <label for="file">Upload avatar</label>
    <input id="file" type="file" name="img" accept=".jpg, .jpeg, .png">
    <input type="submit" value="Upload">
</form>
</body>
</html>
