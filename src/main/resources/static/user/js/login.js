var BgDiv = React.createClass({
    render: function () {
        return (
            <div className="bg test row bgImage">
                <div className="col-sm-4 "></div>
                <div className="col-sm-4 centerDivBG ">
                    <h5 className="text-center top25">登录</h5>
                    <input className="top25 input-group form-control" placeholder="手机号" id="phoneInput"></input>
                    <input type="password" className="top25 input-group form-control" placeholder="密码"
                           id="pswInput"></input>
                    <DengluBtn/>
                    <Zhuce/>
                </div>
                <div className="col-sm-4 "></div>
            </div>
        )
    }
});

var DengluBtn = React.createClass({

    gotoOther: function (event) {

        var mobilephone = $("#phoneInput").val();
        var password = $("#pswInput").val();

        if (canSure(mobilephone, password)) {
            var data = {
                mobilephone,
                password: hex_md5(password)
            };

            $.ajax({
                type: "POST",
                url: config.login,
                data: data,
                dataType: "json",
                success: function (res) {
                    if (res.code == 0) {
                        window.location.href = "../../base/index.html";
                    } else {
                        alert(res.info);
                    }
                },
                error: function (err) {
                    alert("登陆失败");
                }
            });
        }
    },
    render: function () {
        return <p onClick={this.gotoOther} className="btn btn-default col-sm-12 top25 text-center test">登录</p>;
    }
});

var Zhuce = React.createClass({

    gotoOther: function (event) {
        window.location.href = "register.html";
    },
    render: function () {
        return <p onClick={this.gotoOther} className="btn btn-default col-sm-12 text-center test">注册</p>;
    }
});

ReactDOM.render(
    <BgDiv />,
    document.getElementById('example')
);

function canSure(phone, password) {
    if (!phone || phone == "") {
        alert("手机号码不能为空");
        return false;
    }
    if (!password) {
        alert('密码为空');
        return false;
    }
    if (!(/^1[34578]\d{9}$/.test(phone))) {
        alert("手机号码有误，请重填");
        return false;
    }
    if (password.length < 6) {
        alert('密码至少要6位数');
        return false;
    }
    return true;
}