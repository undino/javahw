<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="pageFragments/head.jsp"/>
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
<c:import url="pageFragments/navigation.jsp"/>
<c:import url="pageFragments/beforeStatic.jsp"/>
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
<c:import url="pageFragments/afterStatic.jsp"/>
<c:import url="pageFragments/footer.jsp"/>
</body>
</html>
