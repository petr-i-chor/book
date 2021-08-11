<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    //禁用功能
    $(function () {
        $("tr.pagination td.disabled a").click(function () {
            return false;
        })
    });

</script>

<div align="center">
    <table>
        <thead>
        <tr>
            <td><a href="admin/adminRegister.jsp">注册管理员</a> </td>
            <td><a href="admin/teacherRegister.jsp">注册教师</a> </td>
            <td><a href="admin/studentRegister.jsp">注册学生</a> </td>
            <td><a href="admin/purchaserRegister.jsp">注册采购员</a> </td>
            <td><a href="admin/bookAdd.jsp">添加图书</a> </td>
            <td><a href="showDealtOrder.do">查看未完成订单</a> </td>
            <td><a href="getBookList.do?method=purchase">申请图书采购</a> </td>
            <td><a href="admin/adminModifyPwd.jsp">修改密码</a> </td>
        </tr>
        <tr>
            <td><a href="getAdminsList.do">查看管理员</a> </td>
            <td><a href="getTeacherList.do">查看教师</a> </td>
            <td><a href="getStudentList.do">查看学生</a> </td>
            <td><a href="getPurchaserList.do">查看采购员</a> </td>
            <td><a href="getBookList.do">查看图书</a> </td>
            <td><a href="showFinishOrder.do">查看已完成订单</a> </td>
            <td><a href="showFinishStoreOrder.do">查看图书采购</a> </td>
            <td><a href="logout.do">退出系统</a> </td>
        </tr>
        </thead>
    </table>
</div>
