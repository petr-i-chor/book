<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>订单详情</title>
</head>
<body>
<%@include file="/common/manager_menu.jsp"%>
<div align="center">

<table>
    <tr>
        <td>订单编号</td>
        <td>书名</td>
        <td>作者</td>
        <td>采购数</td>
    </tr>

    <c:forEach items="${storeItems}" var="storeItem">
        <tr>
            <td>${storeItem.orderId}</td>
            <td>${storeItem.name}</td>
            <td>${storeItem.author}</td>
            <td>${storeItem.count}</td>
        </tr>
    </c:forEach>
</table>

</div>
</body>
</html>
