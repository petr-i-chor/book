<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>Title</title>
    <script type="text/javascript">
        $(function (){
            $("#btnSubmit").click(function () {
                let selector = $("#selector").val();
                let username = $("#username").val();
                let password = $("#password").val();
                $.ajax({
                    url:selector,
                    type:"post",
                    data:{
                        username:username,
                        password:password,
                    },
                    dataType:"json",
                    success:function (data){
                        if (data.Login == "adminLogin"){
                            window.location.href = "admin/admin.jsp";
                        }else if(data.Login =="teacherLogin"){
                            window.location.href = "getBookList.do";
                        }else if(data.Login == "purchaserLogin"){
                            window.location.href = "purchaser/purchaser.jsp";
                        }else if(false){
                            window.location.href = "getBookList.do";
                        }else{
                            alert("用户名密码输入有误，请重新输入！");
                        }
                    }

                })
            })
        });




    </script>
</head>
<body>
<h3>欢迎登陆教材订购系统</h3>
<div align="center">
    <table>
        <tr>
            <td>
                用户名:<input type="text" id="username" name="username" value="T_0001">
            </td>
        </tr>
        <tr>
            <td>
                密&nbsp;&nbsp;&nbsp;&nbsp;码<input type="password" id="password" name="password" value="123456">
            </td>
        </tr>
        <tr>
            <td>
                 <select id="selector">
                     <option value="teacherLogin.do">老师</option>
                     <option value="adminLogin.do">管理员</option>
                     <option value="studentLogin.do">学生</option>
                     <option value="purchaserLogin.do">采购员</option>
                 </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" id="btnSubmit" value="提交">
            </td>
        </tr>
    </table>
</div>
</body>
</html>
