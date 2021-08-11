<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp" %>
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
                var salesText = $("#sales").val();
                var salesPatt = /^[\+\-]?(([1-9]\d*)|\d)$/;
                if (!salesPatt.test(salesText)) {
                    alert("销量不合法！");

                    return false;
                }

                var stockText = $("#stock").val();
                var stockPatt = /^[\+\-]?(([1-9]\d*)|\d)$/;
                if (!stockPatt.test(stockText)) {
                    alert("密码不合法！");

                    return false;
                }


                reg()


            })

            function reg() {
                let bid = $("#bid").val();
                let name = $("#name").val();
                let author = $("#author").val();
                let price = $("#price").val();
                let sales = $("#sales").val();
                let stock = $("#stock").val();
                $.ajax({
                    url: "addBook.do",
                    type: "post",
                    dataType: "json",
                    data: {
                        bid: bid,
                        name:name,
                        author:author,
                        price:price,
                        sales:sales,
                        stock:stock
                    },
                    success: function (map) {
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
    <h3>添加图书</h3>
    <table>
        <tr>
            <td>
                图书编号:<input type="text" id="bid" name="bid" >
            </td>
        </tr>
        <tr>
            <td>
                书名:<input type="text" id="name" name="name" >
            </td>
        </tr>
        <tr>
            <td>
                作者:<input type="text" id="author" name="author" >
            </td>
        </tr>
        <tr>
            <td>
                价格:<input type="text" id="price" name="price" value="60">
            </td>
        </tr>
        <tr>
            <td>
                销量:<input type="text" id="sales" name="sales" value="100">
            </td>
        </tr>
        <tr>
            <td>
                库存:<input type="text" id="stock" name="stock" value="1000">
            </td>
        </tr>
        <tr>
            <td>
                <input id="btn" type="submit" value="提交">
            </td>
        </tr>
    </table>
</div>
</body>
</html>
