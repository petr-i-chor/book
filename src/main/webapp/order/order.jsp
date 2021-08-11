<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>订单</title>
</head>
<body>
<%@include file="/common/teacher_menu.jsp"%>
<table>
    <tr>
        <td>
            订单编号
        </td>
        <td>
            下单时间
        </td>
        <td>
            总金额
        </td>
        <td>
            状态
        </td>
    </tr>

    <c:forEach items="${orders}" var="order">
        <tr>
            <td>
                ${order.orderId}
            </td>
            <td>
                ${order.createTime}
            </td>
            <td>
                ${order.price}
            </td>
            <td>
                ${order.status}
            </td>
            <td>
                <a href="getOrderDetail.do?orderId=${order.orderId}">订单详情</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
