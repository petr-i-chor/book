<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>订单详情</title>
</head>
<body>
    <%@include file="/common/teacher_menu.jsp"%>
    <table>
        <tr>
            <td>订单编号</td>
            <td>书名</td>
            <td>作者</td>
            <td>单价</td>
            <td>数量</td>
            <td>总价</td>
        </tr>

    <c:forEach items="${orderItems}" var="orderItem">
        <tr>
            <td>${orderItem.orderId}</td>
            <td>${orderItem.name}</td>
            <td>${orderItem.author}</td>
            <td>${orderItem.price}</td>
            <td>${orderItem.count}</td>
            <td>${orderItem.totalPrice}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
