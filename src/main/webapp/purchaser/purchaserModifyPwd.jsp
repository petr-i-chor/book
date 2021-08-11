<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>修改密码</title>

    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {

            $("#btn").click(function () {
                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#newPwd").val();
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
                var rePwdText = $("#rePwd").val();
                //2 和密码相比较
                if (rePwdText != passwordText) {
                    //3 提示用户
                    alert("确认密码和密码不一致！");

                    return false;
                }

                reg()


            })
        })


            function reg(){
                let oldPwd = $("#oldPwd").val()
                let newPwd = $("#newPwd").val();
                let username = $("#username").val();
                $.ajax({
                    url:"purchaserModifyPwd.do",
                    type:"post",
                    dataType:"json",
                    data:{
                        username: username,
                        password:oldPwd,
                        newPwd:newPwd,
                    },
                    success: function(data){
                        if("success"==data.msg){
                            alert("密码修改成功，将在3秒后返回登录界面，请重新登录！");
                            var t=parseInt(3);
                            window.setInterval(function () {
                                if(t>0){
                                    $("#showMsg").html('还剩下<a class="flip-link btn btn-info">'+t+'</a>秒刷新');
                                }else{
                                    window.location.href = "index.jsp";
                                }
                                t--;
                            },1000);
                            // alert("密码修改成功");
                            // window.location.href = "index.jsp";
                        }else{
                            alert("原密码输入有误");
                        }

                    }
                })
            };


    </script>
</head>
<body>
<%@include file="/common/purchaser_menu.jsp"%>
<%--静态包含--%>
<div align="center">
    <h3>修改采购员信息</h3>
</div>
<div align="center" id="showMsg">
    <table>
        <tr>
            <td>
                <input type="hidden" id="username" name="username" value=${sessionScope.username}>
            </td>
        </tr>
        <tr>
            <td>
                原密码:<input type="password" id="oldPwd" name="password" >
            </td>
        </tr>
        <tr>
            <td>
                新密码:<input type="password" id="newPwd" name="password" >
            </td>
        </tr>
        <tr>
            <td>
                确&nbsp;&nbsp;&nbsp;&nbsp;认:<input type="password" id="rePwd" name="password" >
            </td>
        </tr>
        <tr>
            <td>
                <input id="btn"  type="submit" value="提交">
            </td>
        </tr>
    </table>
</div>
</body>
</html>
