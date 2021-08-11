<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>管理员注册</title>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            // 给注册绑定单击事件
            $("#btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    alert("用户名不合法！");

                    return false;
                }
                var nameText = $("#name").val();
                //2 创建正则表达式对象
                var namePatt = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
                //3 使用test方法验证
                if (!namePatt.test(nameText)) {
                    //4 提示用户结果
                    alert("昵称不合法！");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    alert("密码不合法！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#repwd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    alert("确认密码和密码不一致！");

                    return false;
                }

                reg()


            })


            function reg(){
                let username = $("#username").val();
                let name = $("#name").val();
                let pwd = $("#password").val();
                let repwd = $("#repwd").val();
                $.ajax({
                    url:"modifyAdmin.do",
                    type:"post",
                    dataType:"json",
                    data:{
                        username: username,
                        name: name,
                        password:pwd,
                        repwd:repwd
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
                <input type="hidden" id="username" name="username" value=${param.username}>
            </td>
        </tr>
        <tr>
            <td>
                昵&nbsp;&nbsp;&nbsp;&nbsp;称:<input type="text" id="name" name="name" value=${param.name}>
            </td>
        </tr>
        <tr>
            <td>
                密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" id="password" name="password" value=${param.password}>
            </td>
        </tr>
        <tr>
            <td>
                确&nbsp;&nbsp;&nbsp;&nbsp;认:<input type="password" id="repwd" name="password" value=${param.password}>
            </td>
        </tr>
        <tr>
            <td>
                <input id="btn"  type="submit" value="提交">
            </td>
        </tr>
    </table>
    <%--    </form>--%>
</div>
</body>
</html>
