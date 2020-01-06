<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet"/>
</head>
<body>
<form action="<%=request.getContextPath()%>/" method="post">
    <div>Form registration</div>
    <div>
        <label for="login">Login</label>
        <input name="login" id="login"/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password"/>
    </div>
    <input type="submit"/>
</form>
<form action="<%=request.getContextPath()%>/user" method="post">
    <div>Form into</div>
    <div>
        <label for="login">Login</label>
        <input name="loginIn" id="loginIn"/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="passwordIn" id="passwordIn"/>
    </div>
    <input type="submit"/>
</form>
</body>
</html>
