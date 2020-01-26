<%@ page import="java.util.List" %>
<%@ page import="org.itstep.Cd" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.01.2020
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="post">
        <h3>ADD CD</h3>
        <label for="title_id">Title: </label>
        <input type="text" name="title_cd" id="title_id" placeholder="TITLE">
        <br>
        <label for="price_cd">Price: </label>
        <input type="number" name="price_cd" id="price_cd" placeholder="PRICE">
        <br>
        <button>ADD</button>
    </form>
    <form method="post" action="index.jsp">
        <button>GO BACK</button>
    </form>
</div>

<%
    if (request.getParameter("title_cd") != null && request.getParameter("price_cd") != null) {
        if ("POST".equals(request.getMethod())) {
            List listCd = (List) session.getAttribute("cd");
            listCd.add(new Cd(request.getParameter("title_cd"), Integer.parseInt(request.getParameter("price_cd"))));
        }
    }
%>

</body>
</html>
