<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>订单</title>
</head>
<body>
<%@include file="/common/manager_menu.jsp"%>
<div align="center">
<table>
    <tr>
        <td>
            订单编号
        </td>
        <td>
            下单时间
        </td>
        <td>
            状态
        </td>
    </tr>

    <c:forEach items="${stores}" var="stores">
        <tr>
            <td>
                    ${stores.orderId}
            </td>
            <td>
                    ${stores.createTime}
            </td>
            <td>
                    ${stores.status}
            </td>
            <td>
                <a href="getStoreOrderDetail.do?orderId=${stores.orderId}">订单详情</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
