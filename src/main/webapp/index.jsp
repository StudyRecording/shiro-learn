<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>管理界面</h1>
    <a href="/user/logout">logout</a>
    <ul>
        <li>
            <a href="">商品管理</a>
            <ul>
                <shiro:hasPermission name="user:create:*">
                    <li><a>增加</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:delete:*">
                    <li><a>删除</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:search:*">
                    <li><a>查询</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:update:*">
                    <li><a>更改</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="product:×:*">
                    <li><a>商品</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="order:update:*">
                    <li><a>订单更新</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="order:×:*">
                    <li><a>订单</a></li>
                </shiro:hasPermission>
            </ul>

        </li>
        <shiro:hasRole name="admin">
            <li><a href="">订单管理</a></li>
            <li><a href="">物流管理</a></li>
            <li><a href="">其他</a></li>
        </shiro:hasRole>
    </ul>

</body>
</html>