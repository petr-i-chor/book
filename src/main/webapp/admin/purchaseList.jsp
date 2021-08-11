<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<%@include file="/common/manager_menu.jsp"%>
<div align="center">
<table>
    <tr>
        <td>
            图书编号
        </td>
        <td>
            书名
        </td>
        <td>
            作者
        </td>
        <td>
            销量
        </td>
        <td>
            库存
        </td>

    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>
                    ${book.bid}
            </td>
            <td>
                    ${book.name}
            </td>
            <td>
                    ${book.author}
            </td>
            <td>
                    ${book.sales}
            </td>
            <td>
                    ${book.stock}
            </td>
            <td>
                <a href="addCart.do?bid=${book.bid}">添加到采购清单</a>
            </td>
        </tr>
    </c:forEach>

    <td>
        <a href="admin/purchaserCart.jsp" >去采购</a>
    </td>
</table>
</div>
<table align="center">
    <tr class="pagination">

        <td <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a href="getBookList.do?method=purchase&page.start=0">
                <span> << </span>
            </a>
        </td>

        <td <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a href="getBookList.do?method=purchase&page.start=${page.start-page.count}">
                <span> < </span>
            </a>
        </td>
        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
            <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                <td <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a href="getBookList.do?method=purchase&page.start=${status.index*page.count}"
                       <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                    >${status.count}</a>
                </td>
            </c:if>
        </c:forEach>

        <td <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="getBookList.do?method=purchase&page.start=${page.start+page.count}">
                <span> > </span>
            </a>
        </td>

        <td <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="getBookList.do?method=purchase&page.start=${page.last}">
                <span> >> </span>
            </a>
        </td>
    </tr>
</table>

</body>
</html>
