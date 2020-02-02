<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.02.2020
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="pageFragments/head.jsp" %>
    <style>
        .login {
            margin-top: 50px;
            float: left;
            border: 1px solid #95999c;
            padding: 25px;
            width: 350px;
            margin-left: 10px;
        }

        .mylable {
            position: relative;
            margin: 10px;

        }

        .myinput {
            position: absolute;
            left: 100px;
        }
    </style>
</head>
<body>
<%@include file="pageFragments/navigation.jsp" %>
<%@include file="pageFragments/beforeStatic.jsp" %>
<div class="col-md-8">
    <div class="login">
        <p>Log in</p>
        <hr>
        <form action="login" method="post">
            <label class="mylable">Login:
                <input class="myinput" name="login">
            </label><br>
            <label class="mylable">Password:
                <input class="myinput" name="password">
            </label><br>
            <button>Login</button>
        </form>
    </div>
</div>
<%@include file="pageFragments/afterStatic.jsp" %>
<%@include file="pageFragments/footer.jsp" %>


</body>
</html>
