
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <br>
        <form action="login" method="post">
            <label>Username: </label>
            <input type="text" name="name" value="${name}">
            <br>
            <lable>Password: </lable>
            <input type="text" name="password" value="${password}">
            <br>
            <input type="submit" value="Log in">
        </form>
        <br>
        <b>${logout}${invalid}</b>
    </body>
</html>
