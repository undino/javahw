<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:import url="pageFragments/head.jsp" />
    <style>
        .registration {
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
<c:import url="pageFragments/navigation.jsp" />
<c:import url="pageFragments/beforeStatic.jsp" />
<div class="col-md-8">
    <div class="registration">
        <form action="registration" method="post">
            <p>Registration</p>
            <label class="mylable">Login:
                <input class="myinput" name="login">
            </label><br>
            <label class="mylable">Password:
                <input class="myinput" name="password">
            </label><br>
            <label class="mylable">Role:</label><br>
            <label class="mylable">Admin:
                <input class="myinput" type="radio" name="role" value="admin">
            </label><br>
            <label class="mylable">User:
                <input class="myinput" type="radio" name="role" value="simpleUser" checked>
            </label><br>
            <button>Registration</button>
        </form>
    </div>
</div>
<c:import url="pageFragments/afterStatic.jsp" />
<c:import url="pageFragments/footer.jsp" />
</body>
</html>
