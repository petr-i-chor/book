<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/common/purchaser_menu.jsp"%>
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
    <c:forEach items="${stores}" var="store">
        <tr>
            <td>
                    ${store.orderId}
            </td>
            <td>
                    ${store.createTime}
            </td>
            <td>
                    ${store.status}
            </td>
            <td>
                <a href="getStoreOrderDetail.do?orderId=${store.orderId}">订单详情</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
