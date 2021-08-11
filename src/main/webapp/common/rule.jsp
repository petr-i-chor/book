<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    // 页面加载完成之后
    $(function () {
        // 给注册绑定单击事件
        $("#btn").click(function () {
            // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
            //1 获取用户名输入框里的内容
            var usernameText = $("#name").val();
            //2 创建正则表达式对象
            var usernamePatt = /^\w{5,12}$/;
            //3 使用test方法验证
            if (!usernamePatt.test(usernameText)) {
                //4 提示用户结果
                $("span.errorMsg").text("用户名不合法！");

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
                $("span.errorMsg").text("密码不合法！");

                return false;
            }

            // 验证确认密码：和密码相同
            //1 获取确认密码内容
            var repwdText = $("#repwd").val();
            //2 和密码相比较
            if (repwdText != passwordText) {
                //3 提示用户
                $("span.errorMsg").text("确认密码和密码不一致！");

                return false;
            }

            // 手机号验证：xxxxx@xxx.com
            //1 获取邮箱里的内容
            var phoneText = $("#phone").val();
            //2 创建正则表达式对象
            var phonePatt = /^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/;
            //3 使用test方法验证是否合法
            if (!phonePatt.test(phoneText)) {
                //4 提示用户
                $("span.errorMsg").text("邮箱格式不合法！");

                return false;
            }



            // 去掉错误信息
            $("span.errorMsg").text("");

        });

    });

</script>
