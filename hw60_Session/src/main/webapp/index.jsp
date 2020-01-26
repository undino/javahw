<%@ page import="java.util.List" %>
<%@ page import="org.itstep.Cd" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; UTF-8" language="java" pageEncoding="utf-8" %>
<style>
    body {
        background-color: dimgray;
    }

    #divParagraph {
        position: absolute;
        top: 10%;
        right: 10%;
        background-color: darkgrey;
        display: inline-block;
        padding: 10px 20px;
        border-radius: 15px;
    }

    table, th, td {
        border: 2px solid darkslategray;
    }

    button {
        display: block;
        width: 150px;
        height: 50px;
        margin: 25px;
    }
</style>
<html>
<body>
<div id="going">
    <form method="post" action="add.jsp">
        <button name="add_cd">ADD CD</button>
    </form>
    <form method="post" action="edit.jsp">
        <button name="edit_cd">EDIT CD</button>
    </form>
    <form method="post" action="delete.jsp">
        <button name="delete_cd">DELETE CD</button>
    </form>
</div>
<div id="divParagraph">
    <%
        if (session.isNew()) {
            session.setAttribute("cd", new ArrayList());
        }
    %>
    <table>
        <caption><=-CD-=></caption>
        <thead>
        <tr>
            <th>Название</th>
            <th>Стоимость</th>
        </tr>
        </thead>
        <tbody>

        <%
            List listCd = (List) session.getAttribute("cd");
            for (int i = 0; i < listCd.size(); i++) {
                Cd cd = (Cd) listCd.get(i);
        %>
        <tr>
            <td><%= cd.getTitle()%>
            </td>
            <td><%= cd.getPrice()%>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
