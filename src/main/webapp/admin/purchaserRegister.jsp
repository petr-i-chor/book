<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp" %>
    <title>管理员注册</title>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            $("#btn").click(function () {
                var usernameText = $("#username").val();
                var usernamePatt = /^\w{5,12}$/;
                if (!usernamePatt.test(usernameText)) {
                    alert("用户名不合法！");

                    return false;
                }
                var nameText = $("#name").val();
                var namePatt = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
                if (!namePatt.test(nameText)) {
                    alert("昵称不合法！");

                    return false;
                }

                var passwordText = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(passwordText)) {
                    alert("密码不合法！");

                    return false;
                }

                var repwdText = $("#repwd").val();
                if (repwdText != passwordText) {
                    alert("确认密码和密码不一致！");

                    return false;
                }

                var phoneText = $("#phone").val();
                var phonePatt = /^1[3|4|5|7|8][0-9]{9}$/;
                if (!phonePatt.test(phoneText)) {
                    alert("手机号码格式不合法！");

                    return false;
                }


                reg()


            })

            function reg() {
                let username = $("#username").val();
                let name = $("#name").val();
                let pwd = $("#password").val();
                let job = $("#job").val();
                let phone = $("#phone").val();
                $.ajax({
                    url: "addPurchaser.do",
                    type: "post",
                    dataType: "json",
                    data: {
                        username: username,
                        name: name,
                        password: pwd,
                        job: job,
                        phone: phone
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
    <h3>教师注册</h3>
    <table>
        <tr>
            <td>
                用户名:<input type="text" id="username" name="username" value="P_0000">
            </td>
        </tr>
        <tr>
            <td>
                昵&nbsp;&nbsp;&nbsp;&nbsp;称:<input type="text" id="name" name="name" >
            </td>
        </tr>
        <tr>
            <td>
                密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" id="password" name="password" value="123456">
            </td>
        </tr>
        <tr>
            <td>
                确&nbsp;&nbsp;&nbsp;&nbsp;定:<input type="password" id="repwd" name="repwd" value="123456">
            </td>
        </tr>
        <tr>
            <td>
                职&nbsp;&nbsp;&nbsp;&nbsp;位:<input type="text" id="job" name="job" value="科长">
            </td>
        </tr>
        <tr>
            <td>
                手机号:<input type="text" id="phone" name="phone" value="15712345678">
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
