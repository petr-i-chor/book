<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/16
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>管理员注册</title>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            $("#btn").click(function () {
                var priceText = $("#price").val();
                var pricePatt = /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;
                if (!pricePatt.test(priceText)) {
                    alert("价格不合法！");

                    return false;
                }


                reg()


            })


            function reg(){
                let bid = $("#bid").val();
                let price = $("#price").val();
                let author=$("#author").val();
                let name = $("#name").val();
                $.ajax({
                    url:"modifyBook.do",
                    type:"post",
                    dataType:"json",
                    data:{
                        bid:bid,
                        price:price,
                        author:author,
                        name:name,
                    },
                    success: function(map){
                        alert(map.msg)
                    }
                })
            }
        });


    </script>
</head>
<body>

<%--静态包含--%>
<jsp:include page="/common/manager_menu.jsp"></jsp:include>
<div align="center">
    <h3>修改管理员信息</h3>
</div>
<div align="center">
    <table>

        <tr>
            <td>
                书名:<input type="text" id="name" name="name" value="${book.name}">
            </td>
        </tr>
        <tr>
            <td>
                作者:<input type="text" id="author" name="author" value="${book.author}">
            </td>
        </tr>
        <tr>
            <td>
                价格:<input type="text" id="price" name="price" value="${book.price}">
            </td>
        </tr>
        <tr>
            <td>
                销量:${book.sales}
            </td>
        </tr>
        <tr>
            <td>
                库存:${book.stock}
            </td>
        </tr>
        <tr>
            <td>
                <input type="hidden" id="bid" value="${book.bid}">
                <input id="btn" type="submit" value="提交">
            </td>
        </tr>
    </table>
</div>
</body>
</html>

