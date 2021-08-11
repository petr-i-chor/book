<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
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
                    if (stock<count){
                        alert("库存不足")
                        this.value = this.defaultValue;
                    }else{
                        window.location.href = "modifyCart.do?count="+count+"&id="+id;
                    }
                } else {
                    // defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
                    this.value = this.defaultValue;
                }
            });

        });
    </script>
    <title>Title</title>
</head>
<body>
<%@include file="/common/teacher_menu.jsp"%>
<table>
    <tr>
        <td>书名</td>
        <td>作者</td>
        <td>单价</td>
        <td>数量</td>
        <td>总价</td>
    </tr>
    <c:if test="${empty sessionScope.cart.items}">
        <%--如果购物车空的情况--%>
        <tr>
            <td ><a href="getBookList.do">当前购物车为空</a> </td>
        </tr>
    </c:if>
    <c:if test="${not empty sessionScope.cart.items}">
        <%--如果购物车非空的情况--%>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>
                    <input class="updateCount" style="width: 80px;"
                           bookId="${entry.value.id}"
                           stock="${entry.value.stock}"
                           type="text" value="${entry.value.count}">
                </td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a class="deleteItem" href="deleteCart.do?&bid=${entry.value.id}">删除</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<%--如果购物车非空才输出页面的内容--%>
<c:if test="${not empty sessionScope.cart.items}">
    <div class="cart_info">
        <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
        <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.cartTotalPrice}</span>元</span>
        <span class="cart_span"><a id="clearCart" href="clearCart.do">清空购物车</a></span>
        <span class="cart_span"><a href="addOrder.do">去结账</a></span>
    </div>
</c:if>
</body>
</html>
