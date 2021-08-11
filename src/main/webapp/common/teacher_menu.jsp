<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/17
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table>
        <thead>
        <tr>
            <td>欢迎${sessionScope.username}</td>
            <td><a href="cart/cart.jsp">购物车</a> </td>
            <td><a href="showOrder.do">查看订单信息</a> </td>
            <td><a href="teacher/teacherModifyPwd.jsp">修改密码</a> </td>
            <td><a href="teacherLogout.do">退出登录</a> </td>
            <td><a href="getBookList.do">返回首页</a> </td>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
