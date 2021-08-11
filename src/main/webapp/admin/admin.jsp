<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<%@include file="/common/head.jsp"%>
    <title>管理员主页</title>
</head>
<body>
<%@include file="/common/manager_menu.jsp"%>
<h3>欢迎你，${sessionScope.username}</h3>
</body>
</html>
