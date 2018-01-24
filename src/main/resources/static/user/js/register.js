$(function () {
    $("#register").click(function () {

        var mobilephone = $("#phone").val();
        var createName = $("#name").val();
        var password = $("#psw").val();

        if (canSure(createName, mobilephone, password)) {
            var data = {
                mobilephone,
                createName,
                password
            };

            $.ajax({
                type: "POST",
                url: config.register,
                data: data,
                dataType: "json",
                success: function (res) {
                    if(res.code==0){
                        alert(res.info);
                        window.open("login.html");
                    }else {
                        alert(res.info);
                    }
                },
                error: function (err) {
                    alert("注册失败");
                }
            });
        }
    });
});

function canSure(name, phone, password) {
    var chineseReg = /^[\u4e00-\u9fa5]+$/i;//只能输入中文
    if (!phone || phone == "") {
        alert("手机号码不能为空");
        return false;
    }
    if (!name || name == "") {
        alert("名字不能为空");
        return false;
    }
    if (!chineseReg.test(name)) {
        alert('请输入中文名字');
        return false;
    }
    if (!password) {
        alert('密码为空');
        return false;
    }
    if (password.length < 6) {
        alert('密码至少要6位数');
        return false;
    }
    return true;
}