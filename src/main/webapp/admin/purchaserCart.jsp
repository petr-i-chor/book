<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>Title</title>
    <script>
        $(function () {
            // 给 【删除】绑定单击事件
            $("a.deleteItem").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() +"】吗?")
            });
            // 给清空购物车绑定单击事件
            $("#clearCart").click(function () {
                return confirm("你确定要清空购物车吗?");
            })
            // 给输入框绑定 onchange内容发生改变事件
            $(".updateCount").change(function () {
                // 获取商品名称
                var name = $(this).parent().parent().find("td:first").text();
                var id = $(this).attr('bookId');
                var stock = $(this).attr('stock');
                // 获取商品数量
                var count = this.value;
                if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") ) {
                    //发起请求。给服务器保存修改
                        window.location.href = "modifyCart.do?count="+count+"&id="+id;
                } else {
                    // defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
                    this.value = this.defaultValue;
                }
            });

        });
    </script>
</head>
<body>
<%@include file="/common/manager_menu.jsp"%>
<div align="center">
<table>
    <tr>
        <td>书名</td>
        <td>作者</td>
        <td>库存</td>
        <td>采购数</td>
    </tr>
    <c:if test="${empty sessionScope.cart.items}">
<%--        如果购物车空的情况--%>
        <tr>
            <td ><a href="getBookList.do?method=purchase">当前采购清单为空</a> </td>
        </tr>
    </c:if>
    <c:if test="${not empty sessionScope.cart.items}">
<%--        如果购物车非空的情况--%>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>${entry.value.author}</td>
                <td>${entry.value.stock}</td>
                <td>
                    <input class="updateCount" style="width: 80px;"
                           bookId="${entry.value.id}"
                           type="text" value="${entry.value.count}">
                </td>
                <td><a class="deleteItem" href="deleteCart.do?&bid=${entry.value.id}">删除</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<%--如果购物车非空才输出页面的内容--%>
<c:if test="${not empty sessionScope.cart.items}">
    <div class="cart_info">
        <span class="cart_span"><a id="clearCart" href="clearCart.do">清空购物车</a></span><br>
        <span class="cart_span"><a href="addStoreOrder.do">下订单</a></span>
    </div>
</c:if>
</div>
</body>
</html>
