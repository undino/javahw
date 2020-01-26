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
<form method="post">
    <h3>EDIT CD</h3>
    <label for="old_title">Old title</label>
    <input id="old_title" name="old_title" type="text" placeholder="old title cd">
    <br>
    <label for="new_title">New title</label>
    <input id="new_title" name="new_title" type="text" placeholder="new title cd">
    <br>
    <label for="new_price">Price</label>
    <input id="new_price" name="new_price" type="number" placeholder="new price">
    <br>
    <button>EDIT</button>
</form>
<form method="post" action="index.jsp">
    <button>GO BACK</button>
</form>
<%
    if (request.getParameter("old_title") != null && request.getParameter("new_title") != null && request.getParameter("new_price") != null) {
        if ("POST".equals(request.getMethod())) {
            List listCd = (List) session.getAttribute("cd");
            if (listCd.indexOf(new Cd(request.getParameter("old_title"))) >= 0) {
                int idx = listCd.indexOf(new Cd(request.getParameter("old_title")));
                listCd.set(idx, new Cd(request.getParameter("new_title"), Integer.parseInt(request.getParameter("new_price"))));
            }
        }
    }
%>
</body>
</html>
