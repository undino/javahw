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
    <h3>DELETE CD</h3>
    <label for="delete_title">Title</label>
    <input id="delete_title" name="delete_title" type="text" placeholder="title cd">
    <br>

    <button>DELETE</button>
</form>
<form method="post" action="index.jsp">
    <button>GO BACK</button>
</form>
<%
    if (request.getParameter("delete_title") != null) {
        if ("POST".equals(request.getMethod())) {
            List listCd = (List) session.getAttribute("cd");
            if (listCd.indexOf(new Cd(request.getParameter("delete_title"))) >= 0) {
                listCd.remove(new Cd(request.getParameter("delete_title")));
            }
        }
    }
%>
</body>
</html>