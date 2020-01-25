<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body {
            background-color: rgb(75, 75, 75);
        }

        #form_div {
            position: absolute;
            top: 30px;
            left: 10%;
            border: 4px solid dimgrey;
            border-radius: 15px;
            opacity: 0.4;
            width: 330px;
            background-color: #c9c9c9;
        }

        form {
            position: relative;
        }

        input {
            display: block;
            margin-bottom: 15px;
            margin-left: 20px;
            width: 265px;
            font-family: Candara;
        }

        button {
            display: block;
            margin-bottom: 20px;
            margin-left: 210px;
        }

        label, h3 {
            margin-left: 20px;
            font-family: "Arial Unicode MS";
        }

        #show_inform {
            position: absolute;
            top: 50px;
            right: 10%;
            background-color: #c9c9c9;
            border: 4px solid dimgrey;
            border-radius: 15px;
        }

        h2 {
            text-align: center;
        }

        #create_secure,
        #set_secure {
            width: 20px;
            height: 20px;
            margin-left: 150px;

        }

        .label_check {
            display: inline-block;
            float: left;
        }
    </style>
</head>
<body>
<div id="form_div">
    <form method="post" action="traffic" id="createCookies">
        <h3>Create cookie</h3>
        <label for="create_key">Fill in the name cookie`s</label>
        <input type="text" name="create_key" id="create_key" placeholder="name cookie">
        <label for="create_value">Fill in the value cookie`s</label>
        <input type="text" name="create_value" id="create_value" placeholder="value cookie">
        <label for="create_lifetime">Fill in the lifetime at seconds cookie`s</label>
        <input type="number" name="create_lifetime" id="create_lifetime" placeholder="lifetime cookie">
        <label for="create_domen">Fill in the domen cookie`s</label>
        <input type="text" name="create_domen" id="create_domen" placeholder="domen cookie">
        <label for="create_secure" class="label_check">Use if set https</label>
        <input type="checkbox" name="create_secure" id="create_secure" placeholder="use secure">
        <button name="create" value="create">EXECUTE</button>
    </form>
    <hr>
    <form method="post" action="traffic" id="setCookies">
        <h3>Chenge date in cookie</h3>
        <label for="set_key">Fill in the name cookie`s</label>
        <input type="text" name="set_key" id="set_key" placeholder="new name cookie">
        <label for="set_value">Fill in the value cookie`s</label>
        <input type="text" name="set_value" id="set_value" placeholder="new value cookie">
        <label for="set_lifetime">Fill in the lifetime at seconds cookie`s</label>
        <input type="number" name="set_lifetime" id="set_lifetime" placeholder="new lifetime cookie">
        <label for="set_domen">Fill in the domen cookie`s</label>
        <input type="text" name="set_domen" id="set_domen" placeholder="new domen cookie">
        <label for="set_secure" class="label_check">Use if set https</label>
        <input type="checkbox" name="set_secure" id="set_secure" placeholder="use secure">
        <button name="new" value="new">EXECUTE</button>
    </form>
    <hr>
    <form method="post" action="traffic" id="deleteCoocies">
        <h3>Delete cookie</h3>
        <label for="delete_key">Fill in the name cookie`s</label>
        <input type="text" name="delete_key" id="delete_key" placeholder="name cookie for delete">
        <button name="delete" value="delete">EXECUTE</button>
    </form>
</div>
<script>
    console.log(document.cookie);
</script>

<div id="show_inform">
    <h2>Information of cookie</h2>
    <hr>
    <ul>
        <% Cookie[] cookie = request.getCookies(); %>

        <% for (Cookie c : cookie) { %>
        <li>Name: <% out.write(c.getName());%></li>
        <li>Value: <% out.write(c.getValue());%></li>
        <li>Lifetime: <% out.write(String.valueOf(c.getMaxAge()));%></li>
        <li>Domain: <% out.write(String.valueOf(c.getDomain()));%></li>
        <li>Secure <% out.write(String.valueOf(c.getSecure()));%></li>
        <hr>
        <%}%>
    </ul>
</div>
</body>
</html>
