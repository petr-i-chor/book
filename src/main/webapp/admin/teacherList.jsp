<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/1.css"  >
    <%@include file="/common/head.jsp" %>
    <title>Title</title>

</head>
<body>
<%@include file="/common/manager_menu.jsp" %>

<!-- 右侧自适应宽度列 -->
<div  align="center">
    <table>
        <thead>
        <tr>
            <td>用户名</td>
            <td>昵称</td>
            <td>密码</td>
            <td>职位</td>
            <td>手机号</td>
        </tr>
        </thead>
        <tbody id="info">

        </tbody>
        <c:forEach items="${teachers}" var="teacher">
            <tr>
                <td>${teacher.username}</td>
                <td>${teacher.name}</td>
                <td>${teacher.password}</td>
                <td>${teacher.job}</td>
                <td>${teacher.phone}</td>
                <td><a href="removeTeacher.do?name=${teacher.name}&page.start=${page.start}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

</div>
<table align="center">
    <tr class="pagination">

        <td <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a href="getTeacherList.do?page.start=0">
                <span> << </span>
            </a>
        </td>

        <td <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a href="getTeacherList.do?page.start=${page.start-page.count}">
                <span> < </span>
            </a>
        </td>
        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
            <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                <td <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a href="getTeacherList.do?page.start=${status.index*page.count}"
                       <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                    >${status.count}</a>
                </td>
            </c:if>
        </c:forEach>

        <td <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="getTeacherList.do?page.start=${page.start+page.count}">
                <span> > </span>
            </a>
        </td>

        <td <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="getTeacherList.do?page.start=${page.last}">
                <span> >> </span>
            </a>
        </td>
    </tr>
</table>
</body>
</html>
