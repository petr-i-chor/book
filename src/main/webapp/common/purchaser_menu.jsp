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
            <td><a href="queryStoreOrderByStatus0.do">查看待采购订单</a> </td>
            <td><a href="queryStoreOrderByStatus1.do">查看已采购订单</a> </td>
            <td><a href="purchaser/purchaserModifyPwd.jsp">修改密码</a> </td>
            <td><a href="purchaserLogout.do">退出登录</a> </td>
            <td><a href="purchaser/purchaser.jsp">返回首页</a> </td>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
