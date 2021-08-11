<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>Title</title>
    <script>

            function reg(e){
                let stock = e.getAttribute("stock");
                let name = e.getAttribute("name");
                let bid = e.getAttribute("bid");
                if (stock<=0){
                    alert("《"+name+"》库存不足")
                }else{
                    window.location.href = "addCart.do?bid="+bid;
                }
            }
    </script>

</head>
<body>
<%@include file="/common/teacher_menu.jsp"%>

<div  align="center">
    <table>
        <thead>
        <tr>
            <td>书名</td>
            <td>作者</td>
            <td>价格</td>
            <td>销量</td>
            <td>库存</td>
        </tr>
        </thead>
        <tbody id="info">
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><input type="hidden" id="b_stock" value="${book.stock}"></td>
                <td><input type="hidden" id="b_name" value="${book.name}"></td>
                <td><input type="hidden" id="b_bid" value="${book.bid}"></td>
                <td><button stock="${book.stock}" name="${book.name}" bid="${book.bid}" onclick="reg(this)" >添加到购物车</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<table align="center">
    <tr class="pagination">

        <td <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a href="getBookList.do?page.start=0">
                <span> << </span>
            </a>
        </td>

        <td <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a href="getBookList.do?page.start=${page.start-page.count}">
                <span> < </span>
            </a>
        </td>
        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
            <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                <td <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a href="getBookList.do?page.start=${status.index*page.count}"
                       <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                    >${status.count}</a>
                </td>
            </c:if>
        </c:forEach>

        <td <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="getBookList.do?page.start=${page.start+page.count}">
                <span> > </span>
            </a>
        </td>

        <td <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="getBookList.do?page.start=${page.last}">
                <span> >> </span>
            </a>
        </td>
    </tr>
</table>
</body>
</html>
