<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>注册界面</h1>

    <form action="/user/register" method="POST">
        username: <input type="text" name="username" /> <br/>
        password: <input type="password" name="password" /> <br/>
        <input type="submit" value="register"/>
    </form>

</body>
</html>